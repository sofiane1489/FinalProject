package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class TopsPage extends CommonAPI {
    Logger log= LogManager.getLogger(TopsPage.class.getName());

    public TopsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

   @FindBy(css="img[alt='Cassius Sparring Tank']")
    WebElement cassiusSparringTankLink;


    @FindBy(xpath="//div[@class='column main']//div[2]//div[1]//a[1]")
    WebElement listModeBtn;

    @FindBy(css="#toolbar-amount")
    WebElement toolbarAmount;


    @FindBy(css="#maincontent :nth-child(4) div  :nth-child(3)  div:nth-child(5) select")
    WebElement sortByList;

    @FindBy(xpath="//div[@class='products wrapper grid products-grid']//a[@href='https://magento.softwaretestingboard.com/abominable-hoodie.html']/following-sibling::div/strong")
    WebElement firstProductText;

    public void clickOnCassiusSparringTank(){
        clickOn(cassiusSparringTankLink);
        log.info("click on Cassius Sparring Tank success");
    }
    public void clickOnListModeBtn(){
        clickOn(listModeBtn);
        log.info("click on list mode btn success");
    }

    public String getToolabarAmountText(){
        String text=getElementText(toolbarAmount);
        log.info("get text success");
        return text;
    }
    public void clickOnSortByNameOption(){
        selectByIn(sortByList,1);
        log.info("click on sort by list success");
    }
    public String getProductText(){
        String text=getElementText(firstProductText);
        log.info("get text success");
        return text;
    }

}
