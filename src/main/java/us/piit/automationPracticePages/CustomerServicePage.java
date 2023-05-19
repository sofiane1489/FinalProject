package us.piit.automationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CustomerServicePage extends CommonAPI {
    Logger log= LogManager.getLogger(CustomerServicePage.class.getName());
    public CustomerServicePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#id_contact")
    WebElement contactChoose;
    @FindBy(css = "#id_contact option:nth-child(2)")
    WebElement customerChoose;
    @FindBy(css = "#email")
    WebElement emailAddressBox;
    @FindBy(css = "#id_order")
    WebElement orderReferenceBox;
    @FindBy(css = "#center_column form fieldset div.clearfix div.col-xs-12.col-md-3 div:nth-child(6) div select option:nth-child(2)")
    WebElement orderReference;
    @FindBy(css = "#uniform-1363_order_products")
    WebElement productBox;
    @FindBy(css = "#fileUpload")
    WebElement attachFileField;
    @FindBy(css = "#message")
    WebElement messageField;
    @FindBy(css = "#submitMessage")
    WebElement submitBtn;
    @FindBy(css = "#\\31 363_order_products > option:nth-child(2)")
    WebElement orderSummary;
    public void chooseContactOption(int choose){
        selectByIn(customerChoose, choose);
        log.info("choose Option success");
    }
    public void clickOnContactOptionBox(){
        clickOn(contactChoose);
        log.info("click on contact choose success ");
    }
    public void enterEmailAddress(String email){
        type(emailAddressBox, email);
        log.info("enter email address success");
    }
    public void clickOnOrderReferenceBox(){
        clickOn(orderReferenceBox);
        log.info("click on order reference success");
    }
    public void selectOrderReference(int reference){
        selectByIn(orderReference, reference);
        log.info("order reference selection success");
    }
    public void clickOnAttachFieldBox(){
        clickOn(attachFileField);
        log.info("click on attach file box success");
    }
    public void clickOnMessageField(String message){
        type(messageField, message);
        log.info("add comment message success");
    }
    public void clickOnSubmitBtn(){
        clickOn(submitBtn);
        log.info("click on submit success");
    }
    public void clickOnselectProduct(){
        clickOn(productBox);
        log.info("click on product box success");
    }
    public void selectProductSummary(int summary){
        selectByIn(orderSummary, summary);
        log.info("click on order summary success");
    }
}

