Feature: Consult the information of a city by the zip code

  Scenario: Consume of the service successfully using the zip code of the city
    Given load the data for the test
      |  zip  |    cityName   |
      | 94105 | San Francisco |
    When use the service with the zip code of the city as a parameter
    Then see the status code is 200
    And validate the city name