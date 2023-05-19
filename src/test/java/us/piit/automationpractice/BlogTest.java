package us.piit.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPracticePages.AutoHomePage;
import us.piit.automationPracticePages.AutoLoginPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class BlogTest extends CommonAPI {
    Properties pro = Utility.loadProperties();
    String validUsername = Utility.decode(pro.getProperty("automationpractice.email"));
    String validPassword = Utility.decode(pro.getProperty("automationpractice.password"));

    @Test
    public void blogTest() {
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
        autoHomePage.clickOnBlogBtn();
    }
}
