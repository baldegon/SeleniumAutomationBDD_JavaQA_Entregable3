# language: es
Característica: Boton de carga y mensaje en pantalla



  Escenario: Carga exitosa habiendo presionado el boton
    Dado que el usuario esta en la pagina de carga
    Cuando presione el boton de START
    Y haya concluido el tiempo de carga
    Entonces Se muestra la palabra HELLO WORLD exitosamente