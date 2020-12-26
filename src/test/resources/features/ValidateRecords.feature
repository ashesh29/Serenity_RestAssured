Feature: To validate number of records for resource in the response


  Scenario Outline: To validate number of records for "<resource>" in the response
    Given User wants to validate the number of records in "<resource>" endpoint
    When User hits the "<resource>" endpoint
    Then response should contain <number> records

    Examples:
      | resource | number |
      | posts    | 100    |
      | comments | 500    |
      | albums   | 100    |
      | photos   | 5000   |
      | todos    | 200    |
      | users    | 10     |


  Scenario Outline: To validate all the endpoints are working
    Given User wants to validate <resource> endpoint is working
    When User hits the <resource> endpoint
    Then response should get response code as <responseCode>

    Examples:
      | resource | responseCode |
      | posts    | 200          |
      | comments | 200          |
      | albums   | 200          |
      | photos   | 200          |
      | todos    | 200          |
      | users    | 200          |





