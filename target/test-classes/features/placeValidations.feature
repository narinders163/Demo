Feature: Validating Place API'S


Scenario Outline: Validating if Place is being added successfully using the AddPlaceAPI

    Given Add place payload "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" using Post HTTP Request
    Then API call got success with status code 200
    And "status" in response body is "OK"

  Examples:
  			|name		| language  | address				|
  			|ftgsh	|English 		|2737 nscjns way|
  			|dftjios|French			|4578 ffrtg way	|
