Feature: Prueba de automatización frontend

  @Caso1
  Scenario Outline: testing the successful login
    Given El usuario navega a la pagina de demoqa
    #When El usuario selecciona la opción New User y registra un nuevo usuario con la siguiente información:
    #  | firstname   | lastname   | username   | password   |
    #  | <firstname> | <lastname> | <username> | <password> |
    And nos logeamos con la cuenta "<username>" y la contraseña "<password>"
    When el usuario ingresa a "Book Store Application" y selecciona la opción "Book Store"
    And El usuario selecciona el libro y lo agrega a su colección
      | book                       |
      | Programming JavaScript     |
      | Understanding ECMAScript 6 |
    #And eliminamos el libro
    #| book |
    #| Programming JavaScript |
    #Then valida que los libros se agregan correctamente
    #  | book |
    #  | Understanding ECMAScript 6 |
    And elimina el usuario logeado
    And valida que el usuario "<username>" con contraseña "<password>" no existe
    Examples:
      | username | password | firstname | lastname |
      ##@externaldata@src/test/resources/datadriven/prueba.xlsx@Scenario1
   |test01   |Test2023*   |Test01   |Test01|
