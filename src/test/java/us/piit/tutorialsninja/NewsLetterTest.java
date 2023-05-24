package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class NewsLetterTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));

    @Test
    public void subscriptionTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        NewsLetterSubscriptionPage newsLetterSubscription = new NewsLetterSubscriptionPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        // subscribe
        homePage.clickOnSubscribeOrUnsubscribe();
        newsLetterSubscription.checkYesBox();
        newsLetterSubscription.clickOnContinueBtn();
        //validate subscription
        String expectedSubscriptionValidationMessage = "Success: Your newsletter subscription has been successfully updated!";
        String actualSubscriptionValidationMessage = homePage.getSubscriptionConfirmationMessage();
        Assert.assertEquals(expectedSubscriptionValidationMessage, actualSubscriptionValidationMessage);
    }

    @Test
    public void unsubscriptionTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        NewsLetterSubscriptionPage newsLetterSubscriptionPage = new NewsLetterSubscriptionPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        // subscribe
        homePage.clickOnSubscribeOrUnsubscribe();
        newsLetterSubscriptionPage.checkNoBox();
        newsLetterSubscriptionPage.clickOnContinueBtn();
        //validate subscription
        String expectedSubscriptionValidationMessage = "Success: Your newsletter subscription has been successfully updated!";
        String actualSubscriptionValidationMessage = homePage.getSubscriptionConfirmationMessage();
        Assert.assertEquals(expectedSubscriptionValidationMessage, actualSubscriptionValidationMessage);
    }
}