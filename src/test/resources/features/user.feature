
Feature: Login


  @t2
  Scenario: t2
    Given I clear all cache


  @smoke @login-prepare-data
  Scenario Outline: Prepare account for login.
    Given On SqlServer, I delete user by username "<phone>" and country "<country>"
    When I signup new account with below info and verify it
      | country     | <country>     |
      | gdrLogin    | <phone>       |
      | password    | 123456        |
      | displayName | <displayName> |
      | gender      | 1             |
      | language    | 0             |
    And The request should be succeed
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |
      | 0303305417 | US      | Cẩm Lan Sục |
