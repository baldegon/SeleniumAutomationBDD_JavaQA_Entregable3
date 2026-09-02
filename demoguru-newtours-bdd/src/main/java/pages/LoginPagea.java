package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPagea extends BasePage {

    @FindBy(name = "userName")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(normalize-space(), 'Welcome back to Mercury Tours!')]")
    private WebElement welcomeMessage;

    public LoginPagea(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(userNameInput) && isDisplayed(passwordInput) && isDisplayed(submitButton);
    }

    public LoginPagea login(String username, String password) {
        type(userNameInput, username);
        type(passwordInput, password);
        click(submitButton);
        return this;
    }

    public String getUsernameValue() {
        return valueOf(userNameInput);
    }

    public String getPasswordValue() {
        return valueOf(passwordInput);
    }

    public boolean isWelcomeMessageDisplayed() {
        return isDisplayed(welcomeMessage);
    }
}
