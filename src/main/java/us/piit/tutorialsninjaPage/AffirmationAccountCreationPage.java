package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AffirmationAccountCreationPage extends CommonAPI {
    Logger log= LogManager.getLogger(AffirmationAccountCreationPage.class.getName());
    public AffirmationAccountCreationPage(WebDriver driver){
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#content > p:nth-child(2)")
    WebElement registrationConfirmationField;

    public String getConfirmationMessage(){
        String text = getElementText(registrationConfirmationField);
        log.info("get message success");
        return text;
    }
}
