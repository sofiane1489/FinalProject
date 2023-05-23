package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class OrderHistoryPage extends CommonAPI {
    Logger log= LogManager.getLogger(OrderHistoryPage.class.getName());
    public OrderHistoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content div.table-responsive table tbody tr:nth-child(1) td:nth-child(7) a")
    WebElement viewBtn;
    @FindBy(css = "#content div.table-responsive table tbody tr td:nth-child(6)")
    WebElement returnBtn;
    public void clickOnViewOrderBtn(){
        clickOn(viewBtn);
        log.info("click on view order button success");
    }
    public void scrollToReturnBtn(WebDriver driver){
        scrollToElement(driver,returnBtn);
        log.info("scroll to return button success");
    }
}
