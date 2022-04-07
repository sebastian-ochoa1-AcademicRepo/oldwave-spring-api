Feature: Product Detail

  How student
  Required that when call product detail api
  To return the details of certain product

  Background:
    * def urlBase = 'http://localhost:8089/api/product'
    * def testPath = '/detail'

  Scenario: Testing that GET for product detail to return content type json
    Given url urlBase + '/1' + testPath
    When method GET
    Then status 200
    And match header content-type contains 'application/json'

  Scenario: Testing that GET for product detail returns the right json
    Given url urlBase + '/1' + testPath
    When method GET
    Then status 200
    And match $..productCode contains "#notnull"
    And match $..name contains "#notnull"
    And match $..description contains "#notnull"
    And match $..brand contains "#notnull"
    And match $..city contains "#notnull"
    And match $..price contains "#notnull"
    And match $..reseller contains "#notnull"
    And match $..rating contains "#notnull"
    And match $..images contains [#notnull]

  Scenario: Testing that GET for product detail returns right product
    Given url urlBase + '/1' + testPath
    When method GET
    Then status 200
    And match $..name contains "prueba"

  Scenario: Testing that GET for product detail returns error not found
    Given url urlBase + '/code' + testPath
    When method GET
    Then status 404
    And match $..code contains 404
    And match $..message contains "No se encontró un producto con el código enviado"

  Scenario: Testing that GET for product detail returns error when not found URL
    Given url urlBase + testPath
    When method GET
    Then status 404
    And match $..status == [404]
    And match $..message contains ""
