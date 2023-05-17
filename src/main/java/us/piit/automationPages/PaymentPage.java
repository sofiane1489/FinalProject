
package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class PaymentPage extends CommonAPI {
    Logger log= LogManager.getLogger(PaymentPage.class.getName());
    public PaymentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement  placeOrder;
    @FindBy(xpath = "//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")
    WebElement nameField;
    @FindBy(css =".form-control.card-number")
    WebElement cardnumberField;
    @FindBy(css = ".form-control.card-cvc")
    WebElement cvcNumberField;
    @FindBy(css = ".form-control.card-expiry-month")
    WebElement expireMonthField;
    @FindBy(css = ".form-control.card-expiry-year")
    WebElement expireYearField;
    @FindBy(css = "#submit")
    WebElement clickonpaymentconfirme;

    public void clickonPlaceOrder(){
        clickOn(placeOrder);
        log.info("place order success");

    }
    public void enterName(String name){
        type(nameField,name);
        log.info("type name success");
    }
    public void enterCardNumber(String cardnumber){
        type(cardnumberField,cardnumber);
        log.info("type card number success");
    }
    public void entercvcNumber(String cvcnumber){
        type(cvcNumberField,cvcnumber);
        log.info("cvs enter success");
    }
    public void enterexpireMonth(String expiremonthnum){
        type(expireMonthField,expiremonthnum);
        log.info("expiry-month enter success");
    }
    public void enterexpireYear(String expireyearnum){
        type(expireYearField,expireyearnum);
        log.info("expiry-year enter success");
    }
    public void clickonpaymentConfirm(){
        clickOn(clickonpaymentconfirme);
        log.info("pay and confirm order success");
    }

}

