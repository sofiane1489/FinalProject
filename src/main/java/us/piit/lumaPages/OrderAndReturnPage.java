package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class OrderAndReturnPage extends CommonAPI {
    Logger log= LogManager.getLogger(OrderAndReturnPage.class.getName());

    public OrderAndReturnPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "#oar-order-id")
    WebElement orderIDField;


    @FindBy(css = "#oar-billing-lastname")
    WebElement billingLastNameField;

    @FindBy(css = "#oar_email")
    WebElement emailField;

    @FindBy(css = "button[title='Continue']")
    WebElement continueBtn;

    public void enterOrderID(String orderID){
        type(orderIDField,orderID);
        log.info("enter order ID success");
    }

    public void enterBillingLastName(String lastName){
        type(billingLastNameField,lastName);
        log.info("enter last name success");
    }
    public void enterEmail(String email){
        type(emailField,email);
        log.info("enter email success");
    }

    public void clickOnContinueBtn(){
        clickOn(continueBtn);
        log.info("click on continue success");
    }

}
