package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MyOrdersPage extends CommonAPI {

    Logger log= LogManager.getLogger(MyOrdersPage.class.getName());

    public MyOrdersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(css=".toolbar-number")
    WebElement toolbarAmount;


    public String getToolbarAmountText(){
        String text=getElementText(toolbarAmount);
        log.info("get text success");
        return text;
    }

}
