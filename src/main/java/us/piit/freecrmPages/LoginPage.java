package us.piit.freecrmPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogManager().getLogger(LoginPage.class.getName());

    public void LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


        @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
        WebElement emailField;
        @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
        WebElement passwordField;
        @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[4]")
        WebElement loginBtn;
        @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]/div")
        WebElement messageWrongEmail;
        @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
        WebElement loginPageHeader;
        public void clickonloginbutton() {
            clickonloginbutton();
            log.info("click on login button Success");
            }
    public void enterEmail(String email){
        type(emailField,email);
        log.info("enter email success");
    }

    public void enterPassword(String  password){
            type(passwordField,password);
                log.info("enter password success");
        }

            public void clickonLoginBtn() {
                clickOn(String.valueOf(loginBtn));
                log.info("click on login btn Success");
            }

            public String getErrorMessageInvalidEmail() {
                String error = getElementText(messageWrongEmail);
                log.info("validate invalid email error success");
                return error;
            }


            public boolean checkPresenceOfLoginPageHeader() {
                boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
                log.info("login page header presence " + loginPageHeaderIsDisplayed);
                return loginPageHeaderIsDisplayed;
            }

            public String getLoginPageHeaderText() {
                String loginPageHeaderText = getElementText(loginPageHeader);
                log.info("login page header text is " + loginPageHeaderText);
                return loginPageHeaderText;

            }





//
//            public void enterValidPassword(String Object userPassword;
//            Object userPassword1 = userPassword;) {
//            }
//
//            public void clickOnLoginBtn() {
//            }
//
//            public String getErrorMessage() {
//                return null;
//            }
//        }

    private void type(String valueOf, String password1) {
    }

    private void clickOn(String valueOf) {

    }

    public void clickOnLoginBtn() {
    }

    public boolean checkLoginPage() {


        return false;
    }

    public String LoginPageHeader() {
        return null;
    }

    public void enterValidPassword(String userPassword) {
    }

    public String getErrorMessage() {
        return null;
    }
}









