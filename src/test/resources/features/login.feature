@regression @login
Feature: User Profile

#  Background:
#    Given On SqlServer, I delete user by username "0303305467" and country "VN"
#    When I signup new account with below info and verify it
#      | country     | VN         |
#      | gdrLogin    | 0303305467 |
#      | password    | 123456     |
#      | displayName | Nguyen Teo |
#      | gender      | 1          |
#      | language    | 0          |
#    And The request should be succeed
#    Given I open chrome
#    When On Web, I open login page

  @signup_01
  Scenario: Signup
    Given On SqlServer, I delete user by username "0347249676" and country "VN"
    Given I open chrome
    And On Web, I open login page
    When On Web, I open signup account with username is "0347249676", password is "123456", full name "Ngân Hà" and country "VN"
    And I enter verification code with code "1234"
    Then I check on dashboad page have name "Ngân Hà"

  @smoke @login-1
  Scenario: login 2.
    Given On Web, I login account with username is "0303305467", password is "123456", country is "Việt Nam"


  @smoke @test-login-popup
  Scenario: login 2.
    Given open url "https://kb1.globedr.com", user "globedr", pass "Globedr@54321"

  @smoke @test
  Scenario Outline: Correct non-zero number of books found by author by list
    Given I test table
      | ho | ten |
      | a  | b   |

    Given I test account
      | yourName   | title   | email   | address   | dob   | gender   | visitCountry   | country   | city   | region   | phoneNumber   | workPhone   |
      | <yourName> | <title> | <email> | <address> | <dob> | <gender> | <visitCountry> | <country> | <city> | <region> | <phoneNumber> | <workPhone> |

    Given the list lecture details are
      | profName | topic         | size | frequency | rooms     |
      | Jack     | A1:Topic One  | 40   | 3         | 101A,302C |
      | Daniels  | B5:Topic Five | 30   | 2         | 220E,419D |

    Examples:
      | yourName       | title | email        | address           | dob        | gender         | visitCountry  | country       | city  | region | phoneNumber | workPhone  | image                                 |
      | Nguyễn Văn Heo | Sếp   | sep@test.com | nguyen tri phuong | 01/01/2000 | translate.male | United States | United States | Sitka | Alaska | 0303344444  | 0303344444 | src/test/resources/data/images/h1.jpg |
