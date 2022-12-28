package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.GreenkartHomePage;
import page.GreenkartCartPage;

public class ApplyButtonErrorMessageTest extends BaseTest {
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
        greenkartCartPage.enterPromoCodeFieldSendKeys();
    }

    @Test
    public void applyButtonErrorMessageTest() {
        greenkartCartPage.applyButtonClick();
        Assert.assertTrue(greenkartCartPage.errorMessageFieldIsDisplayed());
        Assert.assertEquals("Invalid code ..!", greenkartCartPage.errorMessageFieldGetText());
    }
}

