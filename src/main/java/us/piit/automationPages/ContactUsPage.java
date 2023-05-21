package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsPage.class.getName());
    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[8]/a[1]")
    WebElement contactSupportButton;
    @FindBy(xpath = "//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[3]/form[1]/div[3]/input[1]")
    WebElement subjectField;
    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitButton;
    @FindBy(xpath = "//body/div[@id='contact-page']/div[2]/div[1]/div[1]/div[2]")
    WebElement successMessage;

    public void contactSupport(){
        clickOn(contactSupportButton);
        log.info("click on contact us success");
    }
    public void enterSubject(String subject) {
        type(subjectField,subject);
        log.info("enter subject text success");
    }
    public void enterMessage(String message){
        type(messageField,message);
        log.info("enter text message success");
    }
    public void clickonsubmitbutton(){
        clickOn(submitButton);
        log.info("click on submit button success");
    }
    public String getMessage(){
        String text=getElementText(successMessage);
        log.info("success message displayed");
        return  text;

    }



}

