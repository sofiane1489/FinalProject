package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.automationPages.ProductsPage;
import us.piit.automationPages.ViewCartPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class SubscribeInCartPage extends CommonAPI {
    Logger log = LogManager.getLogger(SubscribeInHomePage.class.getName());
    Properties pop = Utility.loadProperties();
    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
   @Test
        public void subscription1() {

    HomePage homePage = new HomePage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    ProductsPage productsPage=new ProductsPage(getDriver());
    ViewCartPage viewCartPage = new ViewCartPage(getDriver());

    // Verify the title of the page
    String expectedTitle = "Automation Exercise";
    String actualTitle = getCurrentTtile();
    Assert.assertEquals(expectedTitle, actualTitle);

    // clcik on cart button
    viewCartPage.shoopingCart();

    //verify the text "subscribtion" is visible
    boolean expectedText=true;
    boolean actualText=homePage.getSubscribeText();
    Assert.assertTrue(actualText);

    //type email in the subscribe field then click on the arrow button

    loginPage.enterEmail(validEmail);
    homePage.clickonArrowButton();
    waitFor(2);




}
}