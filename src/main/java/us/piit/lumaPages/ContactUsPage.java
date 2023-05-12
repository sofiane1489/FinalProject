package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ContactUsPage extends CommonAPI {
    Logger log= LogManager.getLogger(ContactUsPage.class.getName());

    public ContactUsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#name")
    WebElement nameField;

    @FindBy(css="#email")
    WebElement emailField;

    @FindBy(css="#telephone")
    WebElement telephoneField;

    @FindBy(css="#comment")
    WebElement commentField;

    @FindBy(css=".action.submit.primary")
    WebElement submitBtn;

    @FindBy(css=".message-success.success.message")
    WebElement confirmationMessage;


    public void enterNameInContactUs(String name){
        type(nameField,name);
        log.info("type name success");
    }

    public void enterEmailAddress(String email){
        type(emailField,email);
        log.info("type Email address success");
    }

    public void enterTelephoneNumber(String phoneNumber){
        type(telephoneField,phoneNumber);
        log.info("type telephone success");
    }
    public void enterYourTextMessage(String textMessage){
        type(commentField,textMessage);
        log.info("type text in the box success");
    }
    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit success");
    }

    public String getConfirmationMessage(){
        String confirmationText=getElementText(confirmationMessage);
        log.info("Send Email success");
        return confirmationText;
    }

}
