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

public class DeleteAccountTest extends CommonAPI {
    Logger log= LogManager.getLogger(DeleteAccountTest.class.getName());
    Properties pop=Utility.loadProperties();
    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword =Utility.decode(pop.getProperty("automation.validPassword"));

    @Test(priority = 20)
    public void deleteAcoount(){
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        waitFor(2);

        // Enter Email, password, and click on login button
        loginPage.clickonloginbutton();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickonLoginBtn();

        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);

        //click on delete account
        homePage.clickondeleteaccount();






    }
}
