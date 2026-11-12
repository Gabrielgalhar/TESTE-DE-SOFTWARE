"""Análise dos resultados do Teste de Usuário Final (Aula 014).

Lê dados/observacoes.csv e dados/sus.csv e calcula:
- tempo total por participante e tempo médio;
- taxa de sucesso (adicionou ao carrinho sem ajuda);
- erros por tarefa;
- pontuação SUS por participante e média;
e compara com os critérios de sucesso do plano de teste.

Formato de dados/observacoes.csv (uma linha por tarefa de cada participante):
    participante,tarefa,tempo_s,sucesso,erros,precisou_ajuda,observacoes
    P1,T1,8,S,0,N,
    P1,T5,20,S,1,N,clicou em "Comprar agora" antes

Formato de dados/sus.csv (respostas de 1 a 5):
    participante,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10
    P1,4,2,4,1,4,2,5,2,4,1

Uso:
    python3 analisar_resultados.py
"""

import csv
from collections import defaultdict
from pathlib import Path

DADOS = Path(__file__).parent / "dados"
META_SUCESSO = 0.90       # 90% adicionam ao carrinho
META_TEMPO_S = 240        # 4 minutos
TAREFA_CARRINHO = "T5"


def sim(valor: str) -> bool:
    return valor.strip().upper() in {"S", "SIM", "Y", "YES", "TRUE", "1"}


def ler_csv(nome: str) -> list[dict]:
    caminho = DADOS / nome
    if not caminho.exists():
        return []
    with caminho.open(encoding="utf-8") as arquivo:
        return [linha for linha in csv.DictReader(arquivo) if linha.get("participante", "").strip()]


def pontuacao_sus(respostas: list[int]) -> float:
    if len(respostas) != 10 or not all(1 <= r <= 5 for r in respostas):
        raise ValueError(f"Respostas SUS inválidas: {respostas}")
    soma = sum((r - 1) if i % 2 == 0 else (5 - r) for i, r in enumerate(respostas))
    return soma * 2.5


def classificar_sus(nota: float) -> str:
    if nota >= 85:
        return "Excelente"
    if nota >= 72:
        return "Bom"
    if nota >= 68:
        return "Aceitável"
    if nota > 50:
        return "Ruim / marginal"
    return "Inaceitável"


def analisar_observacoes(linhas: list[dict]) -> None:
    tempos = defaultdict(float)
    ajuda = defaultdict(bool)
    carrinho_ok = defaultdict(bool)
    erros_por_tarefa = defaultdict(int)

    for linha in linhas:
        p = linha["participante"].strip()
        tarefa = linha["tarefa"].strip().upper()
        tempos[p] += float(linha["tempo_s"] or 0)
        erros_por_tarefa[tarefa] += int(linha["erros"] or 0)
        if sim(linha.get("precisou_ajuda", "")):
            ajuda[p] = True
        if tarefa == TAREFA_CARRINHO and sim(linha["sucesso"]):
            carrinho_ok[p] = True

    participantes = sorted(tempos)
    n = len(participantes)
    sucesso = sum(1 for p in participantes if carrinho_ok[p] and not ajuda[p])
    taxa = sucesso / n
    tempo_medio = sum(tempos.values()) / n

    print("== Observações ==")
    print(f"{'Participante':<14}{'Tempo (s)':>10}{'Carrinho':>10}{'Ajuda':>8}")
    for p in participantes:
        print(f"{p:<14}{tempos[p]:>10.0f}{'S' if carrinho_ok[p] else 'N':>10}{'S' if ajuda[p] else 'N':>8}")

    print("\nErros por tarefa:")
    for tarefa in sorted(erros_por_tarefa):
        print(f"  {tarefa}: {erros_por_tarefa[tarefa]}")

    print(f"\nTaxa de sucesso (carrinho sem ajuda): {sucesso}/{n} = {taxa:.0%} "
          f"-> meta {META_SUCESSO:.0%}: {'ATINGIDA' if taxa >= META_SUCESSO else 'NÃO ATINGIDA'}")
    print(f"Tempo médio: {tempo_medio:.0f} s ({tempo_medio / 60:.1f} min) "
          f"-> meta {META_TEMPO_S} s: {'ATINGIDA' if tempo_medio <= META_TEMPO_S else 'NÃO ATINGIDA'}")


def analisar_sus(linhas: list[dict]) -> None:
    print("\n== SUS ==")
    notas = []
    for linha in linhas:
        respostas = [int(linha[f"q{i}"]) for i in range(1, 11)]
        nota = pontuacao_sus(respostas)
        notas.append(nota)
        print(f"{linha['participante']:<14}{nota:>6.1f}  {classificar_sus(nota)}")
    media = sum(notas) / len(notas)
    print(f"Média SUS: {media:.1f} ({classificar_sus(media)})")


def main() -> None:
    observacoes = ler_csv("observacoes.csv")
    respostas_sus = ler_csv("sus.csv")

    if not observacoes and not respostas_sus:
        print("Nenhum dado registrado ainda. Preencha dados/observacoes.csv e dados/sus.csv.")
        return
    if observacoes:
        analisar_observacoes(observacoes)
    if respostas_sus:
        analisar_sus(respostas_sus)


if __name__ == "__main__":
    main()
