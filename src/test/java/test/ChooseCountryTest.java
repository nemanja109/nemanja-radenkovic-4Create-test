package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.GreenkartChoseCountryPage;
import page.GreenkartHomePage;
import page.GreenkartCartPage;

public class ChooseCountryTest extends BaseTest {
    GreenkartCartPage greenkartCartPage;
    GreenkartHomePage greenkartHomePage;
    GreenkartChoseCountryPage greenkartChoseCountryPage;


    @Before

    public void setUpTest() {
        greenkartHomePage = new GreenkartHomePage();
        greenkartCartPage = new GreenkartCartPage();
        greenkartChoseCountryPage = new GreenkartChoseCountryPage();
        greenkartHomePage.setProductsList();
        greenkartHomePage.setFirstProduct();
        greenkartHomePage.addOneItemFourTimes();
        greenkartHomePage.addThreeRandomItems();
        greenkartHomePage.cartIconClick();
        greenkartHomePage.proceedToCheckoutButtonClick();
        greenkartCartPage.enterPromoCodeFieldSendKeys();
        greenkartCartPage.applyButtonClick();
        greenkartCartPage.placeOrderButtonClick();
    }

    @Test
    public void chooseCountryTest() {
        Assert.assertTrue(greenkartChoseCountryPage.chooseCountryLabelIsDisplayed());
        Assert.assertTrue(greenkartChoseCountryPage.termsAndConditionsLinkIsDisplayed());
    }
}


