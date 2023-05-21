package us.piit.tutorialsninjaPage;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class RegistrationPage extends CommonAPI {
    Logger log = LogManager.getLogger(RegistrationPage.class.getName());

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#input-firstname")
    WebElement firstNameField;
    @FindBy(css = "#input-lastname")
    WebElement lastNameFieldField;
    @FindBy(css = "#input-email")
    WebElement emailField;
    @FindBy(css = "#input-telephone")
    WebElement phoneNumberField;
    @FindBy(css = "#input-password")
    WebElement passwordField;
    @FindBy(css = "#input-confirm")
    WebElement confirmPasswordField;
    @FindBy(css = "##content form div div input[type=checkbox]:nth-child(2)")
    WebElement agreementCheckBox;
    @FindBy(css = "#content form div div input.btn.btn-primary")
    WebElement registrationField;
    @FindBy(css = "#account-register div.alert.alert-danger.alert-dismissible")
    WebElement createAccountField;

    //reusable methods
    public void enterFirstName(String firstname){
        type(firstNameField, firstname);
        log.info("enter first name success");
    }
    public void enterLastName(String lastname){
        type(lastNameFieldField, lastname);
        log.info("enter last name success");
    }
    public void enterEmail(String email) {
        type(emailField, email);
        log.info("enter email success");
    }
    public void enterPhoneNumber(String number){
        type(phoneNumberField, number);
        log.info("enter phone number success");

    }
    public void enterPassword(String password){
        type(passwordField, password);
        log.info("enter password success");
    }
    public void confirmPassword(String password){
        type(confirmPasswordField, password);
        log.info("re-enter password success");
    }
    public void clickOnAgreementCheckBox(){
        clickOn(agreementCheckBox);
        log.info("click on check box success");
    }
    public void clickOnContinueBtn(){
        clickOn(registrationField);
        log.info("click on continue success");
    }
    public boolean checkPresenceOfErrorMessage(){
        boolean errorMessageIsDisplayed = isVisible(createAccountField);
        log.info("error message is visible");
        return errorMessageIsDisplayed;
    }
}