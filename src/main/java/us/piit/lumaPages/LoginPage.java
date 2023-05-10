package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log= LogManager.getLogger(LoginPage.class.getName());

    String actualTitle="//a[@aria-label='store logo']//img";
    String signinBtn="body div.page-wrapper header div.panel.wrapper div ul li.authorization-link a";
    String emailField="#email";
    String passwordField="#pass";
    String loginBtn="#send2";
    String messageInvalidEmail="#email-error";
    String messageMissingPassword="#pass-error";

    public boolean homaPageTitle(){
        boolean title= isVisible(actualTitle);
        log.info("landed on luma login page success");
        return title;
    }

    public void clickOnSigninBtn(){
        clickOn(signinBtn);
        log.info("click on sign in success");
    }
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
