package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemovePage {
    private WebDriver driver;

    ////button[@onclick='myFunction()']
    private By addelementButton = By.id("button[@onclick='addElement()']");
    private By deleteButton = By.id("button[@onclick='deleteElement()']");

    public AddRemovePage(WebDriver driver){
        this.driver = driver;
    }

    public void navegarAlAddElement() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void agregarElemento() {
        driver.findElement(addelementButton).click();

    }

    public void removerElemento(){
        driver.findElement(deleteButton).click();
    }

}
