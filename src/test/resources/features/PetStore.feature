Feature: Mascota

  @TestEjecucion
  Scenario Outline: Consultar Mascota por ID
    Given defindo la URL "https://petstore.swagger.io/v2/"
    When consulto la mascota de ID "<idMascota>"
    And valido el codigo de respuesta sea <StatusCodeEspeerado>
    And valido el nombre de la mascota sea "doggie"
    Examples:
    | idMascota | StatusCodeEspeerado|
    | 10         | 200                |
    | 12         | 200                |
    | 13         | 200                |
    | 14         | 200                |
    | 15         | 200                |
    | 6         | 200                |
    | 7         | 200                |

