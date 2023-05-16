package us.piit.AutomationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SummuryProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(SummuryProductPage.class.getName());

    public SummuryProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2")
    WebElement addConfirmationMessage;
    public boolean productSuccessfullyAdded(){
        boolean summuryOfItemAddedIsDisplayed = isVisible(addConfirmationMessage);
        log.info("message validation success");
        return summuryOfItemAddedIsDisplayed;
    }
}
