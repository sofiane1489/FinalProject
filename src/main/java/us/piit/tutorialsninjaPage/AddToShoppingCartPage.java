package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class AddToShoppingCartPage extends CommonAPI {
    Logger log= LogManager.getLogger(AddToShoppingCartPage.class.getName());
    public AddToShoppingCartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#button-cart")
    WebElement addToCartBtn;
    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("click on add to cart button success");
    }
}
