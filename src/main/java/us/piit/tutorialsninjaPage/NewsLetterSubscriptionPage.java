package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class NewsLetterSubscriptionPage extends CommonAPI {
    Logger log= LogManager.getLogger(NewsLetterSubscriptionPage.class.getName());
    public NewsLetterSubscriptionPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content form fieldset div div label:nth-child(1) input[type=radio]")
    WebElement subscribeStatus;
    @FindBy(css = "#content form div div.pull-right input")
    WebElement continueBtn;
    @FindBy(css = "#content form fieldset div div label:nth-child(2) input[type=radio]")
    WebElement userSubscriptionStatus;
    public void checkYesBox(){
        clickOn(subscribeStatus);
        log.info("check yes box success");
    }
    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        log.info("click on continue button success");
    }
    public void checkNoBox(){
        clickOn(userSubscriptionStatus);
        log.info("check  no box success");
    }
}
