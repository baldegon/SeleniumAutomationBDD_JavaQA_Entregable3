package steps;

import pages.AddRemovePage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddRemoveStep {

    private AddRemovePage addremovePage;

    @Dado("que estoy en la pagina de add remove elements")
    public void validarPagina(){
        addremovePage.navegarAlAddElement();
    }

    @Cuando("hago click sobre addelement")
    public void elementoAgregado(){
        addremovePage.agregarElemento();
    }

    @Entonces("deberia agregarse un nuevo elemento")

    @Cuando("hago click sobre delete")
    public void elementoEliminado(){
        addremovePage.removerElemento();
    }


}
