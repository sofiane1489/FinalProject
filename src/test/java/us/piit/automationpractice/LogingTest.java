package us.piit.automationpractice;

import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class LogingTest extends CommonAPI {
    Properties pro= Utility.loadProperties();

    String validUsername=Utility.decode(pro.getProperty("automationpractice.email")) ;
    String validPassword=Utility.decode(pro.getProperty("automationpractice.password")) ;
    String invalidUsername=Utility.decode(pro.getProperty("automationpractice.invalidEmail")) ;


//    @Test
//    public void validCredential() {
//        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
//        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
//        String expectedTitle = "My Store";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        //click on sign in, enter  username, password, and click on login button
//        autoLoginPage.ClickOnSignInBtn();
//        autoLoginPage.enterUsername(validUsername);
//        autoLoginPage.enterPassword(validPassword);
//        autoLoginPage.clickOnLoginBtn();
//
//        //check user is logged in
//        String expectedAccountInformation = "Jhon Claud";
//        String actualAccountInformation = autoHomePage.getWelcomeMessage();
//        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);
//
//    }
//    @Test
//    public void invalidUsername() {
//        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
//        String expectedTitle = "My Store";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        //enter  username, password, and click on login button
//        autoLoginPage.ClickOnSignInBtn();
//        autoLoginPage.enterUsername(invalidUsername);
//        autoLoginPage.enterPassword(validPassword);
//        autoLoginPage.clickOnLoginBtn();
//
//        //error validation
//
//        Assert.assertTrue(autoLoginPage.checkErrorMessage());
//    }
//    @Test
//    public void missingPassword() {
//        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
//
//        String expectedTitle = "My Store";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        //enter  username, password, and click on login button
//        autoLoginPage.ClickOnSignInBtn();;
//        autoLoginPage.enterUsername(validUsername);
//        autoLoginPage.enterPassword("");
//        autoLoginPage.clickOnLoginBtn();
//
//        //error validation
//
//        Assert.assertTrue(autoLoginPage.checkErrorMessage());
//    }


}