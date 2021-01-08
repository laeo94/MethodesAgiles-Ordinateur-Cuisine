@tag
Feature: US_02 Parametrer une nouvelle imprimante
    En tant que Responsable 
    Je veux ajouter une nouvelle imprimante au sein du réseau
    Afin de pouvoir mettre à disposition cette imprimante à l'équipe
    
  @tag1
  Scenario Outline: Ajouter une imprimante en indiquant au réseau en indiquant son nom et sa marque
      Given L'ajout d'une imprimante comprend le <nom> et la <marque> de l'imprimante
      When le responsable valide le changement
      Then l'imprimante affiche son <nomcomplet>
      
    Examples: 
      | nom    				| marque      | 		nomcomplet  			 |
      | "impDauphine" |    "HP"  		|  "impDauphine/HP"      |
    
      
	@tag2
  Scenario Outline: Ajouter un ordinateur à l'imprimante
      Given L'ajout de l'ordinateur de <nom> et de la <marque> à l'imprimante
      When le responsable valide l'ajout
      Then l'imprimante affiche sa liste des ordinateurs connectés <ordiconnectes>
      
    Examples: 
      | nom        | marque   |    ordiconnectes       |
      | "ordiToto" |    "Dell"|  " ordiToto" 					 |
      | "ordiTiti" |    "Asus"|  " ordiToto ordiTiti"  |
      
      