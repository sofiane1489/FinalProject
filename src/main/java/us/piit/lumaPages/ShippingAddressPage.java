package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ShippingAddressPage extends CommonAPI {
    Logger log= LogManager.getLogger(ShippingAddressPage.class.getName());

    public ShippingAddressPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "body div:nth-child(4) main:nth-child(2) div:nth-child(3) div:nth-child(1) div:nth-child(3) div:nth-child(5) ol:nth-child(1) li:nth-child(1) div:nth-child(2) form:nth-child(1) fieldset:nth-child(1) div:nth-child(1) div:nth-child(2) input:nth-child(1)")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameField;

    @FindBy(xpath = " //input[@name='lastname']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@name='company']")
    WebElement companyNameField;

    @FindBy(xpath = "//input[@name='street[0]']")
    WebElement StreetAddressField;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityField;

    @FindBy(css = "select[name='region_id']")
    WebElement selectStateField;

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postCodeField;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement telephoneField;

    @FindBy(xpath = "//input[@name='ko_unique_1']")
    WebElement shippingMethod;

    @FindBy(xpath = " //span[text()='Next']")
    WebElement nextBtn;

    @FindBy(xpath = "//button[@title='Place Order']")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    WebElement confirmatioMessage;


    public void enterEmailAddress(String email){
        type(emailField,email);
        log.info("type email success");
    }

    public void enterFirstName(String firstName){
        type(firstNameField,firstName);
        log.info("type first name success");
    }
    public void enterlastName(String lastName){
        type(lastNameField,lastName);
        log.info("type last name success");
    }

    public void entercompanyName(String companyName){
        type(companyNameField,companyName);
        log.info("type company name success");
    }

    public void enterStreetAddress(String Address){
        type(StreetAddressField,Address);
        log.info("type street address success");
    }

    public void enterCityName(String city){
        type(cityField,city);
        log.info("type city success");
    }

   public void selectState(String state){
        selectBy(selectStateField,state);
   }

   public void enterZipCode(String zipCode){
        type(postCodeField,zipCode);
        log.info("type postcode success");
   }

   public void enterPhoneNumber(String phoneNumber){
        type(telephoneField,phoneNumber);
        log.info("type phone number success");
   }

   public void selectShippingMethod(){
        clickOn(shippingMethod);
        log.info("selcect Shipping Methods success");
   }

   public void clickOnNextBtn(){
        clickOn(nextBtn);
        log.info("click on next success");
   }

   public void clickOnPlaceOrderBtn(){
        clickOn(placeOrderBtn);
        log.info("click on place order success");
   }

   public String getPurchaseConfirmationText(){
        String confirmation=getElementText(confirmatioMessage);
        log.info("purchase validation success");
        return confirmation;
   }

}
