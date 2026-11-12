# Uso (PowerShell, nesta pasta): .\gerar_evidencias.ps1
Set-Location $PSScriptRoot
New-Item -ItemType Directory -Force -Path "evidencias" | Out-Null
cmd /c "mvn -B clean test > evidencias\suite-completa.log 2>&1"
Get-Content evidencias\suite-completa.log -Tail 25
