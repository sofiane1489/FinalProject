package us.piit.freecrm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.freecrmPages.Homepage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {

    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("freecrm.email")) ;
    String userPassword=Utility.decode(pro.getProperty("freecrm.password")) ;


    public LoginTest(WebDriver driver) {

    }


    @Test
    public void validCredential() {
        LoginPage loginPage = new LoginPage(getDriver());
           Homepage homePage = new Homepage(getDriver());
        String expectedTitle = "freecrm.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  email, password and click on login button
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(userPassword);
        loginPage.clickonLoginBtn();

        String expectedResult = "Cogmento";
        String StringMyAccountText = null;
        Object Text = new Object();
        String actualResult= Homepage.getMyAccountText(Text);
        Assert.assertEquals(expectedResult, actualResult);
        captureScreenshot();
    }

    private void clickOnLoginBtn() {
    }

    private void enterValidPassword(String userPassword) {
    }

    private void enterValidEmail(String validEmail) {

    }

    @Test
    public void invalidEmail() {
        LoginPage loginPage = new LoginPage(getDriver());
        String expectedTitle = "freecrm.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  email, password, and click on login button

        useFakeEmail();
        loginPage.enterPassword(userPassword);
        loginPage.clickonLoginBtn();

        //error validation

        String expectedErrorMessage = "Something went wrong...\n" +
                "Invalid login";
        String actualErrorMessage = loginPage.getErrorMessageInvalidEmail();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage );
    }

}






