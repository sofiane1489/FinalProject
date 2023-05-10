package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePage;
import us.piit.lumaPages.LoginPage;

public class LoginTest extends CommonAPI {
    Logger log= LogManager.getLogger(LoginTest.class.getName());

    String validEmail="Betta@gmail.com";
    String validPassword="1234Abcd$";

   LoginPage loginPage=new LoginPage();
   HomePage homePage=new HomePage();

    @Test
    public void validCred(){
        // website validation with luma logo
        boolean actualTitle= loginPage.homaPageTitleVisibility();
        Assert.assertTrue(actualTitle);

        loginPage.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

         //check user logged in
         String expectedWelcomeMess="Welcome, mike lee!";
         String actualWelcomeMess=homePage.getWelcomeMessage();
         Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
    }

    @Test
    public void invalidEmail(){
        boolean actualTitle= loginPage.homaPageTitleVisibility();
        Assert.assertTrue(actualTitle);

        loginPage.clickOnSigninBtn();

        loginPage.enterEmail("@gmail.com");

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

        //validate error
        String expectedError="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualError=loginPage.getErrorMessageInvalidEmail();
        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void missingPassword(){
        boolean actualTitle= loginPage.homaPageTitleVisibility();
        Assert.assertTrue(actualTitle);

        loginPage.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword("");

        loginPage.clickOnLoginBtn();

        //validate error
        String expectedError="This is a required field.";
        String actualError=loginPage.getErrorMessageMissinPass();
        Assert.assertEquals(actualError,expectedError);
    }
}
