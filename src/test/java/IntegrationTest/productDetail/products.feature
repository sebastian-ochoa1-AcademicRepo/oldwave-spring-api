Feature: Products

  How student
  Required that when i call the products api with a name
  To return info of products related to it

  Background:
    * def urlBase = 'http://localhost:8089/api/product'

  Scenario: Testing that GET for products by name returns content type json
    Given url urlBase +'?name=Iphone&page=1&size=5'
    When method GET
    Then status 200
    And match header content-type contains 'application/json'

  Scenario: Testing that GET for products by name
    Given url urlBase +'?name=Iphone&page=1&size=5'
    When method GET
    Then status 200
    And match $ contains {items:"#notnull"}



  Scenario: Testing that GET for products by name returns url error
    Given url urlBase +'?nam=0'
    When method GET
    Then status 400
    And match $..code contains 400
    And match $..message contains "Por favor verifica la URL o los parametros enviados"
