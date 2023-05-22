package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class OrderConfirmationPage extends CommonAPI {
    Logger log= LogManager.getLogger(OrderConfirmationPage.class.getName());
    public OrderConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    WebElement confirmationMessage;
    public String getOrderProceedingConfirmationMessage(){
        String text = getElementText(confirmationMessage);
        log.info("get message Success");
        return text;
    }
}
