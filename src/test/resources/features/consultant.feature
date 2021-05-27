@regression @consultant
Feature: User create new consultant

  @consultant_01
  Scenario: User create new consultant to doctor
    Given On SqlServer, I delete user by username "0988886661" and country "VN"
    Given I open chrome
    When On Web, I open login page
    Given On Web, I login account with username is "0988886661", password is "123456", country is "Việt Nam"
    And
