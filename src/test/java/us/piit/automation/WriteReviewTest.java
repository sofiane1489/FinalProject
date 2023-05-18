package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.ProductsPage;
import us.piit.automationPages.RegistrationPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class WriteReviewTest extends CommonAPI {

    Logger log = LogManager.getLogger(WriteReviewTest.class.getName());
    Properties pop = Utility.loadProperties();
    String name2= Utility.decode(pop.getProperty("automation.name2"));
    String email2 = Utility.decode(pop.getProperty("automation.emailAdress"));

    @Test
    public void writereview(){

        ProductsPage productsPage = new ProductsPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        RegistrationPage registrationPage=new RegistrationPage(getDriver());

        // click on product button, click on view product, write a review then click submit
        productsPage.productButton();

        boolean expectedTitle=true;
        boolean actualTitle=homePage.allproducts();
        Assert.assertEquals(expectedTitle,actualTitle);

        productsPage.viewProduct();
        productsPage.name2(name2);
        productsPage.email2(email2);
        productsPage.review();
        productsPage.submitreview();









    }

}
