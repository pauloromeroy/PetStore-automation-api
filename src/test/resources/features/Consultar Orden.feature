//para objeto de evaluacion por favor tomar solo en cuenta el feature "order.feature", pues lo estuve haciendo en features separadas.
Feature: Consultar una orden por su id en PetStore

  @consultaOrden
  Scenario Outline: Consultar una orden por su id
    Given tengo una orden con id "<orderId>"
    When consulto la orden por id
    Then el status code es 200
    And el body contiene el id de orden "<orderId>" y petId "<petId>"

    Examples:
      | orderId | petId |
