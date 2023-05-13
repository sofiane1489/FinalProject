package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageAfterLogin;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class LoginTest extends CommonAPI {
    Logger log= LogManager.getLogger(LoginTest.class.getName());

    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("luma.email")) ;
    String validPassword=Utility.decode(pro.getProperty("luma.password")) ;
    String invalidEmail=Utility.decode(pro.getProperty("luma.invalidEmail")) ;

    @Test
    public void validCred(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        HomePageAfterLogin homePageAfter=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.homePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

         //check user logged in
         String expectedWelcomeMess="Welcome, mike lee!";
         String actualWelcomeMess=homePageAfter.getWelcomeMessage();
         Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
    }

    @Test
    public void invalidEmail(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        HomePageAfterLogin homePageAfter=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.homePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(invalidEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

        //validate error
        String expectedError="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualError=loginPage.getErrorMessageInvalidEmail();
        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void missingPassword(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        HomePageAfterLogin homePageAfter=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.homePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword("");

        loginPage.clickOnLoginBtn();

        //validate error
        String expectedError="This is a required field.";
        String actualError=loginPage.getErrorMessageMissinPass();
        Assert.assertEquals(actualError,expectedError);
    }
}
