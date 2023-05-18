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

    Properties pro= Utility.loadProperties();
    String password=Utility.decode(pro.getProperty("luma.password")) ;
    String email=Utility.decode(pro.getProperty("luma.email")) ;

    @Test(priority =1)
    public void createNewAccount(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

              // website validation with Title
              String expextedTitle="Home Page";
              String actualTitle=getCurrentTtile();
              Assert.assertEquals(actualTitle,expextedTitle);

         // website validation with luma logo
           Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

           homePageBeforeLogin.clickOnCreateAnAccountLink();

           createAccountPage.enterFirstName(useFakeFirstName());

           createAccountPage.enterLastName(useFakeLastName());

           createAccountPage.enterEmail(useFakeEmail());

           createAccountPage.enterPassword(password);

           createAccountPage.enterConfirmationPassword(password);

           createAccountPage.clickOnCreateAccountBtn();

        //create account validation
        String expectedContInfor="Thank you for registering with Main Website Store.";
        String actualContInfor=homePageAfterLogin.getThanksMessage();
        Assert.assertEquals(expectedContInfor,actualContInfor);
}

    @Test(priority = 2)
    public void emailAlreadyTaken(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        CreateAccountPage createAccountPage=new CreateAccountPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnCreateAnAccountLink();

        createAccountPage.enterFirstName(useFakeFirstName());

        createAccountPage.enterLastName(useFakeLastName());

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
