package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class PhonesAndPDAsTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));

    @Test
    public void phonesAndPDAsProductSection() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //navigate to phones and PDAs section
        homePage.clickOnPhonesAndPDAsSectionBtn();

        //phones and PDAs section validation
        String expectedPhonesAndPDAsSection = "Phones & PDAs";
        String actualPhonesAndPDAsSection = phonesAndPDAsPage.getValidationMessage();
        Assert.assertEquals(expectedPhonesAndPDAsSection, actualPhonesAndPDAsSection);
        captureScreenshot();
    }
}
