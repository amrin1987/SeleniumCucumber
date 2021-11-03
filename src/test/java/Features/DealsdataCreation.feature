Feature: Deal data Creation

  Scenario: Free CRM create a new deal scanrio
    Given user already present in login Page
    When tile page is Cogmento CRM
    Then user enter username and password
      | username          | password  |
      | amrin01@gmail.com | Amrin7890 |
    Then user clicks on login button
    Then user is on home page
    Then user moves to new deal page
    Then user enters deal details
      | title     | amount | commison | probability |
      | test deal | 1000   | 50       | 10          |

    Then Close the browsers