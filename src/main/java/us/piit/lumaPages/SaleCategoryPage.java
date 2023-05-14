package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SaleCategoryPage extends CommonAPI {

    Logger log= LogManager.getLogger(SaleCategoryPage.class.getName());

    public SaleCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".sidebar.sidebar-main")
    WebElement saleSideBarMenu;

    @FindBy(css=" img[src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/sale/sale-main.jpg']")
    WebElement saleBackgroungImg;

    public boolean checkSaleSideBarMenuVisibility(){
        boolean barMenu=isVisible(saleSideBarMenu);
        log.info("Sale side bar menu visibility success");
        return barMenu;
    }

    public boolean checkSaleBackgroungImgVisibility(){
        boolean imgVisibility=isVisible(saleBackgroungImg);
        log.info("Sale Backgroung Img Visibility success");
        return imgVisibility;
    }


}
