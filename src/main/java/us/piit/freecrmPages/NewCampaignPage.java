package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;


public class NewCampaignPage extends CommonAPI {
    Logger log = LogManager.getLogger(NewCampaignPage.class.getName());
    public NewCampaignPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[11]/a/span")
    WebElement campaignsBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[2]/button")
        WebElement CreateBtn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/input")
    WebElement nameField;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
    WebElement campaigntext;


    public void campaignbtn(){
        clickOn(campaignsBtn);
        log.info("click on campaign success");
    }
    public void CreateBtn() {
        clickOn(CreateBtn);
        log.info("click on create success");
    }
    public void nameFieldbox (String name) {
        type(nameField);
        log.info("enter name success");
    }

    private void type(WebElement nameFieffld) {
    }

    public void saveBtn() {
        clickOn(saveBtn);
        log.info("click on save success");
    }
    public boolean getecampaignText() {
        boolean text = isVisible(campaigntext);
        log.info("compaign text visible success");
        return text;

    }















}
