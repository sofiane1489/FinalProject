package us.piit.automationPracticePages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WomenDressesPage extends CommonAPI {
    Logger log = LogManager.getLogger(WomenDressesPage.class.getName());

    public WomenDressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //locators
    @FindBy(css = "#layered_category_11")
    WebElement dressesCategories;
    @FindBy(xpath = "//*[@id=center_column]/ul/li[1]/div/div/div[1]/div/a[1]")
    WebElement productImage;


    public void clickOnDressesCategories(){
        clickOn(dressesCategories);
        log.info("select categorie success");
    }
    public void clickOnProductImage(){
        clickOn(productImage);
        log.info("click on product success");
    }

}