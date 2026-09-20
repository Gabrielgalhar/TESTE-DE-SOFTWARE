import { expect, test } from '@playwright/test';

type CasoFrete = { cep: string; valor: string; esperado: string; role: 'status' | 'alert'; classe: string };

const casos: CasoFrete[] = [
  { cep: '80000000', valor: '1', esperado: 'Frete: R$ 15,00', role: 'status', classe: 'pedido válido mínimo acima de zero para CEP iniciado por 8' },
  { cep: '80000000', valor: '199,99', esperado: 'Frete: R$ 15,00', role: 'status', classe: 'valor imediatamente abaixo do frete grátis' },
  { cep: '10000000', valor: '199.99', esperado: 'Frete: R$ 25,00', role: 'status', classe: 'CEP que não inicia por 8' },
  { cep: '80000000', valor: '200', esperado: 'Frete grátis', role: 'status', classe: 'limite de frete grátis' },
  { cep: '10000000', valor: '200,01', esperado: 'Frete grátis', role: 'status', classe: 'acima do limite de frete grátis' },
  { cep: '8000000', valor: '100', esperado: 'Dados inválidos', role: 'alert', classe: 'CEP com sete dígitos' },
  { cep: '800000000', valor: '100', esperado: 'Dados inválidos', role: 'alert', classe: 'CEP com nove dígitos' },
  { cep: '80A00000', valor: '100', esperado: 'Dados inválidos', role: 'alert', classe: 'CEP alfanumérico' },
  { cep: '', valor: '100', esperado: 'Dados inválidos', role: 'alert', classe: 'CEP vazio' },
  { cep: '80000000', valor: '0', esperado: 'Dados inválidos', role: 'alert', classe: 'pedido com valor zero' },
  { cep: '80000000', valor: '-1', esperado: 'Dados inválidos', role: 'alert', classe: 'pedido negativo' },
  { cep: '80000000', valor: '10,999', esperado: 'Dados inválidos', role: 'alert', classe: 'mais de duas casas decimais' },
  { cep: '80000000', valor: '', esperado: 'Dados inválidos', role: 'alert', classe: 'valor vazio' },
];

for (const caso of casos) {
  test(`frete: ${caso.classe}`, async ({ page }) => {
    await page.goto('/frete');
    await page.getByLabel('CEP').fill(caso.cep);
    await page.getByLabel('Valor do pedido').fill(caso.valor);
    await page.getByRole('button', { name: 'Calcular frete' }).click();

    const resultado = page.locator('#resultado');
    await expect(resultado).toBeVisible();
    await expect(resultado).toHaveText(caso.esperado);
    await expect(resultado).toHaveAttribute('role', caso.role);
  });
}
