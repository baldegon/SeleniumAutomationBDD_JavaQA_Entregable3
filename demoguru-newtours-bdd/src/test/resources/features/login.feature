# language: es
Característica: Inicio de sesión en New Tours
  Como usuario
  Quiero acceder a SIGN-ON
  Para validar el comportamiento del formulario de autenticación

  Antecedentes:
    Dado que el usuario accede a la pantalla SIGN-ON

  Escenario: La pantalla SIGN-ON contiene los campos principales
    Entonces el formulario de login debe mostrarse correctamente

  Esquema del escenario: Enviar distintas combinaciones de credenciales
    Cuando intenta iniciar sesión con usuario "<usuario>" y contraseña "<password>"
    Entonces la aplicación debe devolver una página válida

    Ejemplos:
      | usuario                  | password             |
      | demoUser                 | demoPass             |
      | usuario_inexistente_123  | clave_incorrecta_123 |
      |                          |                      |

  Escenario: Login ficticio redirige a una respuesta de login
    Cuando intenta iniciar sesión con usuario "demoUser" y contraseña "demoPass"
    Entonces la URL resultante debe contener "login"
