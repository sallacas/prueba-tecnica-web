# Proyecto de Automatización Web con Screenplay

Este es un proyecto de automatización web desarrollado utilizando el patrón **Screenplay** en **Java 17** y gestionado con **Gradle 8+**. El propósito de este proyecto es automatizar escenarios en la aplicación **Book Store Application** y **Alert Frames and Form**.

## Requisitos

- **Java 17**
- **Gradle 8+**
- Un IDE compatible como **IntelliJ IDEA** o **Eclipse** (opcional)
- Acceso a internet para la ejecución de pruebas contra los servicios o aplicaciones web

## Estructura del Proyecto

El proyecto incluye dos escenarios automatizados, cada uno con su respectivo tag para poder ser ejecutado de manera independiente o en conjunto:

1. **Book Store Application Scenario**:
    - **Tag**: `@Caso1`
    - Este escenario cubre la creación de un usuario, la adición de libros a la colección, y la eliminación de un libro y el usuario.

2. **Alert Frames and Form Scenario**:
    - **Tag**: `@Caso2`
    - Este escenario cubre la interacción con elementos como frames, formularios y alertas en una página web.

## Ejecución de las Pruebas

### Ejecutar Todas las Pruebas

Para ejecutar todas las pruebas del proyecto, puedes utilizar el siguiente comando en la raíz del proyecto:

```bash
./gradlew clean test
```

### Ejecutar Pruebas por Tag

Si deseas ejecutar un escenario específico usando su Tag, puedes hacerlo utilizando la opción -Dtags, como se muestra a continuación:

Para ejecutar el escenario Book Store Application (@Caso1):

```bash
./gradlew clean test -Dtags=@Caso1
```

Para ejecutar el escenario Alert Frames and Form (@Caso2):

```bash
./gradlew clean test -Dtags=@Caso2
```

## Generación de Reportes

Después de la ejecución de las pruebas, puedes generar reportes utilizando el siguiente comando:

```bash
./gradlew reports
```

Esto generará un reporte detallado sobre las pruebas ejecutadas, sus resultados, y las métricas asociadas.

## Tecnologías Utilizadas
- Serenity BDD: Para la gestión de pruebas con el patrón Screenplay.
- Java 17: Lenguaje de programación utilizado en el proyecto.
- Gradle 8+: Herramienta de construcción utilizada para la ejecución y gestión de dependencias.
- Selenium WebDriver: Para la interacción con la aplicación web.
- JUnit: Framework de pruebas utilizado como base para la ejecución de las pruebas.

## Contacto
Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto con nosotros. ¡Estaremos encantados de ayudarte!