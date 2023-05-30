package us.piit.freecrmPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class Homepage extends CommonAPI {
    Logger log = LogManager.getLogger(Homepage.class.getName());

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[1]")
    WebElement logodisplayed;

    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")
    WebElement searchBarField;
    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/i")
    WebElement clickonsettingbtn;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[2]/a/span")
    WebElement contactBtn;
    @FindBy(xpath = "//*[@id=\"onesignal-bell-launcher\"]/div[1]/svg/path")
    WebElement notificationBell;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[4]/a/span")
    WebElement compagnieSection;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[5]/a/span")
    WebElement dealSection;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[7]/a/span")
    WebElement casesSection;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[4]/i")
    WebElement trashBtn;
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[2]/a/span")
    WebElement calanderBtn;

    public static String getMyAccountText(Object text) {
        return null;
    }
    {}
    public static String getHeaderText() {
        return null;
    }
    public boolean logo(){
        boolean logoPageIsDisplayed =  isVisible(searchBarField);
        log.info("Cogmento logo is displayed");
        return logoPageIsDisplayed;}
    public void SearchBarType(String searchItem){
        typeEnter(searchBarField,searchItem);
        log.info("click on search bar and type  success");}

        public void contactbtn(){
            clickOn(contactBtn);
            log.info("click on save button success");
            }
        public void notificationbell(){
            clickOn(notificationBell);
            log.info("click notification Bell button success");
        } public void compButton(){
            clickOn(compagnieSection);
            log.info("click on compagnie Section button success");
        } public void dealbutton(){
            clickOn(dealSection);
            log.info("click on deal button success");
        } public void casesbutton(){
            clickOn(casesSection);
            log.info("click on cases button success");
        }
        public void trashbtn(){
            clickOn(trashBtn);
            log.info("click on trash Btn success");
        }
        public void calanderbtn(){
            clickOn(calanderBtn);
            log.info("click on trash Btn success");
        }
}

