# Questionário SUS — System Usability Scale

Responda cada afirmação de **1 (discordo totalmente)** a **5 (concordo totalmente)**,
pensando na experiência que você acabou de ter no Mercado Livre.

| # | Afirmação | 1 | 2 | 3 | 4 | 5 |
|---|---|---|---|---|---|---|
| 1 | Eu acho que gostaria de usar este site com frequência. | | | | | |
| 2 | Eu achei o site desnecessariamente complexo. | | | | | |
| 3 | Eu achei o site fácil de usar. | | | | | |
| 4 | Eu acho que precisaria de ajuda de uma pessoa técnica para usar este site. | | | | | |
| 5 | Eu achei que as funções do site estavam bem integradas. | | | | | |
| 6 | Eu achei que havia muita inconsistência no site. | | | | | |
| 7 | Eu imagino que a maioria das pessoas aprenderia a usar este site rapidamente. | | | | | |
| 8 | Eu achei o site muito complicado de usar. | | | | | |
| 9 | Eu me senti muito confiante usando o site. | | | | | |
| 10 | Eu precisei aprender várias coisas antes de conseguir usar o site. | | | | | |

## Cálculo da pontuação

1. Itens **ímpares** (1, 3, 5, 7, 9): contribuição = resposta − 1
2. Itens **pares** (2, 4, 6, 8, 10): contribuição = 5 − resposta
3. **SUS = soma das contribuições × 2,5** (resultado de 0 a 100)

## Interpretação

| Pontuação | Classificação |
|---|---|
| ≥ 85 | Excelente |
| 72 – 84 | Bom |
| 68 – 71 | Aceitável (média de mercado) |
| 51 – 67 | Ruim / marginal |
| ≤ 50 | Inaceitável |

O cálculo é feito automaticamente por `analisar_resultados.py` a partir de `dados/sus.csv`.
