package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ForgotPasswordPage extends CommonAPI {
    Logger log= LogManager.getLogger(ForgotPasswordPage.class.getName());
    public ForgotPasswordPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Forgot Your Password?']")
    WebElement messageValidation;
    @FindBy(css = "#input-email")
    WebElement emailField;
    @FindBy(css = "#content form div div.pull-right input")
    WebElement continueBtn;
    public String getTextMessage(){
        String text = getElementText(messageValidation);
        log.info("get message success");
        return text;
    }
    public void enterEmail(String email){
        type(emailField, email);
        log.info("enter email success");
    }
    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        log.info("click on continue button success");
    }
}
