package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.CreateAccountPage;
import us.piit.lumaPages.HomePageAfterLogin;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.lumaPages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class CreateAccountTest extends CommonAPI {
    Logger log= LogManager.getLogger(CreateAccountTest.class.getName());

    Properties pro= Utility.loadProperties();
    String firstname=Utility.decode(pro.getProperty("luma.firstname")) ;
    String lastname=Utility.decode(pro.getProperty("luma.lastname")) ;
    String createEmail=Utility.decode(pro.getProperty("luma.newEmail")) ;
    String password=Utility.decode(pro.getProperty("luma.password")) ;
    String email=Utility.decode(pro.getProperty("luma.email")) ;

   // @Test
    public void createNewAccount(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

              // website validation with Title
              String expextedTitle="Home Page";
              String actualTitle=getCurrentTtile();
              Assert.assertEquals(actualTitle,expextedTitle);

         // website validation with luma logo
           Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

           homePageBeforeLogin.clickOnCreateAnAccountLink();

           createAccountPage.enterFirstName(firstname);

           createAccountPage.enterLastName(lastname);

           createAccountPage.enterEmail(createEmail);

           createAccountPage.enterPassword(password);

           createAccountPage.enterConfirmationPassword(password);

           createAccountPage.clickOnCreateAccountBtn();

        //create account validation
        String expectedContInfor="mike lee\n" +
                "Bettta@gmail.com";
        String actualContInfor=homePageAfterLogin.getAccountMessageInfo();
        Assert.assertEquals(expectedContInfor,actualContInfor);
}

    @Test
    public void emailAlreadyTaken(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.homePageLogoVisibility());

        homePageBeforeLogin.clickOnCreateAnAccountLink();

        createAccountPage.enterFirstName(firstname);

        createAccountPage.enterLastName(lastname);

        createAccountPage.enterEmail(email);

        createAccountPage.enterPassword(password);

        createAccountPage.enterConfirmationPassword(password);

        createAccountPage.clickOnCreateAccountBtn();

        //error validation
        String expectedErrorMessage="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
        String actualErrorMessage = createAccountPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }
}
