
Feature: Validar integridad del API Store de PetStore
  Quiero validar los endpoints de creación y consulta de órdenes para garantizar la integridad del API de Store


  Scenario Outline: Crear una orden en la tienda
    Given preparo una orden con id "<orderId>" y petId "<petId>"
    When envio la orden al endpoint POST /store/order
    Then el status code es 200
    And el body contiene el id de orden "<orderId>" y petId "<petId>"

    Examples:
      | orderId | petId |
      | 900001  | 5001  |

  Scenario Outline: Consultar una orden por su id
    Given tengo una orden con id "<orderId>"
    When consulto la orden por id
    Then el status code es 200
    And el body contiene el id de orden "<orderId>" y petId "<petId>"

    Examples:
      | orderId | petId |
      | 900001  | 5001  |
