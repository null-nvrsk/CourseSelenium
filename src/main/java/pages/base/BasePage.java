package pages.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class BasePage {

    private final SelenideElement authWidget = $x("//iframe[@src='https://login-widget.privat24.ua/']");

    /**
     * Navigation to specific URL
     */
    public void goToUrl(String url) {
        open(url);
    }

    /**
     * Method that clean the element of the text and enter text
     * @param element Selenide element
     * @param value text
     */
    protected void clearAndType(SelenideElement element, String value){
        while (!element.getAttribute("value").equals(""))
            element.sendKeys(Keys.BACK_SPACE);
        element.setValue(value);
    }

    /**
     * Check is auth frame is visible
     */
    public void isAuthWidgetPresent(){
        authWidget.shouldBe(Condition.visible);
    }

    public void checkMessage(String message){
        $(byText(message)).shouldBe(Condition.visible);
    }
}
