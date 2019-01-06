Feature: Adding ingredients to inventory

  Scenario Adding tomatoes to the inventory
    Given A user has commited tomatoes from the frond-end
    When Tomatoes are added
    Then Tomatoes are in the system
