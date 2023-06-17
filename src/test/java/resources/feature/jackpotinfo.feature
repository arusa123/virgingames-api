Feature:  Lobby Feed Test

  Scenario: Verify the default game frequency is 300000
    When I send a Get request to lobby feed endpoint
    Then I must get a valid response code 200
    And I verify default frequency is GBP