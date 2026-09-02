package steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import pages.HomePage;
import pages.SimpleContentPage;
import utils.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class Home {

    private HomePage homePage;
    private String previousUrl;
    private String currentUrl;

    @Dado("que el usuario se encuentra en la página principal de New Tours")
    public void usuarioEnHome() {
        homePage = new HomePage(DriverManager.getDriver());
        assertTrue(homePage.isLoaded());
    }

    @Entonces("la página principal debe cargarse correctamente")
    public void homeCargaCorrectamente() {
        assertTrue(homePage.isLoaded());
        assertTrue(homePage.getCurrentUrl().contains("newtours"));
    }

    @Entonces("el título debe contener la palabra Welcome")
    public void tituloContieneWelcome() {
        assertTrue(homePage.getTitle().toLowerCase().contains("welcome"));
    }

    @Cuando("ingresa el usuario {string} en el login de la home")
    public void ingresarUsuario(String username) {
        homePage.enterUsername(username);
    }

    @Entonces("el campo usuario de la home debe contener {string}")
    public void validarUsuario(String username) {
        assertEquals(username, homePage.usernameValue());
    }

    @Cuando("ingresa la contraseña {string} en el login de la home")
    public void ingresarPassword(String password) {
        homePage.enterPassword(password);
    }

    @Entonces("el campo contraseña de la home debe contener {string}")
    public void validarPassword(String password) {
        assertEquals(password, homePage.passwordValue());
    }

    @Cuando("navega desde la home a {string}")
    public void navegarDesdeHome(String option) {
        previousUrl = homePage.getCurrentUrl();
        SimpleContentPage page;

        switch (option.toLowerCase()) {
            case "support" -> page = homePage.goToSupport();
            case "contact" -> page = homePage.goToContact();
            case "flights" -> page = homePage.goToFlights();
            case "hotels" -> page = homePage.goToHotels();
            case "car rentals" -> page = homePage.goToCarRentals();
            case "cruises" -> page = homePage.goToCruises();
            case "destinations" -> page = homePage.goToDestinations();
            case "vacations" -> page = homePage.goToVacations();
            default -> throw new IllegalArgumentException("Opción no soportada: " + option);
        }

        currentUrl = page.getCurrentUrl();
    }

    @Entonces("la URL debe cambiar respecto de la página principal")
    public void urlDebeCambiar() {
        assertNotEquals(previousUrl, currentUrl);
    }
}
