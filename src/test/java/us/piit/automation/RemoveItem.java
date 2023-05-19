

package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.automationPages.ProductsPage;
import us.piit.automationPages.ViewcartPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class RemoveItem extends CommonAPI {
   Logger log = LogManager.getLogger(RemoveItem.class.getName());
    Properties pop= Utility.loadProperties();
    String validEmail =Utility.decode( pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));

    @Test
    public void removeitemfromcart(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ViewcartPage viewcartPage=new ViewcartPage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());

        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Enter Email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();
        waitFor(5);

        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);

        productsPage.addToCart();

        productsPage.viewCart();
        viewcartPage.shoopingCart();

        viewcartPage.deleteItem();

        // validate that product is deleted
        String expectedText="";
        String actualText=homePage.emtyCart();
       Assert.assertEquals(expectedText,actualText);

    }
}