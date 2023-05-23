package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VideoTutorialsPage extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());
    public VideoTutorialsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse']//div[@class='yt-spec-touch-feedback-shape__fill']")
    WebElement subscribe;
//    @FindBy(xpath= "//body/ytd-app[1]/ytd-popup-container[1]/yt-notification-action-renderer[7]/tp-yt-paper-toast[1]/div[1]/yt-formatted-string[1]")
//    WebElement addsubscription;
    public void clickonSubscribe(){
        clickOn(subscribe);
        log.info("clickonSubscribe success");
    }
//    public String usersubscribetothechannel(){
//        String text = getElementText(addsubscription);
//        log.info("user subscribe success");
//        return text;

    }

   // }


