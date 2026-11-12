# Relatório de Resultados — Teste de Usuário Final

>  **Dados simulados.** Os valores deste relatório e dos arquivos em `dados/` são fictícios, criados para demonstrar o preenchimento da planilha, o cálculo das métricas e a análise. Eles não vêm de uma sessão real com participantes.

## 1. Identificação

| **Item** | **Valor** |
|---|---|
| Tipo de dados | Simulados (exemplo) |
| Número de participantes | 5 (P1 a P5) |
| Navegador | Google Chrome, janela anônima |
| Tarefas | T1 a T7 (versão `plano_de_teste.md`) |

---

## 2. Resultados quantitativos

A análise foi realizada utilizando o script `analisar_resultados.py`.

### Resultado das observações

```text
== Observações ==
Participante   Tempo (s)  Carrinho   Ajuda
P1                   114         S       N
P2                   215         S       N
P3                   133         S       N
P4                   264         S       N
P5                   163         S       N
```

Todos os cinco participantes conseguiram concluir o fluxo relacionado ao carrinho sem necessidade de ajuda.

### Erros por tarefa

```text
T1: 0
T2: 5
T3: 3
T4: 1
T5: 5
T6: 0
T7: 2
```

O total registrado foi de **16 erros** distribuídos entre as tarefas.

| **Métrica** | **Resultado** | **Meta** | **Atingiu?** |
|---|---:|---:|---|
| Taxa de sucesso (carrinho sem ajuda) | **100% (5/5)** | ≥ 90% |  Sim |
| Tempo médio total | **178 s (3,0 min)** | ≤ 240 s |  Sim |
| Total de erros | **16** | — | — |
| Média SUS | **69,0 (Aceitável)** | ≥ 68 |  Sim |

### Análise dos resultados

A taxa de sucesso foi de **100%**, ou seja, todos os cinco participantes conseguiram concluir o fluxo do carrinho sem precisar de ajuda. Esse resultado ficou acima da meta estabelecida de 90%.

O tempo médio foi de **178 segundos**, equivalente a aproximadamente **3 minutos**. Como a meta definida era de até 240 segundos, o resultado também foi considerado satisfatório.

Apesar dos resultados positivos, foram registrados **16 erros** ao longo das tarefas. A maior concentração ocorreu nas tarefas **T2 e T5**, ambas com 5 erros, seguidas pela T3, com 3 erros.

---

## 3. Resultados do SUS

O questionário SUS apresentou os seguintes resultados:

| **Participante** | **Pontuação SUS** | **Classificação** |
|---|---:|---|
| P1 | 80,0 | Bom |
| P2 | 57,5 | Ruim / marginal |
| P3 | 95,0 | Excelente |
| P4 | 37,5 | Inaceitável |
| P5 | 75,0 | Bom |
| **Média** | **69,0** | **Aceitável** |

A média geral do SUS foi de **69,0 pontos**, sendo classificada como **Aceitável**.

Os resultados individuais mostram uma variação considerável entre os participantes. Enquanto P3 apresentou uma avaliação excelente, com 95 pontos, P4 apresentou 37,5 pontos, classificado como inaceitável. P2 também apresentou uma avaliação abaixo do esperado, com 57,5 pontos.

Isso indica que, apesar de o fluxo ter sido concluído com sucesso pelos participantes, a experiência de uso não foi percebida da mesma maneira por todos.

---

## 4. Principais problemas de usabilidade encontrados

Com base nos erros registrados durante a execução das tarefas, foram identificados os seguintes pontos de atenção:

| **#** | **Tarefa** | **Descrição do problema** | **Quantidade de erros** | **Severidade** |
|---:|---|---|---:|---|
| 1 | T2 | Dificuldades ou enganos durante a busca e identificação dos produtos. | 5 | Média |
| 2 | T5 | Dificuldades ou cliques incorretos durante o processo de adição do produto ao carrinho. | 5 | Alta |
| 3 | T3 | Dificuldades relacionadas à aplicação ou identificação de filtros. | 3 | Média |
| 4 | T7 | Dificuldades para retornar à tela inicial. | 2 | Baixa |
| 5 | T4 | Ocorrência de erro durante a execução da tarefa. | 1 | Baixa |

As tarefas **T2 e T5** concentraram a maior quantidade de erros, com cinco ocorrências cada. Portanto, essas etapas merecem atenção especial em futuras melhorias da interface.

A tarefa **T3**, com três erros, também apresentou dificuldades relacionadas à localização e utilização de recursos da interface.

---

## 5. Pontos positivos

Os resultados também demonstraram diversos aspectos positivos na utilização do sistema:

- **100% dos participantes** conseguiram concluir o fluxo do carrinho sem ajuda.
- O **tempo médio de 178 segundos** ficou abaixo da meta de 240 segundos.
- As tarefas **T1 e T6 não apresentaram erros**, indicando facilidade na execução dessas etapas.
- A maioria dos participantes conseguiu concluir as tarefas propostas.
- A média SUS de **69,0** colocou a usabilidade geral do sistema na classificação **Aceitável**.
- Dois participantes apresentaram avaliações positivas de usabilidade, com pontuações de 80 e 75 pontos.

---

## 6. Recomendações de melhoria

Com base nos resultados encontrados, são recomendadas as seguintes melhorias:

1. **Melhorar a experiência de busca de produtos**, tornando os resultados mais claros e reduzindo a possibilidade de o usuário selecionar uma opção incorreta.

2. **Diferenciar melhor as opções relacionadas ao carrinho**, principalmente os elementos envolvidos na ação de adicionar um produto, evitando cliques incorretos.

3. **Facilitar a localização dos filtros**, utilizando elementos visuais mais destacados e uma organização mais intuitiva.

4. **Melhorar a navegação de retorno**, deixando mais evidente como o usuário pode retornar à tela inicial.

5. **Revisar as etapas que apresentaram maior quantidade de erros**, principalmente T2 e T5.

6. **Realizar novos testes de usabilidade**, principalmente porque os resultados do SUS apresentaram grande diferença entre os participantes.

7. **Investigar a experiência dos usuários com pontuação SUS mais baixa**, buscando identificar quais elementos da interface causaram maior dificuldade ou insatisfação.

---

## 7. Conclusão

Com base nos dados simulados analisados, o teste de usabilidade apresentou **resultados positivos em relação à conclusão das tarefas e ao tempo de execução**.

A taxa de sucesso foi de **100% (5/5)**, superando a meta estabelecida de 90%. Isso demonstra que todos os participantes conseguiram concluir o fluxo do carrinho sem precisar de ajuda.

O tempo médio também apresentou um resultado satisfatório, com **178 segundos (3,0 minutos)**, ficando abaixo da meta de 240 segundos.

Por outro lado, foram identificados **16 erros** durante a execução das tarefas, com maior concentração nas tarefas **T2 — busca de produto** e **T5 — carrinho**, ambas com cinco erros. Esses resultados indicam pontos específicos que podem ser melhorados na interface.

Em relação à satisfação e percepção de usabilidade, a média do **SUS foi de 69,0 pontos**, classificada como **Aceitável**. Entretanto, houve uma diferença significativa entre os participantes, variando de **37,5 a 95 pontos**. Isso demonstra que, embora o sistema permita a conclusão das tarefas, a experiência de uso pode ser melhorada para torná-la mais consistente entre diferentes usuários.

Dessa forma, o teste indica que o sistema **atingiu as metas de sucesso e tempo**, mas ainda apresenta oportunidades de melhoria principalmente nas etapas de busca, carrinho, filtros e navegação.
