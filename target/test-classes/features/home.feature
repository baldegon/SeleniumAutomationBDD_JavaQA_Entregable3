# language: es
Característica: Página principal de New Tours
  Como usuario del sitio New Tours
  Quiero interactuar con la página principal
  Para validar sus controles y enlaces principales

  Antecedentes:
    Dado que el usuario se encuentra en la página principal de New Tours

  Escenario: La home carga correctamente
    Entonces la página principal debe cargarse correctamente

  Escenario: El título contiene Welcome
    Entonces el título debe contener la palabra Welcome

  Esquema del escenario: Completar campos del login desde la home
    Cuando ingresa el usuario "<usuario>" en el login de la home
    Entonces el campo usuario de la home debe contener "<usuario>"
    Cuando ingresa la contraseña "<password>" en el login de la home
    Entonces el campo contraseña de la home debe contener "<password>"

    Ejemplos:
      | usuario       | password |
      | agustin       | 123456   |
      | automationQA  | Test123  |
      | demoUser      | demoPass |

  Esquema del escenario: Navegar por enlaces principales
    Cuando navega desde la home a "<opcion>"
    Entonces la URL debe cambiar respecto de la página principal

    Ejemplos:
      | opcion        |
      | SUPPORT       |
      | CONTACT       |
      | Flights       |
      | Hotels        |
      | Car Rentals   |
      | Cruises       |
      | Destinations  |
      | Vacations     |
