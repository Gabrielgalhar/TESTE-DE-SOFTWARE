import { expect, test } from '@playwright/test';

type CasoSenha = { senha: string; confirmacao: string; esperado: string; role: 'status' | 'alert'; classe: string };

const casos: CasoSenha[] = [
  { senha: 'Abcdef1!', confirmacao: 'Abcdef1!', esperado: 'Senha cadastrada', role: 'status', classe: 'limite mínimo de oito caracteres' },
  { senha: 'Abcdefghijklmnopqr1!', confirmacao: 'Abcdefghijklmnopqr1!', esperado: 'Senha cadastrada', role: 'status', classe: 'limite máximo de vinte caracteres' },
  { senha: 'Abcdefghijklmnopqr1!x', confirmacao: 'Abcdefghijklmnopqr1!x', esperado: 'Senha fora do padrão', role: 'alert', classe: 'acima do limite máximo' },
  { senha: 'Abcde1!', confirmacao: 'Abcde1!', esperado: 'Senha fora do padrão', role: 'alert', classe: 'abaixo do limite mínimo' },
  { senha: 'abcdef12', confirmacao: 'abcdef12', esperado: 'Senha fora do padrão', role: 'alert', classe: 'sem letra maiúscula' },
  { senha: 'ABCDEFG1', confirmacao: 'ABCDEFG1', esperado: 'Senha fora do padrão', role: 'alert', classe: 'sem letra minúscula' },
  { senha: 'Abcdefgh', confirmacao: 'Abcdefgh', esperado: 'Senha fora do padrão', role: 'alert', classe: 'sem número' },
  { senha: 'Abcdef 1', confirmacao: 'Abcdef 1', esperado: 'Senha fora do padrão', role: 'alert', classe: 'com espaço' },
  { senha: 'Abcdef1!', confirmacao: 'Abcdef2!', esperado: 'As senhas não coincidem', role: 'alert', classe: 'confirmação diferente' },
];

for (const caso of casos) {
  test(`senha: ${caso.classe}`, async ({ page }) => {
    await page.goto('/senha');
    await page.getByLabel('Nova senha').fill(caso.senha);
    await page.getByLabel('Confirmar senha').fill(caso.confirmacao);
    await page.getByRole('button', { name: 'Cadastrar senha' }).click();

    const resultado = page.locator('#resultado');
    await expect(resultado).toBeVisible();
    await expect(resultado).toHaveText(caso.esperado);
    await expect(resultado).toHaveAttribute('role', caso.role);

    if (caso.role === 'status') {
      await expect(page.getByLabel('Nova senha')).toHaveValue('');
      await expect(page.getByLabel('Confirmar senha')).toHaveValue('');
    }
  });
}
