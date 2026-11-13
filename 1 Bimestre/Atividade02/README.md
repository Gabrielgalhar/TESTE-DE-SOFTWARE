# Atividade 04 — Teste funcional com Playwright

Testes automatizados das interfaces **Calcular frete** e **Criar senha**, conforme a atividade da Semana 04.

## Cobertura

- Frete: CEP válido e inválido; CEP iniciado ou não por `8`; pedidos abaixo, no limite e acima de R$ 200,00; valores vazios, zero, negativos e com precisão inválida.
- Senha: limites de 8 e 20 caracteres; ausência de maiúscula, minúscula ou número; espaços; confirmação diferente; limpeza do formulário após o cadastro bem-sucedido.

## Como executar

```powershell
cd atv04\playwright-funcional
npm install
npm run browsers
npm test
```

Para abrir o relatório depois da execução, use `npm run report`.
