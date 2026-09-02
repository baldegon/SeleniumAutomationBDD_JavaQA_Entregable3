# language: es
Característica: Registro de usuario en New Tours
  Como nuevo usuario
  Quiero completar el formulario REGISTER
  Para validar el proceso de alta y sus campos

  Antecedentes:
    Dado que el usuario accede al formulario REGISTER

  Escenario: El formulario de registro carga correctamente
    Entonces el formulario de registro debe mostrarse correctamente

  Escenario: Completar información de contacto
    Cuando completa los datos de contacto
      | nombre   | Agustin        |
      | apellido | Galimberti     |
      | telefono | 3804000000     |
      | email    | qa@example.com |
    Entonces el nombre ingresado debe ser "Agustin"
    Y el apellido ingresado debe ser "Galimberti"
    Y el teléfono ingresado debe ser "3804000000"
    Y el email ingresado debe ser "qa@example.com"

  Escenario: Completar información de dirección
    Cuando completa los datos de dirección
      | direccion    | Av. Siempre Viva 123 |
      | ciudad       | La Rioja              |
      | provincia    | La Rioja              |
      | codigoPostal | 5300                  |
      | pais         | ARGENTINA             |
    Entonces el país seleccionado debe ser "ARGENTINA"

  Esquema del escenario: Completar distintas credenciales de registro
    Cuando completa las credenciales de registro con usuario "<usuario>" contraseña "<password>" y confirmación "<password>"
    Entonces las credenciales deben conservar usuario "<usuario>" y contraseña "<password>"

    Ejemplos:
      | usuario       | password |
      | qa_user_001   | 123456   |
      | qa_user_002   | Test123! |
      | automation_03 | Pass456! |

  Escenario: Registro end-to-end con datos generados
    Cuando completa un registro válido con datos únicos
    Entonces el registro debe finalizar correctamente
