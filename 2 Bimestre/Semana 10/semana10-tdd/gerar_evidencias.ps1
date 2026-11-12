# Gera as evidencias RED -> GREEN da Semana 10 e o log da suite completa.
# Uso (PowerShell, na pasta deste arquivo): .\gerar_evidencias.ps1
# Precisa de JDK 17 e Maven; a 1a vez baixa dependencias.
$raiz = $PSScriptRoot
Set-Location $raiz
New-Item -ItemType Directory -Force -Path "evidencias" | Out-Null
foreach ($proj in Get-ChildItem "SEMANA10" -Directory) {
    $nome = $proj.Name
    $main = Join-Path $proj.FullName "src\main\java\br\edu\exemplo"
    $bak  = Join-Path $proj.FullName ".bak"
    New-Item -ItemType Directory -Force -Path $bak | Out-Null
    Copy-Item "$main\*.java" $bak
    Copy-Item "$($proj.FullName)\stubs\*.java" $main -Force
    Push-Location $proj.FullName
    cmd /c "mvn -B clean test > ""$raiz\evidencias\$nome-RED.log"" 2>&1"
    Pop-Location
    Copy-Item "$bak\*.java" $main -Force
    Remove-Item $bak -Recurse -Force
    Push-Location $proj.FullName
    cmd /c "mvn -B clean test > ""$raiz\evidencias\$nome-GREEN.log"" 2>&1"
    Pop-Location
    Write-Host "${nome}: RED e GREEN gerados"
}
cmd /c "mvn -B clean test > evidencias\suite-completa.log 2>&1"
Get-Content evidencias\suite-completa.log -Tail 25
