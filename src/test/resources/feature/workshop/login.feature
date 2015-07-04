@screen

Feature: Login

  //Scenario: Open any web page
  // Given I open this url "https://dl.dropboxusercontent.com/u/16174618/FastTrackIT/app-demo/login.html"
  //Then I send 10 into search field

  Scenario: Login Succesfully
    Given I access the login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in

  Scenario: Login with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click login button
    Then I expect invalid credential message

  Scenario: Login with no password
    Given I access the login page
    When I enter "eu@fast.com"/"" credentials
    And I click login button
    Then  I expect "Please enter your password!" message

  Scenario: Login with no email
    Given I access the login page
    When I enter ""/"eu.pass" credentials
    And I click login button
    Then  I expect "Please enter your email!" message

  Scenario Outline: Failed login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And I click login button
    Then I expect "<message>" message
    Examples:
      | email       | pass     | message                     |
      | aa@fast.com |          | Please enter your password! |
      |             |          | Please enter your email!    |
      |             | onlypass | Please enter your email!    |
      | aa@fast.com | somepass | Invalid user or password!   |

  Scenario: Logout success
    Given I successfully login


