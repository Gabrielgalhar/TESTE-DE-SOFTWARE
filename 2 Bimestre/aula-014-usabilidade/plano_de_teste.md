# Plano de Teste de Usuário Final — Mercado Livre

## 1. Objetivo do teste

Avaliar a **facilidade de uso**, a **eficiência** e a **clareza da interface** durante as etapas
de busca, comparação e simulação de compra de um produto no site Mercado Livre.

## 2. Escopo

| Dentro do escopo | Fora do escopo |
|---|---|
| Página inicial, busca, filtros e ordenação | Pagamento e finalização da compra |
| Página de detalhes do produto | Cadastro de nova conta |
| Carrinho e início do checkout | Aplicativo mobile |

## 3. Cenário de uso (lido para o participante)

> Você está procurando um **fone de ouvido sem fio** para uso diário e quer comprar pelo Mercado
> Livre. Seu objetivo é encontrar um modelo com **boa avaliação**, comparar opções e simular a
> compra até o carrinho, **sem finalizar o pagamento**.

## 4. Tarefas

| ID | Tarefa | Critério de conclusão |
|---|---|---|
| T1 | Acessar o site https://www.mercadolivre.com.br | Página inicial carregada |
| T2 | Pesquisar "fone de ouvido Bluetooth" | Lista de resultados exibida |
| T3a | Filtrar apenas produtos com entrega **Full** | Filtro "Full" aplicado |
| T3b | Ordenar pelos **melhores avaliados** | Ordenação aplicada |
| T4 | Escolher um produto e acessar os detalhes | Página do produto aberta |
| T5 | Adicionar o item ao carrinho | Item aparece no carrinho |
| T6 | Simular o início da compra (sem pagar) | Tela de entrega/pagamento exibida; **não** confirmar |
| T7 | Retornar à tela inicial | Página inicial exibida |

## 5. Participantes e papéis

| Papel | Descrição |
|---|---|
| Usuário final | Aluno que executa as tarefas como comprador. |
| Avaliador | Colega que observa e registra tempo, erros e comentários. Não ajuda o usuário, exceto se ele desistir. |
| Instrutor | Professor que orienta e supervisiona o teste. |

Recomenda-se **no mínimo 5 participantes**, para que a taxa de sucesso seja significativa.

## 6. Métricas coletadas

| Métrica | Descrição | Como medir |
|---|---|---|
| Tempo de execução | Tempo total para completar todas as tarefas. | Cronômetro: início em T1, fim em T7 (segundos). |
| Taxa de sucesso | Quantos usuários concluíram o fluxo sem ajuda. | `concluíram sem ajuda / total de participantes`. |
| Erros cometidos | Cliques incorretos, perda do caminho, confusão nos filtros. | Contagem por tarefa na planilha de observação. |
| Satisfação | Percepção de usabilidade. | Questionário SUS (0 a 100). |

### Classificação dos erros

| Código | Tipo de erro | Exemplo |
|---|---|---|
| E1 | Clique incorreto | Clicar em anúncio/banner em vez do resultado desejado |
| E2 | Perda de caminho | Voltar várias páginas sem saber onde está |
| E3 | Confusão em filtros | Não encontrar o filtro "Full" ou a opção de ordenação |
| E4 | Pedido de ajuda | Usuário pergunta ao avaliador como prosseguir |

## 7. Critérios de sucesso

- **≥ 90%** dos usuários adicionam o produto ao carrinho (T5) sem ajuda.
- **Tempo médio ≤ 4 minutos (240 s)** para concluir o teste.
- Referência complementar: **SUS ≥ 68** (média de mercado).

## 8. Ambiente e ferramentas

- Navegador web (Google Chrome, Firefox ou Edge), janela anônima para evitar histórico/cookies.
- Cronômetro ou celular para medir tempo.
- Planilha de observação ([`planilha_observacao.md`](planilha_observacao.md) ou `dados/observacoes.csv`).
- Formulário SUS ([`questionario_sus.md`](questionario_sus.md), impresso ou no Google Forms).

## 9. Roteiro de aplicação

1. Explicar ao participante que **o site está sendo avaliado, não ele**.
2. Pedir que pense em voz alta (*think aloud*) enquanto executa as tarefas.
3. Ler o cenário e iniciar o cronômetro.
4. Registrar tempo, sucesso e erros de cada tarefa, sem interferir.
5. Ao final, aplicar o questionário SUS.
6. Fazer uma breve entrevista: *O que foi mais difícil? O que foi mais fácil? O que você mudaria?*

## 10. Riscos e cuidados

- **Não** finalizar pagamento nem informar dados reais de cartão.
- O layout do site pode mudar entre participantes (testes A/B do próprio site); registrar nas observações.
- Usuários que já usam o Mercado Livre com frequência tendem a ser mais rápidos; registrar o perfil de cada um.
