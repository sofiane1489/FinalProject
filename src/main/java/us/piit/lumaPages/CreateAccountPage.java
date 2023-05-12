package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CreateAccountPage extends CommonAPI{

    Logger log= LogManager.getLogger(CreateAccountPage.class.getName());

    public CreateAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

     @FindBy(css="#firstname")
    WebElement firstNameField;

    @FindBy(css="#lastname")
    WebElement lastNameField;

    @FindBy(css="#email_address")
    WebElement emailField;

    @FindBy(css="#password")
    WebElement passwordField;

    @FindBy(css="#password-confirmation")
    WebElement passwordConfirmationField;

    @FindBy(xpath="//form[@class='form create account form-create-account']/div/div/button/span")
    WebElement createAccountBtn;

    @FindBy(css=".message-error.error.message")
    WebElement errorMessage;


    public void enterFirstName(String firstName){
        type(firstNameField,firstName);
        log.info("enter first Name  success");
    }
    public void enterLastName(String lastName){
        type(lastNameField,lastName);
        log.info("enter last Name success");
    }
    public void enterEmail(String email){
        type(emailField,email);
        log.info("enter email success");
    }
    public void enterPassword(String password){
        type(passwordField,password);
        log.info("enter password success");
    }
    public void enterConfirmationPassword(String password){
        type(passwordConfirmationField,password);
        log.info("reenter password success");
    }

    public void clickOnCreateAccountBtn(){
        clickOn(createAccountBtn);
        log.info("click on create account success");
    }

    public String getErrorMessage(){
        String errorText=getElementText(errorMessage);
        log.info("error message validation success");
        return errorText;
    }
}
