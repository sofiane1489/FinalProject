package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.base.CommonAPI;

public class UserLogin extends CommonAPI {
    Logger log = LogManager.getLogger(UserLogin.class.getName());
    String validEmail = "adam2023@outlook.com";
    String validPassword = "Adana2023#";




    @Test
    public void validCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        waitFor(5);

        // Enter Email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();
        waitFor(5);

        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);


    }

    @Test
    public void invalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Clickon signin,enter  email, password, and click on login button loginPage.
        loginPage.clickonloginbutton();
        loginPage.enterEmail("invalidEmail");
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();
        waitFor(5);

        //validate the error message
        String expectedError = "Your email or password is incorrect!";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);

    }
    @Test
    public void invalidPassword (){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // verify the homepage title
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click signing,enter  email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword("invalidPassword");
        loginPage.clickonLoginBtn();
        waitFor(5);

        //validate the error message
        String expectedError = "Your email or password is incorrect!";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);

    }
}




