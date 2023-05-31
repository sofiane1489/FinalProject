package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.Product_detailesPage;
import us.piit.automationPages.ProductsPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class UpdateQuantityInCart extends CommonAPI {
    Logger log = LogManager.getLogger(UpdateQuantityInCart.class.getName());
    Properties pop = Utility.loadProperties();

    @Test
    public void updateQuantity() {

        ProductsPage productsPage = new ProductsPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        Product_detailesPage product_detailesPage=new Product_detailesPage(getDriver());


        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        productsPage.productButton();
        waitFor(4);
        productsPage.viewProduct();
        productsPage.updateQuantity();
        product_detailesPage.clickonaddtocart();
        product_detailesPage.viewCart();





    }
}