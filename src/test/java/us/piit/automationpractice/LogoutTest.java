package us.piit.automationpractice;

import org.testng.Assert;
import us.piit.automationPracticePages.AutoHomePage;
import us.piit.automationPracticePages.AutoLoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class LogoutTest extends CommonAPI {
    Properties pro= Utility.loadProperties();

    String validUsername=Utility.decode(pro.getProperty("automationpractice.email")) ;
    String validPassword=Utility.decode(pro.getProperty("automationpractice.password")) ;
    // @Test
    public void logoutTest() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.enterPassword(validPassword);
        autoLoginPage.clickOnLoginBtn();
        waitFor(3);
        autoHomePage.clickOnLogoutBtn();

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = autoHomePage.getWelcomeMessage();
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);

        //check user is logged out
        //Assert.assertTrue(autoLoginPage.checkPresenceOfSignInPage());

    }
}
