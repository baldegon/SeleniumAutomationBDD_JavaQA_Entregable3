# DemoGuru New Tours - BDD con Selenium + Cucumber + JUnit Platform

Duplicado del proyecto original de New Tours, reorganizado para trabajar con **BDD**.

## Tecnologías
- Java 17
- Maven
- Selenium 4
- Cucumber 7
- Gherkin en español
- JUnit Platform Suite como Runner
- Page Object Model (POM)
- PageFactory + `@FindBy`
- Hooks `@Before` y `@After`
- Selenium Manager automático

## Arquitectura

```text
src/
├── main/java/pages/
│   ├── BasePage.java
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── RegisterPage.java
│   └── SimpleContentPage.java
│
└── test/
    ├── java/
    │   ├── hooks/
    │   │   └── Hooks.java
    │   ├── runner/
    │   │   └── CucumberTest.java
    │   ├── steps/
    │   │   ├── HomeSteps.java
    │   │   ├── LoginSteps.java
    │   │   └── RegisterSteps.java
    │   └── utils/
    │       └── DriverManager.java
    │
    └── resources/features/
        ├── home.feature
        ├── login.feature
        └── register.feature
```

## Flujo BDD

```text
Feature (.feature)
      ↓
Gherkin: Dado / Cuando / Entonces
      ↓
Step Definitions
      ↓
Page Objects (POM)
      ↓
BasePage
      ↓
Selenium WebDriver
      ↓
New Tours
```

El **Runner** `CucumberTest` busca todos los `.feature` dentro de `src/test/resources/features` y usa como glue los paquetes `steps` y `hooks`.

Los **Hooks** crean el navegador antes de cada escenario y lo cierran al finalizar.

Los **Step Definitions** traducen los pasos escritos en Gherkin a acciones Java. Los steps no contienen localizadores Selenium: delegan esa responsabilidad en los **Page Objects**.

Los **Page Objects** mantienen el mismo POM del proyecto original y utilizan `PageFactory` y `@FindBy`.

## Ejecutar toda la suite

```bash
mvn clean test
```

## Chrome headless

```bash
mvn clean test -Dheadless=true
```

## Edge

```bash
mvn clean test -Dbrowser=edge
```

## Edge headless

```bash
mvn clean test -Dbrowser=edge -Dheadless=true
```

## Reportes

Después de la ejecución Cucumber genera:

```text
target/cucumber-report.html
target/cucumber-report.json
```

## Conceptos incluidos para practicar
- `Característica`
- `Antecedentes`
- `Escenario`
- `Esquema del escenario`
- `Ejemplos`
- Data Tables
- Step Definitions
- Hooks
- Runner
- POM
- PageFactory
- `@FindBy`
- Assertions con JUnit
