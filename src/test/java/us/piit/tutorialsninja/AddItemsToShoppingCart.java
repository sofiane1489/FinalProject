package us.piit.tutorialsninja;


import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddItemsToShoppingCart extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail= Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;


    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();
        homePage.clickOnShowItemsAddedBtn();
        homePage.hoverOverclickOnCheckoutBtn();
        //add to cart validation
        Assert.assertTrue(checkoutPage.checkPresenceOfUserProcedureCheckout());
        captureScreenshot();
    }

}