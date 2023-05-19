package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WomensProductPage  extends CommonAPI {
    Logger log = LogManager.getLogger(WomensProductPage.class.getName());

    public WomensProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    WebElement womensTops;
    @FindBy(xpath = "//h2[contains(text(),'Women - Tops Products')]")
    WebElement womenTopsTitle;

    public void clickonWomenTops() {
        clickOn(womensTops);
        log.info("click on women sub category success");
    }

    public boolean getwomentopsTitle() {
        boolean title=isVisible(womenTopsTitle);
        log.info("women tops title is visible success");
        return  title;

    }


}