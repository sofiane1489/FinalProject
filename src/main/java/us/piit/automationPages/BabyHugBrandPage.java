package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class BabyHugBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(BabyHugBrandPage.class.getName());

    public BabyHugBrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/Babyhug']")
    WebElement BabyHugBrand;
    @FindBy(xpath = "//div[3]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement BabyHugDress;

    public void clickBabyhugBrand() {

        clickOn(BabyHugBrand);
        log.info("click on BabyHug brand success");
    }

    public void clickViewProduct() {
        clickOn(BabyHugDress);
        log.info("click on view product success");

    }
}



