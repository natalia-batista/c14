# c14
## Descrição do projeto
Código desenvolvido para as primeiras atividades de Engenharia de Software, consiste em um protótipo de sistema de gerenciamento de voos/aeroportos utilizando grafos (providos pela versão 33.4.8-jre do Guava - dependência do Google).

## Primeira atividade

O código foi desenvolvido em colaboração com a aline-dos-santos. Criamos um conflito propositalmente, alterando a mesma linha de código (configuração da distância entre os dois aeroportos). Ao tentar realizar o merge da branch novoAeroporto foi apontado um conflito de merge.
Para resolvê-lo, fiz um git pull para o meu repo local, seguido de um git merge origin/novoAeroporto. Após o conflito ser apontado, abri o código no vscode e segui as instruções de correção, mantendo apenas a linha de código alterada na branch novoAeroporto. Segui as instruções do próprio vscode para commitar e mandar o código para o repositório central.

Também adicionei as classes Airline e Passenger, usando outras branchs (airline e passenger)

## Segunda atividade

### Histórico de Erros / Regressões

Regressão em FlightInfo.pricePerKm()
Erro introduzido: Removida a verificação de distância positiva.
Testes que falharam: testPricePerkm2

Correção aplicada: Restaurada verificação de `distance > 0` e lançamento de exceção para valores inválidos.
Resultado: O teste passou novamente.


