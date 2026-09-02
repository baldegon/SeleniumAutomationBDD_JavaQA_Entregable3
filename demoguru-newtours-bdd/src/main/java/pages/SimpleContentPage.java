package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleContentPage extends BasePage {

    public SimpleContentPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageContains(String text) {
        return !driver.findElements(By.xpath("//*[contains(normalize-space(), '" + text + "')]")).isEmpty();
    }
}
