package us.piit.automationPages;

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


    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    WebElement signupbutton;
    @FindBy(xpath ="//input[@name='name']")
    WebElement nameField;
    @FindBy(xpath= "//body/section[@id='form']/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]")
    WebElement emailField;
    @FindBy(xpath = "//button[contains(text(),'Signup')]")
    WebElement signupbtn;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstnameField;
    @FindBy(xpath ="//input[@id='last_name']" )
    WebElement lastnameField;
    @FindBy(css = "#company")
    WebElement companyField;
    @FindBy(css = "#address1")
    WebElement addressField;
    @FindBy(css = "#country")
    WebElement countryField;
    @FindBy(css = "#state")
    WebElement stateField;
    @FindBy(css ="#city" )
    WebElement cityField;
    @FindBy(css = "#zipcode")
    WebElement zipcodeField;
    @FindBy(css ="#mobile_number")
    WebElement mobilenumberField;
    @FindBy(xpath="//button[contains(text(),'Create Account')]")
    WebElement registerbtn;
    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    WebElement errorMessage;



        public void clickonsignupbutton () {
            clickOn(signupbutton);
            log.info("click on signup success");
        }
        public void enterName (String name) {
            type(nameField,name);
            log.info("enter name  success");
        }
        public void enterEmail (String email){
            type(emailField, email);
            log.info("enter email  success");
        }
        public void clickonsignupbtn () {
            clickOn(signupbtn);
            log.info("click first signup button success");
        }
        public void enterPassword (String password){
            type(passwordField, password);
            log.info("enter password success");
        }
        public void enterfirstName (String firstName){
            type(firstnameField, firstName);
            log.info("enter firstname success");
        }
        public void enterLastName (String lastName){
            type(lastnameField, lastName);
            log.info("enter lastname success");
        }
        public void entercompany (String company){
            type(companyField, company);
            log.info("enter company success");
        }
        public void enteraddress (String address){
            type(addressField, address);

        }
        public void entercountry (String country){
            type(countryField, country);
            log.info("enter country success");
        }
        public void enterState (String state){
            type(stateField, state);
            log.info("enter state success");
        }
        public void entercity (String city){
            type(cityField, city);
            log.info("enter city success");
        }
        public void enterzipcode (String zipcode){
            type(zipcodeField, zipcode);
            log.info("enter zipcode success");
        }
        public void entermobilenumber (String mobilenumber){
            type(mobilenumberField, mobilenumber);
            log.info("enter phone number success");
        }
        public void clickonregisterbtn () {
            clickOn(registerbtn);
            log.info("click on create account success");
        }
    public String getErrorMessage(){
        String errorText=getElementText(errorMessage);
        log.info("error message validation success");
        return errorText;

        }


    }
