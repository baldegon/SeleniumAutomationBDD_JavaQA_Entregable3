package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 1. Localizadores de Selenium
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("button=[type='submit']");
    private By succesMessage = By.id("flash");

    // 2. Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void navegarAlLogin(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void ingresarCredenciales(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);

    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String obtenerMensaje(){
        return driver.findElement(succesMessage).getText();
    }

}
