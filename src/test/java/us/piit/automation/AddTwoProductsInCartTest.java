package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import us.piit.automationPages.Product_detailesPage;
import us.piit.automationPages.ProductsPage;
import us.piit.automationPages.ViewCartPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddTwoProductsInCartTest extends CommonAPI {

    Logger log= LogManager.getLogger(AddTwoProductsInCartTest.class.getName());
    Properties pop= Utility.loadProperties();
    @Test
    public void addTwoItemsInCart(){
        ProductsPage productsPage=new ProductsPage(getDriver());
        Product_detailesPage product_detailesPage=new Product_detailesPage(getDriver());

        // click on product button,hover over first product and click 'Add to cart
        productsPage.productButton();
        waitFor(3);
        productsPage.viewProduct();
        waitFor(3);
        product_detailesPage.clickonaddtocart();

        // click on continue shooping, hover over second product and click 'Add to cart'
        productsPage.clickoncontinueShooping();
        productsPage.productButton();
        waitFor(3);
        productsPage.viewProduct();
        product_detailesPage.clickonaddtocart();

        // click on view cart,
        product_detailesPage.viewCart();

        // verify both products are add to cart,verify their prices,quantity and total price




    }
}


