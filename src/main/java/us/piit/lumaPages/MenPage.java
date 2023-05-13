package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class MenPage extends CommonAPI {
    Logger log= LogManager.getLogger(MenPage.class.getName());

    public MenPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#narrow-by-list2 > dd > ol > li:nth-child(1) > a")
    WebElement tops48;

    public void clickOnTops48InMenCategory(){
        clickOn(tops48);
        log.info("click on Top48 success");
    }

}
