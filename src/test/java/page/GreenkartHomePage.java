package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GreenkartHomePage extends BaseTest {

    public GreenkartHomePage() {

        PageFactory.initElements(driver, this);
    }
    @FindBy (css = (".brand.greenLogo"))
    WebElement greenLogo;

    @FindBy (className = ("cart-icon"))
    WebElement cartIcon;
    @FindBy (className = ("action-block"))
    WebElement proceedToCheckoutButton;
    List<WebElement> productsList;
    WebElement firstProduct;
    int sumOffFourProducts;
    int sumOffRandomProducts;

    public void setProductsList() {
        productsList = driver.findElement(By.className("products")).findElements(By.className("product"));
    }
    public void addOneItemFourTimes() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum = sum + addProductByIndex(0);
        }
        sumOffFourProducts = sum;
    }
    private int addProductByIndex(int productIndex) {
        WebElement productContainer = productsList.get(productIndex);
        int price = Integer.parseInt(productContainer.findElement(By.className("product-price")).getText());
        WebElement addToCartButton = productContainer.findElement(By.tagName("button"));
        wdWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return price;
    }
    public void addThreeRandomItems() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = sum + addRandomProduct();
        }
        sumOffRandomProducts = sum;
    }
    private int addRandomProduct() {
        int randomIndex = getRandomIndex();
        return addProductByIndex(randomIndex);
    }
    private int getRandomIndex() {
        int min = 0;
        int max = 7;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
    public boolean isLogoDisplayed(){
        return greenLogo.isDisplayed();
    }
    public void setFirstProduct() {
        firstProduct = productsList.get(0);
    }

    public boolean isOneItemAddedCorrectly() {
        int priceFromCart = getPriceFromCart();
        return priceFromCart == sumOffFourProducts;
    }
    private int getPriceFromCart() {
        WebElement cartInfo = driver.findElements(By.className("cart-info")).get(0);
        String price = cartInfo.findElements(By.tagName("strong")).get(1).getText();
        return Integer.parseInt(price);
    }
    public boolean areRandomItemsAddedCorrectly() {
        int priceFromCart = getPriceFromCart();
        return priceFromCart == sumOffFourProducts + sumOffRandomProducts;
    }
    public void cartIconClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
    public void proceedToCheckoutButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
    }

}
