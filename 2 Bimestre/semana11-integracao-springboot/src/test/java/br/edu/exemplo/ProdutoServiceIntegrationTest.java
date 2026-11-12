package br.edu.exemplo;

import static org.junit.jupiter.api.Assertions.*;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private EntityManager entityManager;

    // Envia as alterações ao H2 e limpa o cache da sessão, para que o
    // findById seguinte realmente leia do banco.
    private void sincronizarComBanco() {
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void ct01_cadastroValido() {
        Produto salvo = service.cadastrar("Teclado", 150.0);
        assertNotNull(salvo.getId());

        sincronizarComBanco();

        Produto doBanco = repository.findById(salvo.getId()).orElseThrow();
        assertEquals("Teclado", doBanco.getNome());
        assertEquals(150.0, doBanco.getPreco());
    }

    @Test
    void ct02_nomeEmBrancoNaoCadastra() {
        long antes = repository.count();

        assertThrows(IllegalArgumentException.class, () -> service.cadastrar("   ", 80.0));

        assertEquals(antes, repository.count());
    }

    @Test
    void ct03_atualizarPreco() {
        Produto mouse = service.cadastrar("Mouse", 80.0);
        Long id = mouse.getId();
        sincronizarComBanco();

        service.atualizarPreco(id, 95.0);
        sincronizarComBanco();

        assertEquals(95.0, repository.findById(id).orElseThrow().getPreco());
    }
}
