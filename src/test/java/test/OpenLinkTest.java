package test;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.GreenkartHomePage;

public class OpenLinkTest extends BaseTest {
    GreenkartHomePage greenkartHomePage;

    @Before
    public void setUpTest() {
        greenkartHomePage = new GreenkartHomePage();
    }

    @Test
    public void openLinkTest() {
        Assert.assertTrue(greenkartHomePage.isLogoDisplayed());
    }
}
