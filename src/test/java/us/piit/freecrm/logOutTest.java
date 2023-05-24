package us.piit.freecrm;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.freecrmPages.Homepage;
import us.piit.freecrmPages.loginPage;

import java.util.logging.Logger;

public class logOutTest extends CommonAPI {

    Logger log = (Logger) LogManager.getLogger(logOutTest.class.getName());

    String validEmail = "abc123@gmail.com";
    String validPassword = "Abcd@1234";

    @Test
    public void logout() throws InterruptedException {
        loginPage loginPage = new loginPage();loginPage(getDriver());
        Homepage HomePage = new Homepage((WebDriver) getDriver());
        //enter  username, password, and click on login button
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        String expectedHomePageHeader = "home";
        String actualHomePageHeader = us.piit.freecrmPages.Homepage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");


        //checking the login

        Assert.assertTrue(loginPage.checkLoginPage());
        log.info("login page header is displayed");

        String expectedLoginPageHeaderText = "home";
        String actualLoginPageHeaderText = loginPage.LoginPageHeader();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page validation success");
    }

    private void loginPage(WebDriver driver) {
    }

    private void getCurrentTitle() {
    }

//    private Object getDriver() {
//        return null;
//    }

}




