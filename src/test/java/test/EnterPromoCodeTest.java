package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.GreenkartHomePage;
import page.GreenkartCartPage;

public class EnterPromoCodeTest extends BaseTest {
    GreenkartCartPage greenkartCartPage;
    GreenkartHomePage greenkartHomePage;

    @Before

    public void setUpTest() {
        greenkartHomePage = new GreenkartHomePage();
        greenkartCartPage = new GreenkartCartPage();
        greenkartHomePage.setProductsList();
        greenkartHomePage.setFirstProduct();
        greenkartHomePage.addOneItemFourTimes();
        greenkartHomePage.addThreeRandomItems();
        greenkartHomePage.cartIconClick();
        greenkartHomePage.proceedToCheckoutButtonClick();
    }

    @Test
    public void placeOrderTest() {
        greenkartCartPage.enterPromoCodeFieldSendKeys();
        Assert.assertTrue(greenkartCartPage.totalAmountSpanIsDisplayed());
        Assert.assertTrue(greenkartCartPage.enterPromoCodeFieldIsDisplayed());
        Assert.assertEquals(greenkartCartPage.totalAmountSpanGetText(), greenkartCartPage.enterPromoCodeFieldGetText());
    }
}
