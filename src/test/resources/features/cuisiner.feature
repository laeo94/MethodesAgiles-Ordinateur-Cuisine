Feature: Recrutement

  @MyScenario
  
  Scenario: En tant que Cuisine, je veux pouvoir recruter un chef quand j en ai besoin
    Given je suis une cuisine
    When je recrute un chef libre
    Then le chef devra apparaitre dans ma liste de chefs

  Scenario Outline: En tant que Cuisine, je veux pouvoir renvoyer un Chef en precisant son nom
    Given je suis une cuisine
    When le nom "<nom>" du chef est valide
    And j expulse un chef portant le nom "<nom>"
    Then le chef portant ce nom ne devrait pas apparaitre dans la liste de chefs

    Examples: 
      | nom  |
      | Paul |

  Scenario: En tant que Chef, je veux pourvoir quitter une cuisine
    Given je suis un Chef
    Given j appartiens a une cuisine
    When je quitte cuisine
    Then je n apparais plus dans la liste chefs de la cuisine que j ai quitte
    And je n appartiens plus a aucune cuisine

  Scenario: En tant que Responsable, je souhaite pouvoir recuperer la liste des chefs individuellement
    Given Je suis un responsable d une cuisine
    When je recupere la liste
    Then la liste des chefs s affiche
