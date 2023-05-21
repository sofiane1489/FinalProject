package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;



    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //check user is logged in
        boolean expectedUserTableOfContent = true;
        boolean actualUserTableOfContent = homePage.checkPresenceOfUserTableOfContent()
        Assert.assertEquals(expectedUserTableOfContent, actualUserTableOfContent);

        String expectedResult = "My Account";
        String actualResult= homePage.getMyAccountText();
        Assert.assertEquals(expectedResult, actualResult);
        captureScreenshot();
    }
    @Test
    public void invalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button

        useFakeEmail();
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //error validation

        String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage );
    }
    @Test
    public void missingPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button

        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword("");
        loginPage.clickOnLoginBtn();

        //error validation

        String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage );
    }


}