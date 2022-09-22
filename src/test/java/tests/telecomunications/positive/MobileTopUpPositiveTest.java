package tests.telecomunications.positive;

import constants.Constant;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.MobileRefillTestData.*;
import static constants.Constant.Urls.MOBILE_PAYMENT_URL;

public class MobileTopUpPositiveTest extends BaseTest {

    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobileTopUpPage.selectCardFromWallet();
        basePage.isAuthWidgetPresent();
    }

    @Test
    public void checkMinimumRefillAmount(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobileTopUpPage.enterPhoneNumber(MOBILE_PAYMENT_PHONE_NUMBER)
                .enterCardNumber(MOBILE_PAYMENT_CARD)
                .enterCardExpDate(MOBILE_PAYMENT_CARD_EXP_DATE)
                .enterCardCvv(MOBILE_PAYMENT_CARD_CVV)
                .enterAmount("1")
                .submitCart();

    }
}
