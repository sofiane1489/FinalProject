package us.piit.tutorialsninja;


import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddItemsToShoppingCartTest extends CommonAPI {
    Properties pro = Utility.loadProperties();
    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));
    String quantity = Utility.decode(pro.getProperty("tutorialsninja.number"));


    @Test
    public void addToCartTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();

        //add to cart validation
        String expectedConfirmMessage = "Success: You have added HTC Touch HD to your shopping cart!\n" +
                "×";
        String actualConfirmMessage = addToShoppingCartPage.getConfirmAddMessage();
        Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
    }

    @Test
    public void addMultipleItemsTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add the first item to cart
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();
        //add the second item to cart
        homePage.hoverOverAndclickOnLaptopsAndNotebooksBtn();
        homePage.clickOnShowAllLaptopsAndNotebooks();
        laptopsAndNotebooksPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();

        //validate items count
        Assert.assertTrue(homePage.checkCountOfItemsAddedToCart());
    }

    @Test
    public void quantityAdderTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add the first item to cart
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAndDelete();
        addToShoppingCartPage.enterItemQuantity(quantity);
        addToShoppingCartPage.clickOnAddToCartBtn();
        homePage.clickOnSItemCartCount();
        //validate item quantity
        Assert.assertTrue(homePage.checkQuantityOfItemsAddedToCart());

    }

    @Test
    public void removeItem() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add the first item to cart
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();
        homePage.clickOnSItemCartCount();
        homePage.clickOnViewCartBtn();
        shoppingCartPage.clickOnRemoveBtn();
        waitFor(1);

        //product remove validation
        String expectedMessage = "Your shopping cart is empty!";
        String actualMessage = shoppingCartPage.getRemoveConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void updateShoppingCart() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        AddToShoppingCartPage addToShoppingCartPage = new AddToShoppingCartPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        // enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add the first item to cart
        homePage.clickOnPhonesAndPDAsSectionBtn();
        phonesAndPDAsPage.hoverOverAndClickOnProductImg();
        addToShoppingCartPage.clickOnAddToCartBtn();
        homePage.clickOnSItemCartCount();
        homePage.clickOnViewCartBtn();
        shoppingCartPage.clickOnUpdateBtn();

        //update validation
        String expectedUpdateNotification = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualUpdateNotification = shoppingCartPage.getShoppingCartUpdateConfirmation();
        Assert.assertEquals(expectedUpdateNotification, actualUpdateNotification);
    }
}