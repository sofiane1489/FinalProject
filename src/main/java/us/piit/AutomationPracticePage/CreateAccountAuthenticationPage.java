package us.piit.AutomationPracticePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CreateAccountAuthenticationPage extends CommonAPI {
    Logger log = LogManager.getLogger(CreateAccountAuthenticationPage.class.getName());

    public CreateAccountAuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement mainHeader;
    @FindBy(css = "#email_create")
    WebElement createAccountField;

    @FindBy(css = "#id_gender1")
    WebElement genderselectionBth;
    @FindBy(css = "#customer_firstname")
    WebElement customerFirstNameField;
    @FindBy(css = "#customer_lastname")
    WebElement customerLastNameField;
    @FindBy(css = "#email")
    WebElement emailField;
    @FindBy(css = "#passwd")
    WebElement validPasswordField;
    @FindBy(css = "//*[@id=\"months\"]")
    WebElement customerMonth;
    @FindBy(xpath = "//*[@id=\"days\"]")
    WebElement customerDay;
    @FindBy(css = "#years")
    WebElement customerYear;
    @FindBy(css = "#submitAccount")
    WebElement registerBtn;
    @FindBy(css = "#create_account_error ol li")
    WebElement ErrorValidation;

    public String getErrorValidation(){
        String text = getElementText(ErrorValidation);
        log.info("error validation success");
        return text;
    }

    public String getHeaderText() {
        String text = getElementText(mainHeader);
        log.info("click on sign in success");
        return text;
    }


    public void selectGender(){
        clickOn(genderselectionBth);
        log.info("enter gender success");
    }
    public void enterFirstName(String firstname){
        type(customerFirstNameField, "firstname");
        log.info("enter first name success");
    }
    public void enterLasrName(String lastname){
        type(customerLastNameField, "lastname");
        log.info("enter last name success");
    }
    public void enterEmail(String email){
        type(emailField, "email");
        log.info("enter email success");
    }
    public void enterPassword(String password){
        type(validPasswordField, "password");
        log.info("enter password success");
    }
    public void selectDay(){
        clickOn(customerDay);
        log.info("select day success");
    }
    public void selectMonth(){
        clickOn(customerMonth);
        log.info("select month success");
    }
    public void selectYear(){
       clickOn(customerYear);
        log.info("select year success");
    }
    public void clickOnRegister(){
        clickOn(registerBtn);
        log.info("click on register button success");
    }

}
