package us.piit.automationPracticePages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class BlogPage extends CommonAPI {
    Logger log= LogManager.getLogger(BlogPage.class.getName());
    public BlogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
