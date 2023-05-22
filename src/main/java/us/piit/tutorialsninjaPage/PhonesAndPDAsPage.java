package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class PhonesAndPDAsPage extends CommonAPI {
    Logger log= LogManager.getLogger(PhonesAndPDAsPage.class.getName());
    public PhonesAndPDAsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content div:nth-child(3) div:nth-child(1) div div.image a img")
    WebElement productImg;
    @FindBy(xpath = "//h2[text()='Phones & PDAs']")
    WebElement sectionMessageValidation;
    public void hoverOverAndClickOnProductImg(){
        clickOn(productImg);
        log.info("click on product image success");
    }
    public String getValidationMessage(){
        String text = getElementText(sectionMessageValidation);
        log.info("get message success");
        return text;
    }
}
