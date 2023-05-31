package us.piit.automationPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TestCasespage extends CommonAPI {
    Logger log= LogManager.getLogger(TestCasespage.class.getName());

    public TestCasespage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    WebElement testCase;

    public boolean gettitle5(){
        boolean title5=isVisible(testCase);
        log.info("test case title visible success");
        return title5;

    }

    
}
