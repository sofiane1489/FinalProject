package us.piit.automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class UserLogin extends CommonAPI {
    Logger log = LogManager.getLogger(UserLogin.class.getName());

    Properties pop = Utility.loadProperties();


    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));
    String invalidEmail=Utility.decode( pop.getProperty("automation.invalidEmail"));
    String invalidPassword= Utility.decode(pop.getProperty("automation.invalidPassword"));




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

        // Click signing,enter  email, password, and click on login button loginPage.
        loginPage.clickonloginbutton();

        loginPage.enterEmail(invalidEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickonLoginBtn();
        waitFor(3);

        //validate the error message
        String expectedError = "Your email or password is incorrect!";
        String actualError=loginPage.getErrorMessageInvalidEmail();
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
        loginPage.enterPassword(invalidPassword);
        loginPage.clickonLoginBtn();
        waitFor(5);

        //validate the error message
        String expectedError = "Your email or password is incorrect!";
        String actualError=loginPage.getErrorMessageInvalidPassword();
        Assert.assertEquals(expectedError, actualError);

    }
}



