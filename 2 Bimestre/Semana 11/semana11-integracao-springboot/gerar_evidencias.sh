#!/usr/bin/env bash
# Uso: ./gerar_evidencias.sh   (JDK 17 e Maven; a 1ª vez baixa dependências)
cd "$(dirname "$0")"
mkdir -p evidencias
mvn -B clean test > evidencias/suite-completa.log 2>&1
tail -n 25 evidencias/suite-completa.log
