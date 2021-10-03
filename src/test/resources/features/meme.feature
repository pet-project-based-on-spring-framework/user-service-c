Feature: Users feature

  Scenario: A webClient gets the all users
    Given the all users
      | id | firstName    | lastName |
      | 1  | Carlos       | Lopez    |
      | 2  | Maria        | Lopez    |
    When the webClient requests all the users
    Then all the users are returned
