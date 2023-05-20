package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.ProductsPage;
import us.piit.automationPages.WomensProductPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class ViewCategoryProduct extends CommonAPI {
    Logger log = LogManager.getLogger(ViewCategoryProduct.class.getName());

    Properties pop = Utility.loadProperties();

    @Test
    public void checkvisibility(){
        HomePage homePage=new HomePage(getDriver());
        WomensProductPage womensProductPage=new WomensProductPage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());

        //click on product button
        productsPage.productButton();
        waitFor(5);

        //Verify that categories are visible on left sidebar
         boolean expectedText= true;
         boolean actualText=productsPage.getCtegoryText();
         Assert.assertEquals(expectedText,actualText);

         //Click on 'Women' category,Click on any sub category link under 'Women' category, for example: Dress

        productsPage.clickonwomencategory();

        waitFor(3);

        womensProductPage.clickonTops();



    }

}
