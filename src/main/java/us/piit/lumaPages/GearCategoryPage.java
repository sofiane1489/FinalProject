package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class GearCategoryPage extends CommonAPI {

    Logger log= LogManager.getLogger(GearCategoryPage.class.getName());

    public GearCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[id='ui-id-26'] span")
    WebElement fitnessEquipmentSection;

    @FindBy(xpath = "//ol[@class='items']//a[normalize-space()='Watches']")
    WebElement watchesSection;

    @FindBy(css = ".sidebar.sidebar-main")
    WebElement gearSideBarMenu;

    @FindBy(css = "img[src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/gear/gear-main.jpg']")
    WebElement gearBackgroungImg;



    public void clickOnFitnessEquipment(){
        clickOn(fitnessEquipmentSection);
        log.info("click on Fitness Equipment success");
    }

    public void clickOnWatchesSection(){
        clickOn(watchesSection);
        log.info("click on Watches success");
    }

    public boolean checkGearSideBarMenuVisibility(){
        boolean barMenu=isVisible(gearSideBarMenu);
        log.info("Gear side bar menu visibility success");
        return barMenu;
    }

    public boolean checkGearBackgroungImgVisibility(){
        boolean imgVisibility=isVisible(gearBackgroungImg);
        log.info("Gear Backgroung Img Visibility success");
        return imgVisibility;
    }

}
