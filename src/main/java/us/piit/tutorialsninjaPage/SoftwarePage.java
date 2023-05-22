package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SoftwarePage extends CommonAPI {
    Logger log= LogManager.getLogger(SoftwarePage.class.getName());
    public SoftwarePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text()='Software']")
    WebElement validMessage;
    public String GetMessage(){
        String text = getElementText(validMessage);
        log.info("get message success");
        return text;
    }
}
