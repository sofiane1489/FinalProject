package us.piit.tutorialsninjaPage;


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

    //locators
    @FindBy(xpath = "##content div div:nth-child(1) div a")
    WebElement newCustomerField;
    @FindBy(css = "#input-email")
    WebElement emailField;
    @FindBy(css = "#input-password")
    WebElement passwordField;
    @FindBy(css = "#content div div:nth-child(2) div form input.btn.btn-primary")
    WebElement loginBtn;
    @FindBy(css = "#account-login div.alert.alert-danger.alert-dismissible")
    WebElement errorMessage;
    @FindBy(css = "#content div div:nth-child(2) div form div:nth-child(2) a")
    WebElement forgottenPassword;
    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]/text()")
    WebElement confirmationMessage;

    public void clickOnContinueBtn() {
        clickOn(newCustomerField);
        log.info("click on continue button success");
    }

    public void enterValidEmail(String email) {
        type(emailField, email);
        log.info("center valid email success");
    }
    public void enterValidPassword(String password) {
        type(passwordField, password);
        log.info("center valid password success");
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on login button success");
    }
    public boolean checkPresenceOfErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(errorMessage);
        log.info("get error message success");
        return  errorMessageIsDisplayed;
    }
    public void clickOnForgottenPasswordLink(){
        clickOn(forgottenPassword);
        log.info("click on forgotten password link success");
    }
    public String getTextMessage(){
        String text = getElementText(confirmationMessage);
        log.info("get text success");
        return text;
    }
}