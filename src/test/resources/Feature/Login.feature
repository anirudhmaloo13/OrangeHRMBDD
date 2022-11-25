Feature: Login
  I want to maintain a health record
  As a admin
  I want to access the orangehrm portal

  Scenario: Valid Credential
    Given I have browser with orangehrm application
    When I enter username as 'Admin'
    And I enter password as 'admin123'
    And I click on login
    Then I should get the access to the portal with title as 'OrangeHRM'

  Scenario Outline: Invalid Credential
    Given I have browser with orangehrm application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I click on login
    Then I should get the error message as 'Invalid credentials'

    Examples: 
      | username | password |
      | test1    | test2    |
      | test3    | test4    |
