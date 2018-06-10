Feature: User filters creation
  User should be asked to select the USERNAME select box and enter the value to filter

  Scenario: Filters creation
    Given selected the USERNAME selectbox and value
    When Submitted the filter
    Then Checked the results

  Scenario Outline: Delete user account
    Given selected "<user>" filter
    When Submitted the filter
    Then Checked the results
    And delete user
    Examples:
      | user | email_id | password |
      | Test31 | test31@gmail.com | test31 |
      | Test32 | test32@gmail.com | test32 |
      | Test33 | test33@gmail.com | test33 |
      | Test34 | test34@gmail.com | test34 |
      | Test35 | test35@gmail.com | test35 |
      | Test36 | test36@gmail.com | test36 |

