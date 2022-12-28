package test;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import page.GreenkartHomePage;
import page.GreenkartCartPage;

public class PlaceOrderTest extends BaseTest {
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
        greenkartCartPage.applyButtonClick();
    }

    @Test
    public void placeOrderTest() {
        greenkartCartPage.placeOrderButtonClick();

    }
}


