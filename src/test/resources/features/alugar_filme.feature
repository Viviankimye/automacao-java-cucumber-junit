# language: pt

Funcionalidade: Alugar filme
  Como um usuario
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

Cenário: Deve alugar um filme com sucesso
    Dado um filme com estoque de 2 unidades
    E que o preço do aluguel seja R$ 3
    Quando alugar
    Então o preço do aluguel sera R$ 3
    E a data de entrega será no dia seguinte
    E o estoque do filme sera 1 unidade

Esquema do Cenário: Deve dar condicoes conforme tipo de aluguel
  Dado um filme com estoque de 2 unidades
  E que o preço do aluguel seja R$ <preco>
  E que o tipo do aluguel seja <tipo>
  Quando alugar
  Então o preço do aluguel sera R$ <valor>
  E a data de entrega sera em <qtdDias> dias
  E a pontuacao recebida sera de <pontuacao> pontos

Exemplos:
  |preco|tipo      |valor |qtdDias |pontuacao |
  |  4  |"extendido"|   8  |   3    |    2     |
  |  4  |"comum"    |   4  |   1    |    1     |
  |  10 |"extendido" |  20  |   3    |    2     |

#Cenário: Nao deve alugar filme sem estoque
#      Dado um filme com estoque de 0 unidades
#      Quando alugar
#      Então não sera possivel por falta de estoque
#      E o estoque do filme sera 0 unidade
