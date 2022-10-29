package pages.telecomunications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class MobileTopUpPage extends BasePage {

    private final SelenideElement buttonWallet = $x("//div[contains(text(), 'My wallet')]");
    private final SelenideElement inputPhoneNumber = $x("//input[@data-qa-node='phone-number']");
    private final SelenideElement inputAmount = $x("//input[@data-qa-node='amount']");
    private final SelenideElement inputCardNumber = $x("//input[@data-qa-node='numberdebitSource']");
    private final SelenideElement inputCardExpDate = $x("//input[@data-qa-node='expiredebitSource']");
    private final SelenideElement inputCardCvv = $x("//input[@data-qa-node='cvvdebitSource']");
    private final SelenideElement buttonAddToCart = $x("//button[@data-qa-node='submit']");
    private final SelenideElement textPaymentDetails = $x("//div[@data-qa-node='details']");


    /**
     * Choose a card from the wallet
     * @return Mobile Top-Up Page Object
     */
     public MobileTopUpPage selectCardFromWallet(){
         buttonWallet.shouldBe(Condition.visible).click();
         return this;
     }

    /**
     * Enter phone number excluding country code
     * @param number phone number
     * @return Mobile Top-Up Page Object
     */
     public MobileTopUpPage enterPhoneNumber(String number){
         inputPhoneNumber.shouldBe(Condition.visible).sendKeys(number);
         return this;
     }

     public MobileTopUpPage enterAmount(String amount){
         inputAmount.shouldBe(Condition.visible).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
         inputAmount.shouldBe(Condition.visible).sendKeys(amount);
         return this;
     }

    public MobileTopUpPage enterCardNumber(String cardNumber){
        inputCardNumber.shouldBe(Condition.visible).sendKeys(cardNumber);
        return this;
    }

    public MobileTopUpPage enterCardExpDate(String expDate){
        inputCardExpDate.shouldBe(Condition.visible).sendKeys(expDate);
        return this;
    }

    public MobileTopUpPage enterCardCvv(String cvv){
        inputCardCvv.shouldBe(Condition.visible).sendKeys(cvv);
        return this;
    }

    public MobileTopUpPage submitCart(){
        buttonAddToCart.shouldBe(Condition.visible).click();
        return this;
    }

    public MobileTopUpPage checkPaymentDetailsIsPresentInTheCart(String expectedText){
        textPaymentDetails.shouldBe(Condition.visible);

        Assertions.assertEquals(expectedText, textPaymentDetails.getText());
        return this;
    }
}
