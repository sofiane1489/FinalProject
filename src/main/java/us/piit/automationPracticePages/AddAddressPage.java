package us.piit.automationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AddAddressPage extends CommonAPI {
    Logger log = LogManager.getLogger(AddAddressPage.class.getName());

    public AddAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //    @FindBy(css = "#center_column div div ul li:nth-child(1) a")
//    WebElement addAddressBtn;
    @FindBy(css = "#firstname")
    WebElement firstnameFiled;
    @FindBy(css = "#lastname")
    WebElement lastnameField;
    @FindBy(css = "#address1")
    WebElement addressField;
    @FindBy(css = "#city")
    WebElement citynameField;
    @FindBy(css = "#id_state")
    WebElement statenameField;
    @FindBy(css = "#days option:nth-child(21)")
    WebElement stateName;
    @FindBy(css = "#postcode")
    WebElement zipcodeField;
    @FindBy(css = "#phone_mobile")
    WebElement phoneNumberField;
    @FindBy(css = "#alias")
    WebElement assignaddressField;
    @FindBy(css = "#submitAddress")
    WebElement submitBtn;
    //    public void clickOnAddAddressBtn(){
//        clickOn(addAddressBtn);
//        log.info("click on address button success");
//    }
    public void enterFirstname(String firstname) {
        type(firstnameFiled, firstname);
        log.info("enter firstname success");
    }

    public void enterLastname(String lastname) {
        type(lastnameField, lastname);
        log.info("enter lastname success");
    }
    public void enterAddress(String address) {
        type(addressField, address);
        log.info("enter address success");
    }
    public void enterCityName(String cityname) {
        type(citynameField, cityname);
        log.info("enter city success");
    }
    public void clickOnStateBox(){
        clickOn(statenameField);
        log.info("click on state box success");
    }
    public void selectStateName(int name){
        selectByIn(stateName, name);
        log.info("enter state success");
    }
    public void enterZipCode(String code) {
        type(zipcodeField, code);
        log.info("enter zip code success");
    }
    public void enterPhoneNumber(String number) {
        type(phoneNumberField, number);
        log.info("enter phone number success");
    }
    public void enterAddressReference(String reference) {
        type(assignaddressField, reference);
        log.info("enter address reference success");
    }
    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit button success");
    }
}
