package us.piit.freecrm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.freecrmPages.Homepage;
import us.piit.freecrmPages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    Properties pro = Utility.loadProperties();
    String validEmail = Utility.decode(pro.getProperty("freecrm.email"));
    String validPassword = Utility.decode(pro.getProperty("freecrm.password"));
    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
        Homepage homepage = new Homepage(getDriver());
        String expectedTitle = " CRM Software for Any Business\n";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        waitFor(3);

        //enter  email, password, and click on login button
        loginPage.enteremail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginBtn();
        //check user is logged in
        String expectedhomePageHeader = "farid Oularbi";
        String actualhomePageHeader = homepage.getHeaderText();
        Assert.assertEquals(expectedhomePageHeader,actualhomePageHeader);
        waitFor(3);
    }
    @Test
    public void invalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        Homepage homepage = new Homepage(getDriver());
        String expectedTitle = "CRM Software for Any Business\n";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  email, password, and click on login button
        loginPage.enteremail("invalidemail");
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Something went wrong...\n" +
                "Invalid login";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }}

















