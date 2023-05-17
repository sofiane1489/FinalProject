package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.automationPages.ProductsPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class SearchProducts extends CommonAPI {
    Logger log= LogManager.getLogger(SearchProducts.class.getName());

    Properties pop = Utility.loadProperties();
    String productName= Utility.decode(pop.getProperty("automation.searchText"));
    @Test
    public void SearchProduct(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage=new ProductsPage(getDriver());

        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Type name of product then click on search button
        productsPage.productButton();


        // Verify user is navigated to ALL PRODUCTS page successfully
        boolean expectedPageWraperTitle=true;
        boolean actualPageWraperTitle=homePage.visibility();
        Assert.assertEquals(expectedPageWraperTitle,actualPageWraperTitle);

        productsPage.enterproduct(productName);
        productsPage.submitsearch();

        //Verify 'SEARCHED PRODUCTS' is visible
        boolean expectedPageHeaderTitle=true;
        boolean actualPageHeaderTitle=homePage.searchProduct();
        Assert.assertEquals(expectedPageHeaderTitle,actualPageHeaderTitle);

    }
}
