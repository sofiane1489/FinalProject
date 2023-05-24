package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class WishListTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));

    @Test
    public void AddItemToWishList() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CamerasPage camerasPage = new CamerasPage(getDriver());
        CamerasTypePage camerasTypePage = new CamerasTypePage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();

        //add item to wish list
        homePage.clickOnCamerasSectionBtn();
        camerasPage.clickOnProductImg();
        camerasTypePage.clickOnWishListBtn();
        //add to wish list validation
        Assert.assertTrue(homePage.checkPresenceOfNumberOfItemInWishList());
    }
}
