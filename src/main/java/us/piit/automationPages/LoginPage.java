

package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    WebElement loginbutton;
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;
    @FindBy(xpath = "//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")
    WebElement passwordField;
    @FindBy(xpath ="//button[contains(text(),'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement messageInvalidEmail;
    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement messageInvalidPassword;
    @FindBy(xpath = "//h2[contains(text(),'Login to your account')]")
    WebElement loginPageHeader;

    public void clickonloginbutton() {
        clickOn(loginbutton);
        log.info("click on login button Success");

    }

    public void enterEmail(String email) {
        type(emailField, email);
        log.info("enter email success");
    }

    public void enterPassword(String password) {
        type(passwordField, password);
        log.info("enter password success");
    }

    public void clickonLoginBtn() {
        clickOn(loginBtn);
        log.info("click on login btn Success");
    }

    public String getErrorMessageInvalidEmail() {
        String error = getElementText(messageInvalidEmail);
        log.info("validate invalid email error success");
        return error;
    }

    public String getErrorMessageInvalidPassword() {
        String error = getElementText(messageInvalidPassword);
        log.info("validate missing password error success");
        return error;
    }
    public boolean checkPresenceOfLoginPageHeader(){
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence "+loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }
    public String getLoginPageHeaderText(){
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is "+loginPageHeaderText);
        return loginPageHeaderText;

    }
}




