package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class CheckoutTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userFirstName=Utility.decode(pro.getProperty("tutorialsninja.firstname")) ;
    String userLastName=Utility.decode(pro.getProperty("tutorialsninja.lastname")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;
    String userAddress=Utility.decode(pro.getProperty("tutorialsninja.address")) ;
    String userCity=Utility.decode(pro.getProperty("tutorialsninja.city")) ;
    String userZipCode=Utility.decode(pro.getProperty("tutorialsninja.zipcode")) ;
    @Test
    public void ProceedToCheckoutTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add item to cart
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();
        homePage.clickOnSItemCartCount();
        homePage.hoverOverAndClickOnCheckoutBtn();

        //proceed to checkout
        checkoutPage.clickOnNewAddressBtn();
        checkoutPage.enterFirstName(userFirstName);
        checkoutPage.enterLastName(userLastName);
        checkoutPage.enterAddress(userAddress);
        checkoutPage.enterCity(userCity);
        checkoutPage.enterZipCode(userZipCode);
        checkoutPage.clickOnCountryBox();
        checkoutPage.hoverOverAndClickOnCountryName();
        checkoutPage.clickOnStatBox();
        checkoutPage.hoverOverAndClickOnStatName();
        checkoutPage.clickOnAddressContinueBtn();
        checkoutPage.clickOnShippingDetailsBtn();
        checkoutPage.clickOnShippingMethodBtn();
        checkoutPage.checkAgreementBoxBtn();
        checkoutPage.clickOnShippingPaymentMethodBtn();
        checkoutPage.clickOnConfirmOrderBtn();

        //order validation
        String expectedOrderMessageConfirmation = "Your order has been placed!";
        String actualOrderMessageConfirmation = orderConfirmationPage.getOrderProceedingConfirmationMessage();
        Assert.assertEquals(expectedOrderMessageConfirmation, actualOrderMessageConfirmation);
    }
}
