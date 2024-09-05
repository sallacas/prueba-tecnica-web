Feature: Prueba de automatización frontend

  @Caso1
  Scenario Outline: Book Store Application scenario
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
      | username | password  | firstname | lastname |
      ##@externaldata@src/test/resources/datadriven/prueba.xlsx@Scenario1
   |test01   |Test2023*   |Test01   |Test01|

  @Caso2
  Scenario Outline: Alert frames y Form scenario
    Given El usuario navega a la pagina de demoqa
    #When El usuario selecciona la opción New User y registra un nuevo usuario con la siguiente información:
    #  | firstname   | lastname   | username   | password   |
    #  | <firstname> | <lastname> | <username> | <password> |
    And nos logeamos con la cuenta "<username>" y la contraseña "<password>"
    When el usuario ingresa a "Alerts, Frame & Windows" y selecciona la opción "Nested Frames"
    And extraemos los datos de los iframes
    When el usuario ingresa a "Forms" y selecciona la opción "Practice Form"
    And llenamos el formulario de prueba con los datos siguientes:
      | firstname     | lastname     | email   | gender   | mobile   | date            | subject   | hobbies   | current-address   | state   | city   |
      | <firstnamePF> | <lastnamePF> | <email> | <gender> | <mobile> | <date-of-birth> | <subject> | <hobbies> | <current-address> | <state> | <city> |
    And elimina el usuario logeado
    And valida que el usuario "<username>" con contraseña "<password>" no existe
    Examples:
      | username | password  | firstname | lastname | email              | gender | mobile     | date-of-birth | subject   | hobbies | current-address            | state   | city   | firstnamePF | lastnamePF |
      ##@externaldata@src/test/resources/datadriven/prueba.xlsx@Scenario2
   |test02   |Test2023*   |Test02   |Test02   |prueba@yopmail.com   |Female   |3004441234   |20/09/2000   |Aspirante   |Music   |Autopista Norte al oriente   |Haryana   |karnal   |Prueba01   |Prueba01|
