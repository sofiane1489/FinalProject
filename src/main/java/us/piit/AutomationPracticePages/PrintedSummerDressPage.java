package us.piit.AutomationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class PrintedSummerDressPage extends CommonAPI {
    Logger log = LogManager.getLogger(PrintedSummerDressPage.class.getName());

    public PrintedSummerDressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#group_1")
    WebElement sizeSelectionBox;
    @FindBy(css = "#group_1 > option:nth-child(2)")
    WebElement summerDressesSizeM;
    @FindBy(css = "#color_14")
    WebElement colorsChooses;
    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]")
    WebElement QuantityUpBtn;
    @FindBy(css = "#add_to_cart  button")
    WebElement addToCartBtn;


    public void clickOnSizeSelectioBox(){
        clickOn(sizeSelectionBox);
    }
    public void selectSizeM(){
        clickOn(summerDressesSizeM);
        log.info("select size success");
    }
    public void clickOnColorsChooses(){
        clickOn(colorsChooses);
        log.info("color selection success");
    }
    public void clickOnQuantityUpBtn(){
        clickOn(QuantityUpBtn);
        log.info("selectQuantity success");
    }
    public void clickOnAddToCartBtn(){
        clickOn(addToCartBtn);
        log.info("add to cart success");
    }
}

