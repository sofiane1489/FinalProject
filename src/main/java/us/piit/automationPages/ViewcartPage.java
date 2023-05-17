package us.piit.automationPages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ViewcartPage extends CommonAPI {
    Logger log= LogManager.getLogger(ViewcartPage.class.getName());
    public ViewcartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),' Cart')]")
    WebElement clickonShoopingCart;
    @FindBy(xpath = "//tbody/tr[@id='product-1']/td[6]/a[1]")
    WebElement clickondeleteItem;

    public void shoopingCart (){
        clickOn(clickonShoopingCart);
        log.info("click on shooping cart success");
    }
    public void deleteItem(){
        clickOn(clickondeleteItem);
        log.info("delete product success");
    }
}


