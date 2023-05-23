package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.ForgotPasswordPage;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class ForgottenPasswordTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));

    @Test
    public void resetPasswordTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //change forgotten password
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.clickOnForgottenPasswordLink();
        forgotPasswordPage.enterEmail(validEmail);
        forgotPasswordPage.clickOnContinueBtn();

        //reset validation
        String expectedTextMessage = "An email with a confirmation link has been sent your email address.";
        String actualTextMessage = loginPage.getTextMessage();
        Assert.assertEquals(expectedTextMessage, actualTextMessage);
    }
}
