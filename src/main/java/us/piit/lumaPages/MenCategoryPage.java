package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MenCategoryPage extends CommonAPI {
    Logger log= LogManager.getLogger(MenCategoryPage.class.getName());

    public MenCategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#narrow-by-list2 dd ol li:nth-child(1) a")
    WebElement tops48;

    @FindBy(css=".sidebar.sidebar-main")
    WebElement menSideBarMenu;

    @FindBy(css="img[src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/mens/mens-main.jpg']")
    WebElement menBackgroungImg;


    @FindBy(css="div[class='block block-wishlist'] strong[role='heading']")
    WebElement wishList;


    @FindBy(xpath="//li[1]//div[1]//div[1]//div[2]//div[2]//a[1]")
    WebElement crossIcon;


    @FindBy(css = ".message-success.success.message")
    WebElement removeConfirmationText;

    public void clickOnTops48InMenCategory(){
        clickOn(tops48);
        log.info("click on Top48 success");
    }

    public boolean checkMenSideBarMenuVisibility(){
        boolean barMenu=isVisible(menSideBarMenu);
        log.info("Men side bar menu visibility success");
        return barMenu;
    }

    public boolean checkMenBackgroungImgVisibility(){
        boolean imgVisibility=isVisible(menBackgroungImg);
        log.info("Men Backgroung Img Visibility success");
        return imgVisibility;
    }

    public void scrollToElement(WebDriver driver){
        scrollToElement(driver,wishList);
        log.info("scrolled to element success");
    }

    public void clickOnCrossIconToRemoveProduct(WebDriver driver){
        clickWithJavascript(driver,crossIcon);
        log.info("click on remove success");
    }

    public String getRemoveFromWishListConfirmationText(){
        String text=getElementText(removeConfirmationText);
        log.info("product removed success");
        return text;
    }
}
