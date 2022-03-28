@MyTest
Feature: Smoke of Banking Application with Hooks and DruRun

  @Smoke_Hook_DruRun
  Scenario Outline: Test Application with Hooks and DruRun
    Given Open chrome and start application and check base page of "https://demo.guru99.com/V1/index.php"
    When I enter username "<UserName>" and password "<Password>"
    Then I verify the "<Status>" of the page

    Examples: 
      | UserName   | Password | Status |
      | mngr394612 | veremUt  | pass   |
      | NoName     | cvmkfnv  | fail   |
      | Blankk     | cv546nv  | fail   |
