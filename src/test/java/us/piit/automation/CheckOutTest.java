package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class CheckOutTest extends CommonAPI {
    Logger log=LogManager.getLogger(CheckOutTest.class.getName());
    Properties pop= Utility.loadProperties();
    String validEmail =Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));
    String name= Utility.decode(pop.getProperty("automation.name"));
    String cardNumber=Utility.decode(pop.getProperty("automation.cardNumber"));
    String cvcNumber= Utility.decode(pop.getProperty("automation.cvcNumber"));
    String expireMonth= Utility.decode(pop.getProperty("automation.expireMonth"));
    String expireYear= Utility.decode(pop.getProperty("automation.expireYear"));
    @Test
    public void checkout() {


        //Enter Email, password, and click on login button
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());
        CheckOutPage checkoutPage=new CheckOutPage(getDriver());
        PaymentPage paymentPage=new PaymentPage(getDriver());
        Product_detailesPage product_detailesPage=new Product_detailesPage(getDriver());

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle= getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);


        // Enter Email, password, and click on login button

        loginPage.clickonloginbutton();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickonLoginBtn();


        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        waitFor(1);

        //click on view product, add to cart,view cart, proceed to checkout,place order and confirm

        productsPage.viewProduct();
        product_detailesPage.clickonaddtocart();
        waitFor(2);
        product_detailesPage.viewCart();
        checkoutPage.clickCheckOut();
        paymentPage.clickonPlaceOrder();

        paymentPage.enterName(name);
        paymentPage.enterCardNumber(cardNumber);
        paymentPage.entercvcNumber(cvcNumber);
        paymentPage.enterexpireMonth(expireMonth);
        paymentPage.enterexpireYear(expireYear);
        paymentPage.clickonpaymentConfirm();

        // validate the payment of the product
        String expectedtext="Congratulations! Your order has been confirmed!";
        String actualtext=homePage.welcomingMessage();
        Assert.assertEquals(expectedtext,actualtext);
        takeScreenshot("order payed succesfully");


    }
}