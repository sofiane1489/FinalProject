package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class PoloBrandPage extends CommonAPI {
    Logger log = LogManager.getLogger(PoloBrandPage.class.getName());
    public  PoloBrandPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    WebElement PoloBrand;
    @FindBy(xpath = "//div[6]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    WebElement PoloBrandJeans;
    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement pageHeaderTitle;

    public void clickonPoloBrand(){
        clickOn(PoloBrand);
        log.info("click on polo brand success");
    }
    public void clickonviewproduct(){
        clickOn(PoloBrandJeans);
        log.info("click on view product success");
    }
    public String getPageHeaderTitle(){
        String Pageheader=getElementText(pageHeaderTitle);
        log.info("pageheadertitle visible success");
        return Pageheader;
    }
}
