@regression @account
Feature: Login

  Background:
    Given On SqlServer, I delete user by username "0303305467" and country "VN"
    When I signup new account with below info and verify it
      | country     | VN         |
      | gdrLogin    | 0303305467 |
      | password    | 123456     |
      | displayName | Nguyen Teo |
      | gender      | 1          |
      | language    | 0          |
    And The request should be succeed
    Given I open chrome
    When On Web, I open login page

  @smoke @account-01
  Scenario Outline: I update account information
    Given On Web, I login account with username is "0303305467", password is "123456", country is "Việt Nam"
    Given On Dashboard Personal, I open Account Menu
    When On Web, I update my account with below info
      | yourName     | <yourName>     |
      | title        | <title>        |
      | email        | <email>        |
      | address      | <address>      |
      | dob          | <dob>          |
      | gender       | <gender>       |
      | visitCountry | <visitCountry> |
      | country      | <country>      |
      | city         | <city>         |
      | region       | <region>       |
      | phoneNumber  | <phoneNumber>  |
      | workPhone    | <workPhone>    |


    And On Web, I update my avatar with image "<image>"
    Then When On Web, I see my account with below info
      | yourName     | <yourName>     |
      | title        | <title>        |
      | email        | <email>        |
      | address      | <address>      |
      | dob          | <dob>          |
      | gender       | <gender>       |
      | visitCountry | <visitCountry> |
      | country      | <country>      |
      | city         | <city>         |
      | region       | <region>       |
      | phoneNumber  | <phoneNumber>  |
      | workPhone    | <workPhone>    |

    Examples:
      | yourName       | title | email        | address           | dob        | gender        | visitCountry  | country       | city  | region | phoneNumber | workPhone  | image                                 |
      | Nguyễn Văn Heo | Sếp   | sep@test.com | nguyen tri phuong | 01/01/2000 | male | United States | United States | Sitka | Alaska | 0303344444  | 0303344444 | src/test/resources/data/images/h1.jpg |


