Feature: CRUD User

  Background:
    Given the user is on Agapito Server page
    And the user clicks on User menu
    And the user clicks on new user button
    And the user fill "login" with value equal "Leonardovaleriano"
    And the user fill "fullName" with value equal "Leonardo Consani Valeriano"
    And the user fill "email" with value equal "leonardo.valeriano@faculdadeimpacta.com.br"
    And the user fill "age" with value equal "26"
    And the user clicks on save button

  Scenario: Create a new user
    Then the user should see "Usuário foi criado com sucesso." into view user page

  Scenario: Read an user.
    Given the user backs to the user grid
    When the user clicks on show button
    Then the user should see "login" with value equal "Leonardovaleriano"
    And the user should see "full_name" with value equal "Leonardo Consani Valeriano"
    And the user should see "email" with value equal "leonardo.valeriano@faculdadeimpacta.com.br"
    And the user should see "age" with value equal "26"

  Scenario: Update an user.
    Given the user backs to the user grid
    And the user clicks on edit button
    And the user fill "login" with value equal "Leonardovaleriano95"
    And the user clicks on edit save button
    And the user backs to the user grid
    When the user clicks on show button
    Then the user should see "login" with value equal "Leonardovaleriano95"


  Scenario: Delete an user.
    Given the user backs to the user grid
    When the user clicks on delete button
    And the user confirms delete
    Then the user should not see last user code


