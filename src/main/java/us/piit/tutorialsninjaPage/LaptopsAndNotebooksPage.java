package us.piit.tutorialsninjaPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class LaptopsAndNotebooksPage extends CommonAPI {
    Logger log= LogManager.getLogger(LaptopsAndNotebooksPage.class.getName());
    public LaptopsAndNotebooksPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#content > h2")
    WebElement sectionPageName;
    @FindBy(css = "#list-view")
    WebElement listViewBtn;
    @FindBy(css = "#content div:nth-child(7) div:nth-child(1)")
    WebElement productsList;
    @FindBy(css = "#grid-view")
    WebElement gridViewBtn;
    @FindBy(css = "#content div:nth-child(7) div:nth-child(2)")
    WebElement productGrid;
    @FindBy(css = "#input-sort")
    WebElement sortByField;
    @FindBy(css = "#input-sort option:nth-child(5)")
    WebElement sortByOption;
    @FindBy(css = "#content div:nth-child(6) div.col-md-4.col-xs-6 div label")
    WebElement selectedSort;
    @FindBy(css = "#content div:nth-child(7) div:nth-child(1) div div.image a img")
    WebElement productImg;
    public String getSectionPageName(){
        String text = getElementText(sectionPageName);
        log.info("get page name success");
        return text;
    }
    public void clickOnListViewBtn(){
        clickOn(listViewBtn);
        log.info("click on list view button success");
    }
    public boolean areProductsDisplayedAsList(){
        boolean productsListIsDisplayed = isVisible(productsList);
        log.info("products displayed as list success");
        return productsListIsDisplayed;
    }
    public void clickOnGridViewBtn(){
        clickOn(gridViewBtn);
        log.info("click on grid view button success");
    }
    public boolean areProductsDisplayedAsGrid(){
        boolean productsListIsDisplayed = isVisible(productGrid);
        log.info("products displayed as grid success");
        return productsListIsDisplayed;
    }

    public boolean areProductsSortedAsSelectedSortBy(){
        boolean selectedSortIsDisplayed = isVisible(selectedSort);
        log.info("products are displayed as sorted success");
        return selectedSortIsDisplayed;
    }
    public void scrollToSorByField(WebDriver driver){
        scrollToElement(driver,sortByField);
        sortByField.click();
        log.info("scroll down success");
    }
    public void clickOnSortByPrice(){
        clickOn(sortByOption);
    }
    public void hoverOverAndClickOnProductImg(){
        clickOn(productImg);
        log.info("click on product img success");
    }
}

