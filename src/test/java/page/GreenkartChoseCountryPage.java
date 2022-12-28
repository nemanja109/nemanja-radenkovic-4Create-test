package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GreenkartChoseCountryPage extends BaseTest {

    public GreenkartChoseCountryPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ("//label[text()='Choose Country']"))
    WebElement chooseCountryLabel;
    @FindBy(linkText = "Terms & Conditions")
    WebElement termsAndConditionsLink;

    public boolean chooseCountryLabelIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(chooseCountryLabel));
        return chooseCountryLabel.isDisplayed();
    }
    public boolean termsAndConditionsLinkIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(termsAndConditionsLink));
        return termsAndConditionsLink.isDisplayed();
    }
}


