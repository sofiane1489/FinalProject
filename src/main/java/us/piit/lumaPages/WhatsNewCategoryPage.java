package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WhatsNewCategoryPage extends CommonAPI {
    Logger log= LogManager.getLogger(WhatsNewCategoryPage.class.getName());

    public WhatsNewCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[2]//li[2]//a[1]")
    WebElement jacketsInMens;

    @FindBy(css = "img[src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/new/new-main.jpg']")
    WebElement whatsNewImg;

    @FindBy(css = ".categories-menu")
    WebElement whatsNewSideBarMenu;


    public void clickOnJacketsINNewInMens(){
        clickOn(jacketsInMens);
        log.info("click on jackets in NEW in men's success");
    }

    public boolean checkWhatsNewBackgroungImgVisivility(){
        boolean img=isVisible(whatsNewImg);
        log.info("backgroung image visibility success");
        return img;
    }
    public boolean checkWhatsNewSidebarMenuVisivility() {
        boolean sideMenu = isVisible(whatsNewSideBarMenu);
        log.info("what's New side bar menu visibility success");
        return sideMenu;

    }
}
