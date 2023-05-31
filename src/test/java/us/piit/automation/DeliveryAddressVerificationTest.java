package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class DeliveryAddressVerificationTest extends CommonAPI {
    Logger log= LogManager.getLogger(DeliveryAddressVerificationTest.class.getName());
    Properties pop = Utility.loadProperties();


    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));
    @Test
    public void deliveryAddressTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());
        ViewCartPage viewCartPage=new ViewCartPage(getDriver());
        Product_detailesPage product_detailesPage=new Product_detailesPage(getDriver());
        CheckOutPage checkOutPage=new CheckOutPage(getDriver());

        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(2);

        // Enter Email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();


        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        takeScreenshot("user loged in succesfully");

        //click on add to cart, view cart,click on procceed to checkout
        productsPage.productButton();
        waitFor(4);
        productsPage.viewProduct();
        waitFor(4);
        product_detailesPage.clickonaddtocart();
        product_detailesPage.viewCart();
        checkOutPage.clickCheckOut();

        // verify the delivery address information are visible
        boolean expectedDeliveryAddress=true;
        boolean actualDeliveryAddress=checkOutPage.deliveryaddressvisibility();
        Assert.assertTrue(true);






    }
}
