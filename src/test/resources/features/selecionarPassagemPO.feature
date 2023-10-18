Feature: Selecionar Passagem
  Scenario: Selecionar Passagem com Sucesso
    Given que acesso o site Blazedemo
    When seleciono a origem como "São Paolo" e destino "Berlin"
    And clico em Procurar Vôo
    Then exibe a frase indicando vôo entre "São Paolo" e "Berlin"
