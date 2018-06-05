Feature: New User creation
  User should be asked for username once click on new user creation page
  User should be asked for email id, password
  User should be given warning message if given userId exists already
  User should be create user account

  Scenario Outline: Create user account
    Given Opened application and routed to New user creation page
    When user entered valid "<user>", "<email_id>", "<password>"
    Then User created
    Examples:
      | user | email_id | password |
      | Test31 | test31@gmail.com | test31 |
      | Test32 | test32@gmail.com | test32 |
      | Test33 | test33@gmail.com | test33 |
      | Test34 | test34@gmail.com | test34 |
      | Test35 | test35@gmail.com | test35 |
      | Test36 | test36@gmail.com | test36 |
