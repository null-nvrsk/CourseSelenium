package pages.telecomunications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MobileTopUpPage extends BasePage {

    public MobileTopUpPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");

     public MobileTopUpPage selectCardFromWallet(){
         driver.findElement(buttonWallet).click();
         return this;
     }
}
