Feature: Search on booking.com

  Scenario: Search by city criteria
    Given User is looking for hotel in city "Gomel"
    When User does search
    Then Hotel "Park Hotel Zamkovy" should be on the first page
    And Rating of the hotel is "9.3"
