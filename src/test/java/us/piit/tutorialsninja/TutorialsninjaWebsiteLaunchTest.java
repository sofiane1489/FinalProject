package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.WelcomePage;

public class TutorialsninjaWebsiteLaunchTest extends CommonAPI {

    @Test
    public void WebsiteLaunchTest(){
        WelcomePage welcomePage = new WelcomePage(getDriver());

        //launch to website
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //check website is launched successfully
        String expectedLogoName = "Qafox.com";
        String actualLogoName = welcomePage.getWebsiteLogo();
        Assert.assertEquals(expectedLogoName, actualLogoName);

        Assert.assertTrue(welcomePage.checkPresenceOfTutorialsninjaWebsiteLogo());
    }
}
