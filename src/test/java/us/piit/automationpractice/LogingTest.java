package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.AutoLoginPage;
import us.piit.AutomationPracticePages.CreateAccountAuthenticationPage;
import us.piit.base.CommonAPI;

public class LogingTest extends CommonAPI {
    Logger log= LogManager.getLogger(LogingTest.class.getName());

    String validUsername = "yaya@gmail.com";
    String validPassword = "abcd1234$";

    @Test
    public void validCredential() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage homePage = new CreateAccountAuthenticationPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = homePage.getHeaderText();
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);

    }
    @Test
    public void invalidUsername() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage homePage = new CreateAccountAuthenticationPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //error validation

        Assert.assertTrue(loginPage.checkPresenceOfErrorMessage());

    }
    @Test
    public void missingPassword() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage homePage = new CreateAccountAuthenticationPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();;
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword("");
        loginPage.clickOnLoginBtn();

        //error validation

        Assert.assertTrue(loginPage.checkPresenceOfErrorMessage());
    }

}