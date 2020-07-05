
Feature: Login into Application
 # Background:
  #  Given the user is on the login page

  #Scenario: Login with valid user and valid password.
  #  Given the user fills login equal "robson"
  #  And the user fills password equal "agapito"
  #  When the user clicks on login button
   # Then the user should see "Success Login!" into "sucess" page

  Scenario Outline: Login with invalid options - <description>
    Given the user is on the login page
    And the user fills login equal "<user>"
    And the user fills password equal "<pass>"
    When the user clicks on login button
    Then the user should see "<result>" into "<page>" page

    Examples:
      | description                       | user   | pass    | result         | page    |
      | valid user and valid password     | robson | agapito | Success Login! | success |
      | Invalid user and valid password   | lindao | agapito | Fail Login!    | fail    |
      | Valid user and invalid password   | robson | lindao  | Fail Login!    | fail    |
      | Invalid user and invalid password | lidao  | lindao  | Fail Login!    | fail    |

