package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.ProductsPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddItemsToCart extends CommonAPI {
    Logger log=LogManager.getLogger(AddItemsToCart.class.getName());
    Properties pop= Utility.loadProperties();

    @Test
    public void menTisherts() {

        ProductsPage productsPage = new ProductsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());



        // click on product,click on view item, add to cart then proceed to checkout
        productsPage.viewProduct();
        productsPage.addToCart();
        productsPage.viewCart();




        //verify the title of the homepage
//       String expectedTitle = "Automation Exercise";
//       String actualTitle= homePage.getCurrentTtile();;
//        Assert.assertEquals(expectedTitle, actualTitle);

    }
}