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
    @FindBy(css = "#content div div:nth-child(2) div form input")
    WebElement loginBtn;
    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]/text()")
    WebElement errorMessage;

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
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message success");
        return  text;
    }

}