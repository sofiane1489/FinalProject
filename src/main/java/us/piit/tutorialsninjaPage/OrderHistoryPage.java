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
    @FindBy(css = "#content table:nth-child(2) thead tr td")
    WebElement orderDetails;
    public void clickOnViewOrderBtn(){
        clickOn(viewBtn);
        log.info("click on view order button success");
    }
    public String getOrderDetailsText(){
        String text = getElementText(orderDetails);
        log.info("get text success");
        return text;
    }
}
