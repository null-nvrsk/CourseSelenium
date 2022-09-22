package pages.telecomunications;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MobileTopUpPage extends BasePage {

    public MobileTopUpPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonWallet = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By inputPhoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    private final By inputAmount = By.xpath("//input[@data-qa-node='amount']");
    private final By inputCardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    private final By inputCardExpDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    private final By inputCardCvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    private final By buttonAddToCart = By.xpath("//button[@data-qa-node='submit']");

    /**
     * Choose a card from the wallet
     * @return Mobile Top-Up Page Object
     */
     public MobileTopUpPage selectCardFromWallet(){
         driver.findElement(buttonWallet).click();
         return this;
     }

    /**
     * Enter phone number excluding country code
     * @param number phone number
     * @return Mobile Top-Up Page Object
     */
     public MobileTopUpPage enterPhoneNumber(String number){
         driver.findElement(inputPhoneNumber).sendKeys(number);
         return this;
     }

     public MobileTopUpPage enterAmount(String amount)
     {
         driver.findElement(inputAmount).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
         driver.findElement(inputAmount).sendKeys(amount);
         return this;
     }

    public MobileTopUpPage enterCardNumber(String cardNumber)
    {
        driver.findElement(inputCardNumber).sendKeys(cardNumber);
        return this;
    }

    public MobileTopUpPage enterCardExpDate(String expDate)
    {
        driver.findElement(inputCardExpDate).sendKeys(expDate);
        return this;
    }

    public MobileTopUpPage enterCardCvv(String cvv)
    {
        driver.findElement(inputCardCvv).sendKeys(cvv);
        return this;
    }

    public MobileTopUpPage submitCart()
    {
        driver.findElement(buttonAddToCart).click();
        return this;
    }
}
