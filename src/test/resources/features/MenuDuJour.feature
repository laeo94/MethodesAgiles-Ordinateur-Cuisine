Feature: US_09 Rédaction du menu du jour

  @tag1
  Scenario Outline: Rédiger le menu
    Given En tant que chef <nomChef> de cuisine je veux pouvoir rédiger le menu du jour
    When j écris sur l ordinateur le <menu>
    Then le <menuFinal> est enregistré sur l'ordinateur du chef <nomOrdi>

    Examples: 
      | nomChef | menu            | menuFinal             | nomOrdi |
      | "Toto"  | "burger frites" | "Toto: burger frites" | "Toto"  |
      | "Tata"  | "poulet frites" | "Tata: poulet frites" | "Tata"  |

  @tag2
  Scenario Outline: Imprimer un menu
    Given En tant que chef <nomChef> je souhaite imprimer mon menu du jour établi sur mon ordinateur <nomOrdi>
    When je demande d imprimer le menu <monMenu>
    Then le <menu> s imprime

    Examples: 
      | nomChef | nomOrdi | monMenu               | menu                  |
      | "Toto"  | "Toto"  | "Toto: burger frites" | "Toto: burger frites" |
      | "Tata"  | "Tata"  | "Tata: poulet frites" | "Tata: poulet frites" |
