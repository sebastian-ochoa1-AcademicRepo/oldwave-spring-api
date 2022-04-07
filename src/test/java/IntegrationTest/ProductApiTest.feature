Feature: Products

  How estudent
  Required when call info of products
  To return info of produdcts or details



  Scenario: Testing that GET for prodcuts by name
    Given url 'https://oldwave-spring-api.herokuapp.com/api/product?name=Iphone&page=1&size=5'
    When method GET
    Then status 200
    And match $ contains {items:"#notnull"}

  Scenario: Testing that GET for prodcut detail
    Given url 'https://oldwave-spring-api.herokuapp.com/api/product/1/detail'
    When method GET
    Then status 200
    And match $ contains {"description": "Este es un item de prueba"}