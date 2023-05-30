package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.SpecialOffersPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class SpecialsTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));


    @Test
    public void specialOffers() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SpecialOffersPage specialOffersPage = new SpecialOffersPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //navigate to special offers
        homePage.scrollToSpecialsBtn(getDriver());
        //page validation
        String expectedPageTitle = "Special Offers";
        String actualPageTitle = specialOffersPage.getPageName();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        captureScreenshot();
    }
}
