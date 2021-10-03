Feature: Users feature

  Scenario: A webClient gets the all users
    Given the all users
      | firstName    | lastName |
      | Carlos       | Lopez    |
      | Maria        | Lopez    |
    When the webClient requests all the users
    Then all the users are returned
