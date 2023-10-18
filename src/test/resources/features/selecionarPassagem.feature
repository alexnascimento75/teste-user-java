##language: pt
#  Funcionalidade: Selecionar Passagem
#    Cenário: Selecionar Passagem com Sucesso
#      Dado que acesso o site Blazedemo
#      Quando seleciono a origem como "São Paolo" e destino "Berlin"
#      E clico em Procurar Vôo
#      Então exibe a frase indicando vôo entre "são Paolo" e "Berlin"



Feature: Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem como "São Paolo" e destino "Berlin"
    And clico em Procurar Vôo
    Then exibe a frase indicando vôo entre "São Paolo" e "Berlin"
