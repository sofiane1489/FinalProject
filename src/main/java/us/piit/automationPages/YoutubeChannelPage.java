package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class YoutubeChannelPage extends CommonAPI {
    Logger log = LogManager.getLogger(YoutubeChannelPage.class.getName());

    public YoutubeChannelPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//tp-yt-app-header/div[@id='contentContainer']/div[@id='channel-container']/div[@id='channel-header']/div[@id='channel-header-container']/div[@id='inner-header-container']/div[@id='buttons']/div[@id='subscribe-button']/ytd-subscribe-button-renderer[1]/yt-smartimation[1]/div[2]/ytd-subscription-notification-toggle-button-renderer-next[1]/yt-button-shape[1]/button[1]/yt-touch-feedback-shape[1]/div[1]/div[2]")
    WebElement youtubeSubscribe;
    @FindBy(css = "#text-container")
    WebElement subscriptionText;


    public void clicksubscribe(){
       clickOn(youtubeSubscribe);
       log.info("click on subscribe  button success");
    }
    public String getValidSubscriptionText() {
        String text = getElementText(subscriptionText);
        log.info("user subscribe success");
        return  text;
    }

}
