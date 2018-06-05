Feature: User filters creation
  User should be asked to select the USERNAME select box and enter the value to filter

  Scenario: Filters creation
    Given selected the USERNAME selectbox and value
    Then Submitted the filter
    Then Checked the results

