Feature: Free CRM create Contacts
  Scenario Outline: Free CRM create a new contact scenario
    Given user already in login Page
    When title of login page is <"title">
    Then user enters <"username"> and <"password">
    Then user click to login Button
    Then user is on Home Page
    Then user moves to new contact page
    Then user enters details <"firstName"> and <"lastName"> and <"position">
    Then close the browser
    Examples:
      | "title" | "username" | "password" | "firstName" | "lastName" | "position" |
      | Cogmento CRM |amrin01@gmail.com|Amrin7890|Amrin |Nargis      |Manager     |
      | Cogmento CRM |amrin01@gmail.com|Amrin7890|Tom |Siebel        |Manager     |