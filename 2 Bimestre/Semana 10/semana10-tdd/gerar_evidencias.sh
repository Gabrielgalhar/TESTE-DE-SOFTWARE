#!/usr/bin/env bash
# Gera as evidências RED -> GREEN da Semana 10 e o log da suíte completa.
# Uso: ./gerar_evidencias.sh   (precisa de JDK 17 e Maven; a 1ª vez baixa dependências)
cd "$(dirname "$0")"
mkdir -p evidencias
for p in SEMANA10/*/; do
  nome=$(basename "$p")
  main="$p/src/main/java/br/edu/exemplo"
  mkdir -p "$p/.bak" && cp "$main"/*.java "$p/.bak/"
  cp "$p"/stubs/*.java "$main"/
  (cd "$p" && mvn -B clean test > "../../evidencias/$nome-RED.log" 2>&1)
  cp "$p"/.bak/*.java "$main"/ && rm -rf "$p/.bak"
  (cd "$p" && mvn -B clean test > "../../evidencias/$nome-GREEN.log" 2>&1)
  echo "$nome: RED e GREEN gerados"
done
mvn -B clean test > evidencias/suite-completa.log 2>&1
tail -n 25 evidencias/suite-completa.log
