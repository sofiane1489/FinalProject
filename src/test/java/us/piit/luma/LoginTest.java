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

   LoginPage loginpage=new LoginPage();
   HomePage homePage=new HomePage();

    @Test
    public void validCred(){
        // website validation with luma logo
        boolean actualTitle= loginpage.homaPageTitle();
        Assert.assertTrue(actualTitle);

        loginpage.clickOnSigninBtn();

         loginpage.enterEmail(validEmail);

         loginpage.enterPassword(validPassword);

          loginpage.clickOnLoginBtn();

         //check user logged in
         String expectedWelcomeMess="Welcome, mike lee!";
         String actualWelcomeMess=homePage.getWelcomeMessage();
         Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
    }

    @Test
    public void invalidEmail(){
        boolean actualTitle= loginpage.homaPageTitle();
        Assert.assertTrue(actualTitle);

        loginpage.clickOnSigninBtn();

        loginpage.enterEmail("@gmail.com");

        loginpage.enterPassword(validPassword);

        loginpage.clickOnLoginBtn();

        //validate error
        String expectedError="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualError=loginpage.getErrorMessageInvalidEmail();
        Assert.assertEquals(actualError,expectedError);

    }

    @Test
    public void missingPassword(){
        boolean actualTitle= loginpage.homaPageTitle();
        Assert.assertTrue(actualTitle);

        loginpage.clickOnSigninBtn();

        loginpage.enterEmail(validEmail);

        loginpage.enterPassword("");

        loginpage.clickOnLoginBtn();

        //validate error
        String expectedError="This is a required field.";
        String actualError=loginpage.getErrorMessageMissinPass();
        Assert.assertEquals(actualError,expectedError);
    }
}
