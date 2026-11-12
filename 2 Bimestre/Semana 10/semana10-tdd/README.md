# Atividades de Teste de Software — Semana 10 (TDD)

**Aluno:** Gabriel Galhardone Felipe — **RA:** 24021292-2 — **Turma:** <ESOFT6N-B>

## Como executar

Requisitos: JDK 17 ou superior e Maven 3.9+ (a primeira execução baixa dependências do Maven Central). O código é compilado para Java 17.

```bash
mvn clean test
```

Na pasta deste README, o comando executa os quatro projetos. Para rodar um projeto isolado, entre na pasta dele e use `mvn test`.

Para gerar as evidências, rode `gerar_evidencias.ps1` (Windows/PowerShell) ou `gerar_evidencias.sh` (Linux/Mac). Os logs ficam na pasta `evidencias/`.

## Resultado da execução

Execução em 12/11/2026, com Apache Maven 3.10.0 e Java 24.0.2 (compilando para Java 17):
 **BUILD SUCCESS, 31 testes aprovados, 0 falhas, 0 erros e 0 ignorados.**

| Projeto | Testes aprovados |
|---|---|
| bubblesort-tdd | 6 |
| conta-bancaria-tdd-maven | 7 |
| estoque-tdd | 8 |
| carrinho-compras-tdd | 10 |

Log completo: `evidencias/suite-completa.log`.

## Projetos, requisitos e decisões

| Projeto | Requisitos cobertos | Decisões |
|---|---|---|
| bubblesort-tdd | Vetor desordenado, já ordenado, valores repetidos, ordem inversa, negativos, vazio e unitário | Ordenação feita no próprio vetor, com parada antecipada quando uma passada não troca nada |
| conta-bancaria-tdd-maven | Saldo inicial, depósito, acúmulo de depósitos, saque, saque maior que o saldo, saque do saldo total, valores não positivos | Operações inválidas são ignoradas e o saldo não muda |
| estoque-tdd | Estoque inicial 0, entrada, acúmulo, retirada, retirada maior que o estoque, entrada ≤ 0, retirada ≤ 0 | Operações inválidas são ignoradas, então o estoque nunca fica negativo |
| carrinho-compras-tdd | Total vazio, adicionar, somar, remover, preço negativo, desconto de 10% a partir de R$ 500,00 | Preço negativo lança `IllegalArgumentException` no construtor de `Produto`. O desconto vale a partir de 500,00 e foi testado nas fronteiras 499,99 / 500,00 / 500,01 |

## Evidências RED → GREEN

O enunciado pede o ciclo TDD (teste falhando, implementação, teste passando). Para cada projeto, a pasta `evidencias/` guarda:

- `<projeto>-RED.log`: execução dos testes com a **versão inicial incompleta** da classe (guardada na pasta `stubs/` de cada projeto). Os testes falham, o que mostra que eles detectam a ausência do comportamento.
- `<projeto>-GREEN.log`: execução dos mesmos testes com a **implementação final**, todos passando.

Os logs foram gerados pelo script `gerar_evidencias`, que alterna entre a versão inicial e a final e executa `mvn clean test` em cada uma.