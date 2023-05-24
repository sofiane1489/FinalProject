package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class CamerasTypePage extends CommonAPI {
    Logger log = LogManager.getLogger(CamerasTypePage.class.getName());

    public CamerasTypePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content div div.col-sm-4 div.btn-group button:nth-child(1)")
    WebElement wishListBtn;
    public void clickOnWishListBtn(){
        clickOn(wishListBtn);
        log.info("click on wish list button success");
    }
}
