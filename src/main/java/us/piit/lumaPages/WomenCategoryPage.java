package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class WomenCategoryPage extends CommonAPI {

    Logger log= LogManager.getLogger(WomenCategoryPage.class.getName());

    public WomenCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".sidebar.sidebar-main")
    WebElement WomenSideBarMenu;

    @FindBy(css="img[src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/womens/womens-main.jpg']")
    WebElement WomenBackgroungImg;


    public boolean checkWomenSideBarMenuVisibility(){
        boolean barMenu=isVisible(WomenSideBarMenu);
        log.info("women side bar menu visibility success");
        return barMenu;
    }

    public boolean checkWomenBackgroungImgVisibility(){
        boolean imgVisibility=isVisible(WomenBackgroungImg);
        log.info("Women Backgroung Img Visibility success");
        return imgVisibility;
    }


}
