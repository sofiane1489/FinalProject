package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.PoloBrandPage;
import us.piit.automationPages.ProductsPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class BrandProduct extends CommonAPI {
    Logger log = LogManager.getLogger(ViewCategoryProduct.class.getName());

    Properties pop = Utility.loadProperties();

    @Test
    public void poloBrand() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        PoloBrandPage poloBrandPage=new PoloBrandPage(getDriver());

        //click on product button
        productsPage.productButton();
        waitFor(5);
        // Verify that Brands are visible on left sidebar
        boolean expectedText= true;
        boolean actualText=productsPage.getBrandText();
        Assert.assertEquals(expectedText,actualText);

       // click on polo brand
        poloBrandPage.clickonPoloBrand();



        //Verify that user is navigated to brand page and polo brand products are displayed
        String expectedPagehaederText="BRAND - POLO PRODUCTS";
        String actualPagehaederText=poloBrandPage.getPageHeaderTitle();
        Assert.assertEquals(expectedPagehaederText,actualPagehaederText);





    }
}