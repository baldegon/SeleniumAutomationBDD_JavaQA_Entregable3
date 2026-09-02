package steps;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pages.LoadingPage;
import utils.DriverManager;

public class Loading {

    private LoadingPage loadingPage;

    @Dado("que el usuario esta en la pagina de carga")
    public void usuarioEnPagina()
    {
        loadingPage = new LoadingPage(DriverManager.getDriver());
        assertTrue(loadingPage.isLoaded());
        assertTrue(loadingPage.getCurrentUrl().contains("dynamic_loading/2"));
    }

    @Cuando("presione el boton de START")
    public void usuarioPresionaBoton(){
        loadingPage.pressButtonStart();

    }

    @Y("haya concluido el tiempo de carga")
    public void tiempoDeCargaConcluido(){
        assertFalse(loadingPage.buttonExists());
    }

    @Entonces("Se muestra la palabra HELLO WORLD exitosamente")
    public void palabraSeMuestra(){
        assertTrue(loadingPage.successFlow());
    }

}
