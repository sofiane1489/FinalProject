package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LogoutAffirmationPage extends CommonAPI {
    Logger log= LogManager.getLogger(LogoutAffirmationPage.class.getName());
    public LogoutAffirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[text()='You have been logged off your account. It is now safe to leave the computer.']")
    WebElement validationLogout;
    public String getValidationLogoutMessage(){
        String text = getElementText(validationLogout);
        log.info("user logout success");
        return text;
    }

}
