package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AccountInformationPage extends CommonAPI {
    Logger log = LogManager.getLogger(AccountInformationPage.class.getName());

    public AccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-firstname")
    WebElement firstNameField;
    @FindBy(css = "#input-lastname")
    WebElement lastNameField;
    @FindBy(css = "#input-email")
    WebElement emailField;
    @FindBy(css = "#input-telephone")
    WebElement phoneNumberField;
    @FindBy(css = "#content form div div.pull-right input")
    WebElement submitBtn;
    @FindBy(css = "#content form div div.pull-right input")
    WebElement continueBtn;
    public void enterNewFirstName(String newfirstname) {
        type(firstNameField, newfirstname);
        log.info("edit first name success");
    }

    public void enterNewLastName(String newlastname) {
        type(lastNameField, newlastname);
        log.info("edit first name success");
    }
    public void enterNewEmail(String newemail) {
        type(emailField, newemail);
        log.info("edit first name success");
    }
    public void enterNewPhoneNumber(String newnumber) {
        type(phoneNumberField, newnumber);
        log.info("edit first name success");
    }
    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit button success");
    }

}
