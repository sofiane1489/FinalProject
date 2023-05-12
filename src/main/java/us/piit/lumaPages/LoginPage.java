package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log= LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#email")
    WebElement emailField;

    @FindBy(css="#pass")
    WebElement passwordField;

    @FindBy(css="#send2")
    WebElement loginBtn;

    @FindBy(css="#email-error")
    WebElement messageInvalidEmail;

    @FindBy(css="#pass-error")
    WebElement messageMissingPassword;

    public void enterEmail(String email){
        type(emailField,email);
        log.info("email enter success");
    }
    public void enterPassword(String password){
        type(passwordField,password);
        log.info("password enter success");
    }
    public void clickOnLoginBtn(){
       clickOn(loginBtn);
        log.info("click on sign in success");
    }
    public String getErrorMessageInvalidEmail(){
        String error=getElementText(messageInvalidEmail);
        log.info("validate invalid email error success");
        return error;
    }
    public String getErrorMessageMissinPass(){
        String error=getElementText(messageMissingPassword);
        log.info("validate missing password error success");
        return error;
    }


}
