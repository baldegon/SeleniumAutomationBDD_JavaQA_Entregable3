package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.HomePage;
import pages.LoginPagea;
import utils.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class Login {

    private LoginPagea loginPage;

    @Dado("que el usuario accede a la pantalla SIGN-ON")
    public void abrirSignOn() {
        loginPage = new HomePage(DriverManager.getDriver()).goToSignOn();
    }

    @Entonces("el formulario de login debe mostrarse correctamente")
    public void formularioVisible() {
        assertTrue(loginPage.isLoaded());
    }

    @Cuando("intenta iniciar sesión con usuario {string} y contraseña {string}")
    public void intentarLogin(String username, String password) {
        loginPage.login(username, password);
    }

    @Entonces("la aplicación debe devolver una página válida")
    public void paginaValida() {
        assertFalse(loginPage.getCurrentUrl().isBlank());
        assertFalse(loginPage.getTitle().isBlank());
    }

    @Entonces("la URL resultante debe contener {string}")
    public void urlContiene(String value) {
        assertTrue(loginPage.getCurrentUrl().toLowerCase().contains(value.toLowerCase()));
    }
}
