package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MyAccountPage extends CommonAPI {

    Logger log= LogManager.getLogger(MyAccountPage.class.getName());

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/customer/account/edit/']//span[contains(text(),'Edit')]")
    WebElement editLink;


    @FindBy(css = "div[class='box box-billing-address'] div[class='box-actions'] span")
    WebElement editAddressLink;

    @FindBy(css = "#street_1")
    WebElement streetAddressField;

    @FindBy(css = "#city")
    WebElement cityField;

    @FindBy(css = " #region_id")
    WebElement stateField;


    @FindBy(css = "#zip")
    WebElement zipcodeField;

    @FindBy(css = "button[title='Save Address'] span")
    WebElement saveAddressBtn;


    @FindBy(css = "#telephone")
    WebElement telephoneField;


    @FindBy(css = ".message-success.success.message")
    WebElement savedConfirmationText;

    public void clickOnEdit(){
        clickOn(editLink);
        log.info("click on edit success");
    }

    public String getSaveEditTextConfirmation(){
        String textConfirmation=getElementText(savedConfirmationText);
        log.info("last name edit success");
        return textConfirmation;
    }

    public void clickOnEditAddressLink(){
        clickOn(editAddressLink);
        log.info("click on edit address Link success");
    }

    public void enterNewAddress(String address){
        type(streetAddressField,address);
        log.info("type address success");
    }
    public void enterNewcity(String city){
        type(cityField,city);
        log.info("type city success");
    }

    public void enterNewZipcode(String zipcode){
        type(zipcodeField,zipcode);
        log.info("type zipcode success");
    }
    public void enterTelephoneNumber(String telephone){
        type(telephoneField,telephone);
    }

    public void clickOnSaveAddressBtn(){
        clickOn(saveAddressBtn);
        log.info("click on save address Btn success");
    }
   public void selectState(String state){
        selectBy(stateField,state);
   }
//    public String getSaveEditedAddressConfirmationText(){
//        String textConfirmation=getElementText(savedConfirmationText);
//        log.info("address edit success");
//        return textConfirmation;
//    }


}
