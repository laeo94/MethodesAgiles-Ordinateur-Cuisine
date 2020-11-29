#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Parametrer un nouvel ordinateur au sein de la startup
	En tant que Responsable 
	Je veux changer le nom d'un ordinateur avec le nom du nouveau stagiaire
	Afin de pouvoir mettre à disposition cet ordinateur à ce nouveau stagiaire
	
  @tag1
  Scenario Outline: Changer le nom de l'ordinateur
  	Given la modification d'un ordinateur comprenant le nouveau nom <nomOrdi> du stagiaire
  	When le responsable la valide 
  	Then le nouveau nom de l'ordinateur <nouveauNomOrdi> doit être modifier

    Examples: 
      | nomOrdi 	 | nouveauNomOrdi  |
      | "ordiTiti" |    "ordiTiti" 	 |
      | "ordiTata" |    "ordiTata"   |

  
