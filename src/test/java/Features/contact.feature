Feature: Free CRM create Contacts
  Scenario Outline: Free CRM create a new contact scenario
    Given user already in login Page
    When title of login page is Cogmento CRM
    Then user enters details <"arg0"> and <"arg1">
    Then user click to login Button
    Then user is on Home Page
    Then user moves to new contact page
    Then user enters details <"firstName"> and <"lastName"> and <"position">
    Then close the browser finally
    Examples:
      | "arg0" | "arg1" | "firstName" | "lastName" | "position" |
      |amrin01@gmail.com|Amrin7890|Amrin |Nargis      |Manager     |
      |amrin01@gmail.com|Amrin7890|Tom |Siebel        |Manager     |