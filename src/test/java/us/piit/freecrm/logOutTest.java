package us.piit.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.freecrmPages.Homepage;
import us.piit.freecrmPages.LogOutPage;
import us.piit.freecrmPages.LoginPage;

public class logOutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogOutPage.class.getName());

    String validEmail = "bestfred00@gmail.com";
    String validPassword = "Abcd@1234";

    @Test
    public void logout() throws InterruptedException {
        LoginPage loginPage=new LoginPage(getDriver());
      Homepage homepage=new Homepage(getDriver());
        String expectedTitle = "CRM Software for Any Business\n";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  email, password, and click on login button
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //check user is logged in
        String expectedHomePageHeader = "farid oularbi";
        String actualHomePageHeader = homepage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");



        //check user is landed to the login page

        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
        log.info("login page header is displayed");

        String expectedLoginPageHeaderText = "CRM Software for Any Business\n";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
        captureScreenshot();
    }

}

//    Logger log = (Logger) LogManager.getLogger(logOutTest.class.getName());
//
//    String validEmail = "abc123@gmail.com";
//    String validPassword = "Abcd@1234";
//
//    @Test
//    public void logout() throws InterruptedException {
//        LoginPage loginPage=new LoginPage();
//        Homepage HomePage = new Homepage((WebDriver) getDriver());
//        //enter  username, password, and click on login button
//        loginPage.enterEmail(validEmail);
//        loginPage.enterPassword(validPassword);
//        loginPage.clickOnLoginBtn();
//
//
//        String expectedHomePageHeader = "home";
//        String actualHomePageHeader = us.piit.freecrmPages.Homepage.getHeaderText();
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("user logged in success");
//
//
//        //checking the login
//
//        Assert.assertTrue(loginPage.checkLoginPage());
//        log.info("login page header is displayed");
//
//        String expectedLoginPageHeaderText = "home";
//        String actualLoginPageHeaderText = loginPage.LoginPageHeader();
//        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
//        log.info("login page validation success");
//    }
//
//    private void loginPage(WebDriver driver) {
//    }
//
//    private void getCurrentTitle() {
//    }
//
////    private Object getDriver() {
////        return null;
////    }






