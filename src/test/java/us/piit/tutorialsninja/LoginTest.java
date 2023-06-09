package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;



    @Test(groups = "group1")
    public void validCredential() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();


        //check user is logged in
        boolean expectedUserTableOfContent = true;
        boolean actualUserTableOfContent = homePage.checkPresenceOfUserTableOfContent();
        Assert.assertEquals(expectedUserTableOfContent, actualUserTableOfContent);

        String expectedResult = "My Account";
        String actualResult= homePage.getMyAccountText();
        Assert.assertEquals(expectedResult, actualResult);
        captureScreenshot();
    }
    @Test(groups = "group2")
    public void invalidEmail() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        useFakeEmail();
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //error validation

        boolean expectedErrorMessage = true;
        boolean actualErrorMessage = loginPage.checkPresenceOfErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage );

    }
    @Test(groups={"group1","group2"})
    public void missingPassword() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword("");
        loginPage.clickOnLoginBtn();

        //error validation

        boolean expectedErrorMessage = true;
        boolean actualErrorMessage = loginPage.checkPresenceOfErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage );
    }


}
