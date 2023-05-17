package us.piit.automation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class UserLogout extends CommonAPI {
    Logger log = LogManager.getLogger(UserLogout.class.getName());

    Properties pop = Utility.loadProperties();
    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword = Utility.decode(pop.getProperty("automation.validPassword"));

    @Test
    public void logout() {
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

        // click on logout button
        homePage.clickonlogout();

        // verify that user is logedout and landed in the loginpage
        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
        log.info("login page header is displayed");

        String expectedLoginPageHeaderText = "Login to your account";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");


    }

}