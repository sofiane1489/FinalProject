package us.piit.AutomationPracticePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AutoLoginPage extends CommonAPI {
    Logger log= LogManager.getLogger(AutoLoginPage.class.getName());
    public AutoLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(css = "#email_create")
    WebElement createAccountField;
    @FindBy(css = "#email")
    WebElement usernameField;
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement SignInBtn;
    @FindBy(css = "#passwd")
    WebElement passwordField ;

    @FindBy(css = "#SubmitLogin")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorMessage;
    @FindBy(xpath = "#SubmitCreate")
    WebElement CreateAccountBtn;

    //reusable methods
    public void ClickOnSignInBtn(){
        clickOn(SignInBtn);
        log.info("click on sign in success");
    }

    public void clickOnCreateAccountBtn() {
        clickOn(CreateAccountBtn);
        log.info("click on create an account success");
    }
    public void enterUsername(String username){
        type(usernameField, "username");
        log.info("enter username success");
    }
    public void enterPassword(String password){
        type(passwordField, "password");
        log.info("enter password success");
    }
    public void clickOnLoginBtn(){
        clickOn(loginBtn);
        log.info("click on login button Success");
    }
    public String getErrorMessage(){
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }
    public boolean checkPresenceOfErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(errorMessage);
        log.info("validate error success");
        return errorMessageIsDisplayed;
    }
    public void emailAccountCreation(String email){
        type(createAccountField, email);
        log.info("enter email success");
    }


}
