package page;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GreenkartCartPage extends BaseTest {

    public GreenkartCartPage() {

        PageFactory.initElements(driver, this);
    }
    @FindBy (className = ("promoCode"))
    WebElement enterPromoCodeField;
    @FindBy (className = "totAmt")
    WebElement totalAmountSpan;
    @FindBy (className = ("promoBtn"))
    WebElement applyButton;
    @FindBy (className = ("promoInfo"))
    WebElement errorMessageField;
    @FindBy (xpath = ("//button[text()='Place Order']"))
    WebElement placeOrderButton;

    public void enterPromoCodeFieldSendKeys() {
        wdWait.until(ExpectedConditions.elementToBeClickable(enterPromoCodeField)).clear();
        enterPromoCodeField.sendKeys(totalAmountSpan.getText());
    }
    public boolean totalAmountSpanIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(totalAmountSpan));
        return totalAmountSpan.isDisplayed();
    }
    public String totalAmountSpanGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(totalAmountSpan));
        return totalAmountSpan.getText();
    }
    public boolean enterPromoCodeFieldIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(enterPromoCodeField));
        return enterPromoCodeField.isDisplayed();
    }
    public String enterPromoCodeFieldGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(enterPromoCodeField));
        return enterPromoCodeField.getAttribute("value");
    }
    public void applyButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }
    public boolean errorMessageFieldIsDisplayed() {
        wdWait.until(ExpectedConditions.visibilityOf(errorMessageField));
        return errorMessageField.isDisplayed();
    }
    public String errorMessageFieldGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(errorMessageField));
        return errorMessageField.getText();
    }
    public void placeOrderButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }
}
