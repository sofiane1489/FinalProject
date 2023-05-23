package us.piit.tutorialsninja;


import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddItemsToShoppingCartTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail= Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;


    @Test
    public void addToCartTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();

        //add to cart validation
       String expectedConfirmMessage = "Success: You have added HTC Touch HD to your shopping cart!\n" +
               "×";
       String actualConfirmMessage = addToShoppingCartPage.getConfirmAddMessage();
       Assert.assertEquals( actualConfirmMessage,expectedConfirmMessage);
    }

}