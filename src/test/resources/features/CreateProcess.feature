@processos
Feature: Create a process
Background:

  Given the user is on Agapito Server page
  And the user clicks on Process menu
  And the user clicks on new process button
  And the user fills "processo_vara" with the value equal "vara1" on the process page
  And the user fills "processo_numero_processo" with the value equal "123" on the process page
  And the user fills "processo_natureza" with the value equal "civil" on the process page
  And the user fills "processo_partes" with the value equal "parte1 x parte2" on the process page
  And the user selects urgency with the value equal "Sim" on the process page
  And the user clicks on arbitramento equals "Sim"
  And the user fills "processo_assistente_social" with the value equal "Assistente1" on the process page
  And the user fills "processo_data_entrada" with the value equal "04/07/2020" on the process page
  And the user fills "processo_status" with the value equal "marcado" on the process page
  And the user fills "processo_observacao" with the value equal "Primeiro teste" on the process page
  When the user clicks on save button on the process page


  Scenario: Create a process
    Then the user should see "Processo foi criado com sucesso." into view process page

  Scenario: check fields on the process grid.
      When the user clicks on back button into process show page
      Then the user should see last code on the process grid page
      And the user should see "vara" with value "vara1" on the process grid page
      And the user should see "natureza" with value "civil" on the process grid page
      And the user should see "partes" with value "parte1 x parte2" on the process grid page

    @outline
  Scenario Outline: Update a Process
    When the user clicks on back button into process show page
    And the user clicks on edit process button
    And the user fill "processo_vara" with value equal vara "<vara>"
    And the user selects urgency with the value equal "Não" on the process page
    And the user clicks on arbitramento equals "Não"
    When the user clicks on save button on the process page
    Then the user should see "Processo atualizado com sucesso." into view process page

    Examples:
      |vara|
      |vara3|
      |vara4|
      |vara5|


  @delete
  Scenario: Delete a process.
    When the user clicks on back button into process show page
    And the user clicks on delete button process button
    And the user confirms delete
    Then the user should not see last process code


