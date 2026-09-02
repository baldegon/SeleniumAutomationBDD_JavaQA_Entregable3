package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(name = "firstName") private WebElement firstNameInput;
    @FindBy(name = "lastName") private WebElement lastNameInput;
    @FindBy(name = "phone") private WebElement phoneInput;
    @FindBy(name = "userName") private WebElement emailInput;
    @FindBy(name = "address1") private WebElement addressInput;
    @FindBy(name = "city") private WebElement cityInput;
    @FindBy(name = "state") private WebElement stateInput;
    @FindBy(name = "postalCode") private WebElement postalCodeInput;
    @FindBy(name = "country") private WebElement countrySelect;
    @FindBy(name = "email") private WebElement usernameInput;
    @FindBy(name = "password") private WebElement passwordInput;
    @FindBy(name = "confirmPassword") private WebElement confirmPasswordInput;
    @FindBy(name = "submit") private WebElement submitButton;

    @FindBy(xpath = "//*[contains(normalize-space(), 'Thank you for registering')]")
    private WebElement successMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(firstNameInput) && isDisplayed(usernameInput) && isDisplayed(submitButton);
    }

    public RegisterPage fillContactInformation(String firstName, String lastName, String phone, String email) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(phoneInput, phone);
        type(emailInput, email);
        return this;
    }

    public RegisterPage fillMailingInformation(String address, String city, String state, String postalCode, String country) {
        type(addressInput, address);
        type(cityInput, city);
        type(stateInput, state);
        type(postalCodeInput, postalCode);
        new Select(countrySelect).selectByVisibleText(country);
        return this;
    }

    public RegisterPage fillUserInformation(String username, String password, String confirmPassword) {
        type(usernameInput, username);
        type(passwordInput, password);
        type(confirmPasswordInput, confirmPassword);
        return this;
    }

    public RegisterPage submitRegistration() {
        scrollIntoView(submitButton);
        click(submitButton);
        return this;
    }

    public boolean isRegistrationSuccessful() {
        return isDisplayed(successMessage);
    }

    public String firstNameValue() { return valueOf(firstNameInput); }
    public String lastNameValue() { return valueOf(lastNameInput); }
    public String phoneValue() { return valueOf(phoneInput); }
    public String emailValue() { return valueOf(emailInput); }
    public String addressValue() { return valueOf(addressInput); }
    public String cityValue() { return valueOf(cityInput); }
    public String stateValue() { return valueOf(stateInput); }
    public String postalCodeValue() { return valueOf(postalCodeInput); }
    public String usernameValue() { return valueOf(usernameInput); }
    public String passwordValue() { return valueOf(passwordInput); }
    public String confirmPasswordValue() { return valueOf(confirmPasswordInput); }

    public String selectedCountry() {
        return new Select(countrySelect).getFirstSelectedOption().getText().trim();
    }
    // DATO PARA EL ENTREGABLE, UTILIZAR ESTA FUNCION
}
