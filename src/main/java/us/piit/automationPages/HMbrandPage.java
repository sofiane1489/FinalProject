package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HMbrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(CheckOutPage.class.getName());

    public HMbrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    WebElement HMbrand;
    @FindBy(xpath = "//div[4]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement HMTishirt;

    public void clickHMbrand() {

        clickOn(HMbrand);
        log.info("click on HM brand success");
    }

    public void clickViewProduct() {
        clickOn(HMTishirt);
        log.info("click on view product success");

    }
}