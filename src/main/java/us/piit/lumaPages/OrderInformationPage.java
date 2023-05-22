package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class OrderInformationPage extends CommonAPI {

    Logger log= LogManager.getLogger(OrderInformationPage.class.getName());

    public OrderInformationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css=".base")
    WebElement trackingOrderID;

    @FindBy(css=".order-status")
    WebElement orderStatus;


    public String getOrderIDText(){
        String text=getElementText(trackingOrderID);
        log.info("order ID displayed success");
        return text;
    }
    public String getOrderStatus(){
        String text=getElementText(orderStatus);
        log.info("order status displayed success");
        return text;
    }


}
