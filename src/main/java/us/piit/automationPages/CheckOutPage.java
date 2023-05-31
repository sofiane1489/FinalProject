package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CheckOutPage extends CommonAPI {
    Logger log= LogManager.getLogger(CheckOutPage.class.getName());
    public CheckOutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement proceedtocheckout;
    @FindBy(xpath = "//ul[@id='address_delivery']")
    WebElement deliveryaddress;

    public void clickCheckOut(){
        clickOn(proceedtocheckout);
        log.info("checkout proceed success");
    }
    public boolean deliveryaddressvisibility(){
        boolean address=isVisible(deliveryaddress);
        log.info("delivery address is visible success");
        return  address;
    }
}