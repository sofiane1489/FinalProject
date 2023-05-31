package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;


public class NotificationBellPage extends CommonAPI {
    Logger log= LogManager.getLogger(NotificationBellPage.class.getName());

    public NotificationBellPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//*[@id=\"onesignal-bell-launcher\"]/div[1]/svg/path")
    WebElement notificationBellBtn;

    @FindBy(xpath = "//*[@id=\"onesignal-bell-launcher\"]/div[4]/div/h1")
    WebElement notificationText;

    public void setNotificationBellBtn(){
        clickOn(notificationBellBtn);
        log.info("click on notification bell success");
    }
    public String getNotificationText(){
        String text = getElementText(notificationText);
        log.info("get text success");
        return text;
    }
}






