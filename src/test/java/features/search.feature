Feature: Search and place order for vegetables

  Background:
    Given User is on the landing page

  @testRegression
  Scenario Outline: Search for the place
    When User searched for <places>
    Then <places> results are displayed
    Examples:
      | places  |
      | isla    |

  @testRegression
  Scenario: Validate error for empty search
    When the user clicks on search button
    Then an error message should be displayed


