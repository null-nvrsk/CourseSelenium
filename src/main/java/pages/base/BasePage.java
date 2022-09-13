package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigation to specific URL
     */
    public void goToUrl(String url) {
        driver.get(url);
    }

    /**
     * Wait for visibility element in DOM model
     */
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
