package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log = LogManager.getLogger(HomePage.class.getName());
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css ="div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)")
    WebElement mainHeader;
    public String getHeaderText() {
        log.info("user logged in success");
        String text=getElementText(mainHeader);
        return text;


    }
}