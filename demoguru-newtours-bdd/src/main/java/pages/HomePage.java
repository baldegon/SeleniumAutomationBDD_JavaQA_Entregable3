package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='SIGN-ON']")
    private WebElement signOnLink;

    @FindBy(xpath = "//a[normalize-space()='REGISTER']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[normalize-space()='SUPPORT']")
    private WebElement supportLink;

    @FindBy(xpath = "//a[normalize-space()='CONTACT']")
    private WebElement contactLink;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[normalize-space()='Flights']")
    private WebElement flightsLink;

    @FindBy(xpath = "//a[normalize-space()='Hotels']")
    private WebElement hotelsLink;

    @FindBy(xpath = "//a[normalize-space()='Car Rentals']")
    private WebElement carRentalsLink;

    @FindBy(xpath = "//a[normalize-space()='Cruises']")
    private WebElement cruisesLink;

    @FindBy(xpath = "//a[normalize-space()='Destinations']")
    private WebElement destinationsLink;

    @FindBy(xpath = "//a[normalize-space()='Vacations']")
    private WebElement vacationsLink;

    @FindBy(name = "userName")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isDisplayed(signOnLink) && isDisplayed(registerLink) && isDisplayed(loginButton);
    }

    public LoginPagea goToSignOn() {
        click(signOnLink);
        return new LoginPagea(driver);
    }

    public RegisterPage goToRegister() {
        click(registerLink);
        return new RegisterPage(driver);
    }

    public SimpleContentPage goToSupport() {
        click(supportLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToContact() {
        click(contactLink);
        return new SimpleContentPage(driver);
    }

    public HomePage goToHome() {
        click(homeLink);
        return new HomePage(driver);
    }

    public SimpleContentPage goToFlights() {
        click(flightsLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToHotels() {
        click(hotelsLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToCarRentals() {
        click(carRentalsLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToCruises() {
        click(cruisesLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToDestinations() {
        click(destinationsLink);
        return new SimpleContentPage(driver);
    }

    public SimpleContentPage goToVacations() {
        click(vacationsLink);
        return new SimpleContentPage(driver);
    }

    public void enterUsername(String username) {
        type(userNameInput, username);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public LoginPagea submitLogin() {
        click(loginButton);
        return new LoginPagea(driver);
    }

    public String usernameValue() {
        return valueOf(userNameInput);
    }

    public String passwordValue() {
        return valueOf(passwordInput);
    }
}
