Feature: concordia website
  @topMenu
  Scenario: test topMenu and subMenu linked with topMenu
    Given  prepare parameter
    When I open concordia website
    And I click topMenu in the homePage
    | menuName|
    | About  |
  @subMenu
  Scenario: test topMenu and subMenu linked with topMenu


    Given  prepare parameter
    When I open concordia website
    Then I test subMenu linked with topMenu