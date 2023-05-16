package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CheckoutPage extends CommonAPI {
    Logger log= LogManager.getLogger(ViewcartPage.class.getName());
    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement proceedtocheckout;

    public void clickCheckOut(){
        clickOn(proceedtocheckout);
        log.info("checkout proceed success");
    }
}

