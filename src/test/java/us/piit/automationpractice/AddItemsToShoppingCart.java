package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePage.*;
import us.piit.base.CommonAPI;

public class AddItemsToShoppingCart extends CommonAPI {
    Logger log = LogManager.getLogger(AddItemsToShoppingCart.class.getName());

    String validUsername = "yaya@gmail.com";
    String validPassword = "abcd1234$";

    @Test
    public void validCredential() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        AutoHomePage homePage = new AutoHomePage(getDriver());
        WomenDressesPage womenDressesPage=new WomenDressesPage(getDriver());
        PrintedSummerDressPage printedSummerDressPage = new PrintedSummerDressPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();
        homePage.clickOnDressesSectionBtn();
        womenDressesPage.clickOnDressesCategories();
        womenDressesPage.clickOnProductImage();
        printedSummerDressPage.clickOnSizeSelectioBox();
        printedSummerDressPage.selectSizeM();
        printedSummerDressPage.clickOnColorsChooses();
        printedSummerDressPage.clickOnQuantityUpBtn();
        printedSummerDressPage.clickOnAddToCartBtn();
        //add to cart validation
//        String expectedMessageAddConfirmation ="";
//        String actualMessageAddConfirmation = printedSummerDressPage.getElementText();

        }

    }
}
