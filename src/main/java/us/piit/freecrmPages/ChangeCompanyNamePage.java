package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class ChangeCompanyNamePage extends CommonAPI {
    Logger log = LogManager.getLogger(ChangeCompanyNamePage.class.getName());
    public ChangeCompanyNamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[2]/a")
    WebElement freeAccountBtn;

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[2]/a")
    WebElement accountsBtn;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div/div[2]/div/div[2]/div/form/div[1]/div/input")
    WebElement companyNameField;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/form/div[7]/button")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/b")
    WebElement companyNameText;

    public void setFreeAccountBtn(){
        clickOn(freeAccountBtn);
        log.info("click on free account success");
    }
    public void setAccountsBtn() {
        clickOn(accountsBtn);
        log.info("click on accounts success");
    }
    public void setCompanyNameField (String nameField) {
        type(companyNameField);
        log.info("enter title success");
    }

    private void type(WebElement companyNameField) {
    }
    public void saveBtn() {
        clickOn(saveBtn);
        log.info("click on save success");
    }
    public boolean getecompanyText() {
        boolean text = isVisible(companyNameText);
        log.info("company text visible success");
        return text;

    }
}
