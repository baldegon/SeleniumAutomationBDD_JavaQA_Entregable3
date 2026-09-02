#language: es
  Característica: Inicio de sesion en The Internet Herokuapp
    Como  usuario del sistema
    Quiero poder iniciar sesion con mis credenciales
    Para acceder al area segura

  Escenario: Inicio de sesion exitoso con credenciales validas
    Dado que estoy en la pagina de login
    Cuando ingreso el usuario "tomsmith" y la contraseña "SuperSecretPassword!"
    Y hago click en el boton de login
    Entonces deberia ver el mensaje de exito "You logged into a secure area!"