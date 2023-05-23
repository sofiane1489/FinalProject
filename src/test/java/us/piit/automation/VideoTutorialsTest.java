package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.LoginPage;
import us.piit.automationPages.VideoTutorialsPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class VideoTutorialsTest extends CommonAPI {

    Logger log = LogManager.getLogger(UserLoginTest.class.getName());

    Properties pop = Utility.loadProperties();


    String validEmail = Utility.decode(pop.getProperty("automation.validEmail"));
    String validPassword = Utility.decode(pop.getProperty("automation.validPassword"));

    @Test(priority = 15)
    public void subscribeToChannel() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        VideoTutorialsPage videoTutorialsPage=new VideoTutorialsPage(getDriver());

        // Verify the title of the page
        String expectedTitle = "automationexercise.com";
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

        // click on video tutorials then click on subscribe to the YouTube channel
        homePage.clickonvideotutorials();

        waitFor(5);

        videoTutorialsPage.clickonSubscribe();

        waitFor(2);
        takeScreenshot("user subscribe success");

        // verify user subscribe succesfully
//        String expectedtext="Subscription added";
//
//        String actualtext=videoTutorialsPage.usersubscribetothechannel();
//
//        Assert.assertEquals(expectedtext,actualtext);



    }
}
