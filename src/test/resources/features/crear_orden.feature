//para objeto de evaluacion por favor tomar solo en cuenta el feature "order.feature". Lo estuve haciendo en features separadas.
Feature: Crear orden en PetStore

  @testOrder
  Scenario Outline: Crear una orden en la tienda
    Given creo una orden con id "<orderId>" y petId "<petId>"
    When envio la orden al endpoint POST /store/order
    Then el status code es 200
    And el body contiene el id de orden "<orderId>" y petId "<petId>"
    Examples:
      | orderId | petId |
