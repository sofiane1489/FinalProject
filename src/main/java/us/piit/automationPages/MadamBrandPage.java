package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MadamBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(MadamBrandPage.class.getName());

    public MadamBrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/Madame']")
    WebElement MADAMbrandbutton;
    @FindBy(xpath = "//div[6]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement MadamBrandDress;

    public void clickMADAMbrand() {

        clickOn(MADAMbrandbutton);
        log.info("click on MADAM brand success");
    }

    public void clickViewProduct() {
        clickOn(MadamBrandDress);
        log.info("click on view product success");

    }
}

