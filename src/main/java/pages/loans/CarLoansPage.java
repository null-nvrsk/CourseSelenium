package pages.loans;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class CarLoansPage extends BasePage {

    private final SelenideElement tabAgreements = $x("//div[contains(text(), 'Agreements')]");

    public CarLoansPage selectAgreementsTab() {
        tabAgreements.shouldBe(Condition.visible).click();
        return this;
    }
}
