package us.piit.automationpractice;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddItemsToShoppingCart extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validUsername= Utility.decode(pro.getProperty("automationpractice.email")) ;
    String validPassword=Utility.decode(pro.getProperty("automationpractice.password")) ;


    @Test
    public void validCredential() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        WomenDressesPage womenDressesPage=new WomenDressesPage(getDriver());
        SummuryProductPage summuryProductPage = new SummuryProductPage(getDriver());
        PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.enterPassword(validPassword);
        autoLoginPage.clickOnLoginBtn();
        autoHomePage.clickOnDressesSectionBtn();
        womenDressesPage.clickOnDressesCategories();
        womenDressesPage.clickOnProductImage();

        printedSummerDressPage.clickOnSizeSelectionBox();

        printedSummerDressPage.selectSizeM();

        printedSummerDressPage.clickOnColorsChooses();

        printedSummerDressPage.clickOnQuantityUpBtn();

        printedSummerDressPage.clickOnAddToCartBtn();
        waitFor(2);
        //add to cart validation

        Assert.assertTrue(summuryProductPage.productSuccessfullyAdded());

    }

}