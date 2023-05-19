package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.YoutubeChannelPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class VideoTuturialsSubscribe extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTuturialsSubscribe.class.getName());
    Properties pop = Utility.loadProperties();

    @Test
    public void youtubeSubscribe(){
        HomePage homePage = new HomePage(getDriver());
        YoutubeChannelPage youtubeChannelPage=new YoutubeChannelPage(getDriver());

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(4);
        // click on video tutorials, then click on subscribe on the channel
        homePage.clickonVideoTutorials();
        youtubeChannelPage.clicksubscribe();



        String expectedText1="Subscription added";
        String actualText1= youtubeChannelPage.getValidSubscriptionText();
        Assert.assertEquals(expectedText1,actualText1);



    }


}
