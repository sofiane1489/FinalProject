package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SearchPage extends CommonAPI {

    Logger log = LogManager.getLogger(SearchPage.class.getName());

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")
    WebElement searchBarField;
    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[1]/i")
    WebElement clickOnSearch;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
    WebElement resultSucces;

    public void search() {
        type(searchBarField, "elian oularbi");
        log.info("enter text success");
    }

    public void searchIcon() {
        clickOn(clickOnSearch);
        log.info("click search button success");
    }

    public boolean result() {
        boolean text = isVisible(resultSucces);
        log.info("result displayed secces");
        return text;
    }
}




