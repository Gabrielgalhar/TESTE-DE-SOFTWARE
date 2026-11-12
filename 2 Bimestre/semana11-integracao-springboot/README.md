# Testes de integração com Spring Boot — Semana 11

**Aluno:** Gabriel Galhardone Felipe — **RA:** 24021292-2 — **Turma:** ESOFT6S-N

## Como executar

Requisitos: JDK 17 ou superior e Maven 3.9+ (a primeira execução baixa dependências do Maven Central).

```bash
mvn clean test
```

Para gerar o log da execução, rode `gerar_evidencias.ps1` (Windows/PowerShell) ou `gerar_evidencias.sh` (Linux/Mac). O log fica em `evidencias/suite-completa.log`.

## Testes implementados

| Caso | Classe | Método | O que verifica |
|---|---|---|---|
| CT01 | ProdutoServiceIntegrationTest | ct01_cadastroValido | Produto recebe ID e é relido do H2 com nome e preço corretos |
| CT02 | ProdutoServiceIntegrationTest | ct02_nomeEmBrancoNaoCadastra | `IllegalArgumentException` e contagem de registros inalterada |
| CT03 (desafio) | ProdutoServiceIntegrationTest | ct03_atualizarPreco | Mouse de 80,0 atualizado para 95,0 e relido do banco |
| CT04 | ProdutoControllerIntegrationTest | ct04_cadastroViaApi | POST /produtos retorna 200 com ID numérico, nome e preço |
| CT05 | ProdutoControllerIntegrationTest | ct05_consultaViaApi | POST, extração do ID com ObjectMapper e GET /produtos/{id} com 200 e JSON igual |

Os testes usam `@SpringBootTest`, `@Autowired` e `@Transactional`; os testes HTTP usam também `@AutoConfigureMockMvc`. Não há mocks de `ProdutoService` nem de `ProdutoRepository`.

## Resultado da execução

Execução em 12/11/2026, com Apache Maven 3.10.0 e Java 24.0.2: **BUILD SUCCESS, 5 testes aprovados, 0 falhas, 0 erros e 0 ignorados.**

| Classe | Testes aprovados |
|---|---|
| ProdutoServiceIntegrationTest (CT01, CT02, CT03) | 3 |
| ProdutoControllerIntegrationTest (CT04, CT05) | 2 |

Log completo: `evidencias/suite-completa.log`.

## Discussão

**Por que `repository.findById()` dá uma evidência diferente de olhar só o objeto retornado pelo serviço?**
O objeto retornado pode estar correto só na memória. Consultar o repositório confirma que o dado foi gravado e pode ser lido de volta. Como dentro da mesma transação o JPA pode devolver a entidade do cache, os testes usam `flush()` e `clear()` do `EntityManager` antes de reler, forçando a leitura do H2.

**O que `@Transactional` faz ao término de cada teste?**
O Spring desfaz (rollback) a transação ao fim de cada método, então os dados de um teste não afetam os outros.

**Quais componentes o teste HTTP exercita?**
DispatcherServlet, roteamento do Spring MVC, conversão JSON (Jackson), controller, service, repository (Spring Data JPA/Hibernate) e o banco H2.

**Por que o MockMvc não precisa de servidor HTTP real?**
Ele executa a infraestrutura web do Spring dentro do próprio processo, com requisição e resposta simuladas, sem porta de rede.

**Diferença para um teste unitário do controller com dependências simuladas?**
O teste unitário verifica só o controller com respostas programadas dos colaboradores. Este teste verifica as camadas reais trabalhando juntas, inclusive a gravação e a leitura no banco.