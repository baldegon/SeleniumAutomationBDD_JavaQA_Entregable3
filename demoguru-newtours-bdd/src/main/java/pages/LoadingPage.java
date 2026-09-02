package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingPage extends BasePage{

    @FindBy(name = "https://the-internet.herokuapp.com/dynamic_loading/2") private WebElement urlPage;
    @FindBy(xpath = "//h3[contains(normalize-space(), 'Dynamically Loaded Page Elements')]") private WebElement pageTitle;
    @FindBy(xpath = "//button[contains(normalize-space(), 'Start')]") private WebElement startButton;
    @FindBy(xpath = "//h4[contains(normalize-space(), 'Hello World!')]") private WebElement successMessage;

    public LoadingPage(WebDriver driver) {super(driver);}

    public boolean isLoaded()
    {
        return isDisplayed(pageTitle);
    }

    public boolean buttonExists(){
        return isDisplayed(startButton);
    }

    public void pressButtonStart(){
        click(startButton);
    }

    public boolean successFlow(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }



}
