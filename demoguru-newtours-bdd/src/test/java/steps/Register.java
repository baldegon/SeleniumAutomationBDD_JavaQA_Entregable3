package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.HomePage;
import pages.RegisterPage;
import utils.DriverManager;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Register {

    private RegisterPage registerPage;
    private String generatedUsername;

    @Dado("que el usuario accede al formulario REGISTER")
    public void abrirRegister() {
        registerPage = new HomePage(DriverManager.getDriver()).goToRegister();
    }

    @Entonces("el formulario de registro debe mostrarse correctamente")
    public void formularioRegistroVisible() {
        assertTrue(registerPage.isLoaded());
    }

    @Cuando("completa los datos de contacto")
    public void completarContacto(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        registerPage.fillContactInformation(
                data.getOrDefault("nombre", ""),
                data.getOrDefault("apellido", ""),
                data.getOrDefault("telefono", ""),
                data.getOrDefault("email", "")
        );
    }

    @Cuando("completa los datos de dirección")
    public void completarDireccion(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);
        registerPage.fillMailingInformation(
                data.get("direccion"),
                data.get("ciudad"),
                data.get("provincia"),
                data.get("codigoPostal"),
                data.get("pais")
        );
    }

    @Cuando("completa las credenciales de registro con usuario {string} contraseña {string} y confirmación {string}")
    public void completarCredenciales(String username, String password, String confirmation) {
        registerPage.fillUserInformation(username, password, confirmation);
    }

    @Entonces("el nombre ingresado debe ser {string}")
    public void validarNombre(String expected) {
        assertEquals(expected, registerPage.firstNameValue());
    }

    @Entonces("el apellido ingresado debe ser {string}")
    public void validarApellido(String expected) {
        assertEquals(expected, registerPage.lastNameValue());
    }

    @Entonces("el teléfono ingresado debe ser {string}")
    public void validarTelefono(String expected) {
        assertEquals(expected, registerPage.phoneValue());
    }

    @Entonces("el email ingresado debe ser {string}")
    public void validarEmail(String expected) {
        assertEquals(expected, registerPage.emailValue());
    }

    @Entonces("el país seleccionado debe ser {string}")
    public void validarPais(String expected) {
        assertEquals(expected, registerPage.selectedCountry());
    }

    @Entonces("las credenciales deben conservar usuario {string} y contraseña {string}")
    public void validarCredenciales(String username, String password) {
        assertAll(
                () -> assertEquals(username, registerPage.usernameValue()),
                () -> assertEquals(password, registerPage.passwordValue()),
                () -> assertEquals(password, registerPage.confirmPasswordValue())
        );
    }

    @Cuando("completa un registro válido con datos únicos")
    public void registroConDatosUnicos() {
        String unique = String.valueOf(System.currentTimeMillis());
        generatedUsername = "qa_user_" + unique;

        registerPage
                .fillContactInformation("QA", "Automation", "3804000000", "qa" + unique + "@example.com")
                .fillMailingInformation("Automation Street 123", "La Rioja", "La Rioja", "5300", "ARGENTINA")
                .fillUserInformation(generatedUsername, "Test123!", "Test123!")
                .submitRegistration();
    }

    @Entonces("el registro debe finalizar correctamente")
    public void registroExitoso() {
        assertTrue(registerPage.isRegistrationSuccessful(),
                "No se encontró el mensaje de registro exitoso para " + generatedUsername);
    }
}
