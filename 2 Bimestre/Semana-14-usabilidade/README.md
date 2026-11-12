# Aula 014 — Teste de Usuário Final (Usabilidade)

Atividade da Semana 14: teste de usuário final do fluxo de **busca, comparação e simulação de compra** no site do Mercado Livre, aplicando conceitos de IHC e testes de usabilidade.

## Estrutura do projeto

| **Arquivo** | **Conteúdo** |
|---|---|
| `plano_de_teste.md` | Plano do teste: objetivo, cenário, tarefas, métricas, critérios de sucesso, papéis e roteiro de aplicação. |
| `planilha_observacao.md` | Planilha de observação por participante, contendo tempo, sucesso, erros e observações. |
| `questionario_sus.md` | Questionário SUS (System Usability Scale) e forma de cálculo. |
| `dados/observacoes.csv` | Dados das observações realizadas durante as tarefas. |
| `dados/sus.csv` | Respostas do questionário SUS por participante. |
| `analisar_resultados.py` | Script responsável por calcular tempo médio, taxa de sucesso, quantidade de erros e pontuação SUS. |
| `relatorio_resultados.md` | Relatório final contendo os resultados, problemas encontrados e recomendações de melhoria. |

## Resumo dos resultados

> ⚠️ **Dados simulados.** Os dados utilizados neste projeto são fictícios e foram criados para demonstrar a aplicação de testes de usabilidade, preenchimento das planilhas e cálculo das métricas.

Os resultados obtidos pela execução do `analisar_resultados.py` foram:

| **Métrica** | **Resultado** | **Meta** | **Status** |
|---|---:|---:|---|
| Taxa de sucesso | **100% (5/5)** | ≥ 90% | ✅ Atingida |
| Tempo médio | **178 s (3,0 min)** | ≤ 240 s | ✅ Atingida |
| Total de erros | **16** | — | — |
| SUS médio | **69,0** | ≥ 68 | ✅ Atingida |

### Resultados por participante

| **Participante** | **Tempo (s)** | **Carrinho** | **Ajuda** |
|---|---:|:---:|:---:|
| P1 | 114 | S | N |
| P2 | 215 | S | N |
| P3 | 133 | S | N |
| P4 | 264 | S | N |
| P5 | 163 | S | N |

Todos os participantes conseguiram concluir o fluxo do carrinho sem necessidade de ajuda, resultando em uma taxa de sucesso de **100%**.

### Erros por tarefa

| **Tarefa** | **Erros** |
|---|---:|
| T1 | 0 |
| T2 | 5 |
| T3 | 3 |
| T4 | 1 |
| T5 | 5 |
| T6 | 0 |
| T7 | 2 |
| **Total** | **16** |

As tarefas **T2 e T5** apresentaram a maior quantidade de erros, com 5 ocorrências cada. A tarefa T3 apresentou 3 erros, enquanto T7 apresentou 2.

## Resultado do SUS

O questionário SUS apresentou os seguintes resultados:

| **Participante** | **Pontuação SUS** | **Classificação** |
|---|---:|---|
| P1 | 80,0 | Bom |
| P2 | 57,5 | Ruim / marginal |
| P3 | 95,0 | Excelente |
| P4 | 37,5 | Inaceitável |
| P5 | 75,0 | Bom |
| **Média** | **69,0** | **Aceitável** |

A média geral de **69,0 pontos** indica uma usabilidade **aceitável** segundo os critérios utilizados no projeto.

Apesar da média estar acima de 68 pontos, houve uma diferença significativa entre os participantes. P3 apresentou uma avaliação excelente, enquanto P4 apresentou uma avaliação inaceitável.

## Problemas principais encontrados

Durante a análise dos resultados, foram identificados alguns pontos de atenção:

- **T2 — Busca de produto:** apresentou 5 erros, indicando dificuldades durante a busca ou identificação dos produtos.
- **T3 — Filtros:** apresentou 3 erros, demonstrando que alguns usuários tiveram dificuldades para utilizar ou localizar os filtros.
- **T5 — Carrinho:** apresentou 5 erros, sendo uma das etapas com maior quantidade de problemas.
- **T7 — Retorno à tela inicial:** apresentou 2 erros, indicando pequenas dificuldades de navegação.
- **T4:** apresentou 1 erro durante sua execução.

Os resultados indicam que as etapas de **busca e carrinho** merecem atenção especial por concentrarem a maior quantidade de erros.

## Pontos positivos

Os testes também apresentaram resultados positivos:

- **100% dos participantes** conseguiram concluir o fluxo do carrinho sem ajuda.
- A taxa de sucesso de **100%** superou a meta estabelecida de 90%.
- O tempo médio de **178 segundos** ficou abaixo da meta de 240 segundos.
- As tarefas T1 e T6 não apresentaram erros.
- A média SUS de **69,0 pontos** foi classificada como aceitável.
- O participante P3 apresentou uma excelente percepção de usabilidade, com **95 pontos no SUS**.

## Recomendações de melhoria

Com base nos resultados obtidos, são recomendadas as seguintes melhorias:

1. **Melhorar a busca de produtos**, tornando os resultados mais claros e reduzindo a possibilidade de seleção incorreta.

2. **Facilitar a utilização dos filtros**, deixando as opções mais visíveis e organizadas para o usuário.

3. **Melhorar a identificação das opções relacionadas ao carrinho**, evitando cliques incorretos e tornando as ações mais claras.

4. **Aprimorar a navegação de retorno**, facilitando o retorno à página inicial.

5. **Reavaliar as tarefas T2 e T5**, pois apresentaram a maior quantidade de erros.

6. **Realizar novos testes com usuários**, principalmente para investigar as diferenças nas avaliações do SUS.

## Como executar o projeto

### 1. Acesse a pasta do projeto

No PowerShell, navegue até a pasta onde o projeto está localizado:

```powershell
cd "C:\Users\Gabriel.Galhardone\Desktop\2 Bimestre\Semana 14\aula-014-usabilidade"
```

### 2. Verifique os arquivos

Execute:

```powershell
dir
```

O projeto deverá conter o arquivo:

```text
analisar_resultados.py
```

e a pasta:

```text
dados
```

### 3. Execute a análise

Execute:

```powershell
python analisar_resultados.py
```

O script irá calcular automaticamente:

- tempo médio;
- taxa de sucesso;
- erros por tarefa;
- resultados individuais do SUS;
- média do SUS;
- classificação da usabilidade;
- comparação dos resultados com as metas estabelecidas.

## Critérios de sucesso

Os critérios utilizados neste teste foram:

- **90% ou mais** dos usuários deverão conseguir adicionar o produto ao carrinho sem ajuda.
- O **tempo médio** para concluir o teste deverá ser de, no máximo, **4 minutos (240 segundos)**.
- A média do SUS deverá ser de pelo menos **68 pontos**, considerada aceitável.

### Resultado final

Os dois principais critérios de desempenho foram atingidos:

**Taxa de sucesso:** 100% → ✅ Meta de 90% atingida.

**Tempo médio:** 178 segundos → ✅ Meta de 240 segundos atingida.

**SUS:** 69,0 pontos → ✅ Classificação aceitável.

## Conclusão

O teste de usabilidade apresentou resultados positivos. Todos os participantes conseguiram concluir o fluxo do carrinho sem ajuda, resultando em uma taxa de sucesso de **100%**, acima da meta estabelecida de 90%.

O tempo médio também foi satisfatório, com **178 segundos (3,0 minutos)**, ficando abaixo do limite de 240 segundos.

Entretanto, foram identificados **16 erros** durante a execução das tarefas, principalmente nas etapas **T2 — busca de produto** e **T5 — carrinho**, que apresentaram 5 erros cada.

Em relação à satisfação dos usuários, a média SUS foi de **69,0 pontos**, classificada como **Aceitável**. Apesar de o resultado geral ser positivo, a diferença entre as pontuações individuais demonstra que a experiência de uso pode ser melhorada para proporcionar uma experiência mais consistente entre os usuários.

Dessa forma, o sistema **atingiu as metas de sucesso e tempo**, mas ainda possui oportunidades de melhoria relacionadas principalmente à busca de produtos, utilização dos filtros, interação com o carrinho e navegação.
