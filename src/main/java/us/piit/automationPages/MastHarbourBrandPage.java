package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MastHarbourBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(MastHarbourBrandPage.class.getName());

    public MastHarbourBrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/Mast & Harbour']")
    WebElement MastHarbourbrand;
    @FindBy(xpath = "//div[4]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement MastHarbourproduct;

    public void clickMastHarbourbrand() {

        clickOn(MastHarbourbrand);
        log.info("click on HM brand success");
    }

    public void clickViewProduct() {
        clickOn(MastHarbourproduct);
        log.info("click on view product success");

    }
}

