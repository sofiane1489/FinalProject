package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class KookieKidsBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(KookieKidsBrandPage.class.getName());

    public KookieKidsBrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/Kookie Kids']")
    WebElement KookieKidsbrandbutton;
    @FindBy(xpath = "//div[4]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement KookieKidsBrandDress;

    public void clickKookieKidsbrand() {

        clickOn(KookieKidsbrandbutton);
        log.info("click on Kookie Kids brand success");
    }

    public void clickViewProduct() {
        clickOn(KookieKidsBrandDress);
        log.info("click on view product success");

    }
}



