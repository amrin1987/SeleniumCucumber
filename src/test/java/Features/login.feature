Feature: FreeCRM login feature

  Scenario Outline: FreeCRM Login TestScenario
    Given User already available in login Page
    When Title of log in Page is "<arg0>"
    Then user enter "<userName>" and "<password>"
    Then user clicks to login Button
    And user is in Home Page
    And close the browser
    Examples:
      | arg0         |userName         |password|
      | Cogmento CRM |amrin01@gmail.com|Amrin7890|
      |Cogmento CRM  |amrinwahid01@gmail.com|Password|


