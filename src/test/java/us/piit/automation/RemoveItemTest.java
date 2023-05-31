

package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class RemoveItemTest extends CommonAPI {
   Logger log = LogManager.getLogger(RemoveItemTest.class.getName());
    Properties pop= Utility.loadProperties();
    String validEmail =Utility.decode( pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));

    @Test
    public void removeitemfromcart(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ViewCartPage viewcartPage=new ViewCartPage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());
        Product_detailesPage product_detailesPage=new Product_detailesPage(getDriver());

        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Enter Email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();



        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);

        productsPage.viewProduct();
        waitFor(3);
        product_detailesPage.clickonaddtocart();
        product_detailesPage.viewCart();
        viewcartPage.deleteItem();

        // validate that product is deleted
        String expectedText="";
        String actualText=homePage.emtyCart();
        Assert.assertEquals(expectedText,actualText);
    }
}