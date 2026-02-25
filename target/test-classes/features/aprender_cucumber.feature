# language: pt

Funcionalidade: Aprender Cucumber
  Para que eu possa automatizar critérios de aceite
  Como um desenvolvedor
  Eu quero escrever especificações em Gherkin

  Cenário: Deve executar a especificação com sucesso
    Dado que criei o arquivo corretamente
    Quando executa-lo
    Então a especificacao deve finalizar com sucesso

  Cenário: Deve incrementar contador
    Dado que o valor do contador é 15
    Quando eu incrementar em 5
    Então o valor do contador será 18

  Cenário: Deve incrementar contador
    Dado que o valor do contador é 123
    Quando eu incrementar em 35
    Então o valor do contador será 18

  Cenário: Deve calcular atraso na entrega
    Dado que a entrega é dia 05/04/2018
    Quando a entrega vai atrasar em 2 dias
    Então a entrega sera efetuada em 07/04/2018