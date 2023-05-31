package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class Product_detailesPage extends CommonAPI {
    Logger log = LogManager.getLogger(Product_detailesPage.class.getName());
    public Product_detailesPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[@type='button']")
    WebElement addtocart;
    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    WebElement clickonviewcart;

    public void clickonaddtocart(){

        clickOn(addtocart);
        log.info("click on add to cart success");
    }
    public void viewCart() {
        clickOn(clickonviewcart);
        log.info("click on view cart  success");
    }
}
