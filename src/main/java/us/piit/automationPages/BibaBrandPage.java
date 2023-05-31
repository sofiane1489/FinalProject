package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class BibaBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(BabyHugBrandPage.class.getName());

    public BibaBrandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/brand_products/Biba']")
    WebElement BibaBrand;
    @FindBy(xpath = "//div[4]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement BibaDress;

    public void clickBibaBrand() {

        clickOn(BibaBrand);
        log.info("click on Biba brand success");
    }

    public void clickViewProduct() {
        clickOn(BibaDress);
        log.info("click on view product success");

    }
}





