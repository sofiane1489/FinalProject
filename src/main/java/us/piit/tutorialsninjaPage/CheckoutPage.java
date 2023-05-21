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
    public boolean checkPresenceOfUserProcedureCheckout(){
        boolean userProcedureCheckoutIsDisplayed = isVisible(checkoutField);
        log.info("user procedure checkout is displayed");
        return userProcedureCheckoutIsDisplayed;
    }
}
