@regression @consultant
Feature: User create new consultant

  @consultant_01
  Scenario: User create new consultant to doctor
#    Given On SqlServer, I delete user by username "0347249676" and country "VN"
    Given I open chrome
    And On Web, I open login page
    Given On Web, I login account with username is "0347249676", password is "123456", country is "Việt Nam"
    And I create new question with below info
      | height      | 165                                           |
      | weight      | 56                                            |
      | temperature | 37                                            |
      | question    | bác sĩ cho em hỏi, em bị đau bụng khó ở quá ạ |
