package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CheckoutPage extends CommonAPI {
    Logger log= LogManager.getLogger(CheckoutPage.class.getName());
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content")
    WebElement checkoutField;
    @FindBy(css = "#input-payment-firstname")
    WebElement firstNameField;
    @FindBy(css = "#input-payment-lastname")
    WebElement lastNameField;
    @FindBy(css = "#input-payment-address-1")
    WebElement addressField;
    @FindBy(css = "#input-payment-city")
    WebElement cityField;
    @FindBy(css = "#input-payment-country")
    WebElement countryField;
    @FindBy(css = "#input-payment-postcode")
    WebElement zipCodFiled;
    @FindBy(css = "#input-payment-zone")
    WebElement statField;
    @FindBy(css = "#input-payment-zone option:nth-child(5)")
    WebElement statChoose;
    @FindBy(css = "#input-payment-country option:nth-child(239)")
    WebElement countryChoose;
    @FindBy(css = "#button-payment-address")
    WebElement continueBtn;
    @FindBy(css = "#button-shipping-address")
    WebElement detailsBtn;
    @FindBy(css = "#button-shipping-method")
    WebElement methodBtn;
    @FindBy(css = "#button-payment-method")
    WebElement paymentBtn;
    @FindBy(css = "#collapse-payment-method div div.buttons div input[type=checkbox]:nth-child(2)")
    WebElement checkBox;
    @FindBy(css = "#button-confirm")
    WebElement confirmBtn;
    @FindBy(css = "#collapse-payment-address div form div:nth-child(3) label input[type=radio]")
    WebElement newAddressBtn;
    public boolean checkPresenceOfUserProcedureCheckout(){
        boolean userProcedureCheckoutIsDisplayed = isVisible(checkoutField);
        log.info("user procedure checkout is displayed");
        return userProcedureCheckoutIsDisplayed;
    }
    public void enterFirstName(String firstname){
        type(firstNameField, firstname);
        log.info("enter first name success");
    }
    public void enterLastName(String lastname){
        type(lastNameField, lastname);
        log.info("enter last name success");
    }
    public void enterAddress(String address){
        type(addressField, address);
        log.info("enter address success");
    }
    public void enterCity(String city){
        type(cityField, city);
        log.info("enter address success");
    }
    public void hoverOverAndClickOnCountryName(){
        clickOn(countryChoose);
        log.info("select country success");
    }
    public void enterZipCode(String zip){
        type(zipCodFiled, zip);
        log.info("enter address success");
    }
    public void clickOnCountryBox(){
        clickOn(countryField);
        log.info("click on country field success");
    }
    public void clickOnStatBox(){
        clickOn(statField);
        log.info("click on country field success");
    }
    public void hoverOverAndClickOnStatName(){
        clickOn(statChoose);
        log.info("select stat success");
    }
    public void clickOnAddressContinueBtn(){
        clickOn(continueBtn);
        log.info("click on continue button success");
    }
    public void clickOnShippingDetailsBtn(){
        clickOn(detailsBtn);
        log.info("click on continue button success");
    }
    public void clickOnShippingMethodBtn(){
        clickOn(methodBtn);
        log.info("click on continue button success");
    }
    public void clickOnShippingPaymentMethodBtn(){
        clickOn(paymentBtn);
        log.info("click on continue button success");
    }
    public void checkAgreementBoxBtn(){
        clickOn(checkBox);
        log.info("check agreement box success");
    }
    public void clickOnConfirmOrderBtn(){
        clickOn(confirmBtn);
        log.info("click on continue button success");
    }
    public void clickOnNewAddressBtn(){
        clickOn(newAddressBtn);
        log.info("click add new address button success");
    }

}
