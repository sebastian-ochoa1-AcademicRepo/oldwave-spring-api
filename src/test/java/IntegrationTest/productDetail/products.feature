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

  Scenario: Testing that GET for products by name with page one returns one product with page one
    Given url urlBase +'?name=Iphone&page=1&size=1'
    When method GET
    Then status 200
    And match $ contains {"total": 1}

  Scenario: Testing that GET for products by name with page two returns one product
    Given url urlBase +'?name=Iphone&page=2&size=1'
    When method GET
    Then status 200
    And match $ contains {"total": 1}

  Scenario: Testing that GET for products by name with page one and size two returns two products
    Given url urlBase +'?name=Iphone&page=1&size=2'
    When method GET
    Then status 200
    And match $ contains {"total": 2}

  Scenario: Testing that GET for products by name computador returns products with name computador
    Given url urlBase +'?name=computador&page=1&size=2'
    When method GET
    Then status 200
    And match each $..name contains "Computador"

  Scenario: Testing that GET for products by name returns items with attributes not null
    Given url urlBase +'?name=computador&page=1&size=2'
    When method GET
    Then status 200
    And match each $..productCode contains "#notnull"
    And match each $..name contains "#notnull"
    And match each $..brand contains "#notnull"
    And match each $..thumbnail contains "#notnull"
    And match each $..city contains "#notnull"
    And match each $..seller contains "#notnull"

  Scenario: Testing that GET for products by name returns url error
    Given url urlBase +'?nam=0'
    When method GET
    Then status 400
    And match $..code contains 400
    And match $..message contains "Por favor verifica la URL o los parametros enviados"
