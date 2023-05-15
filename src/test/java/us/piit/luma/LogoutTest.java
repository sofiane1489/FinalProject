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

public class LogoutTest extends CommonAPI {

    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("luma.email"));
    String validPassword=Utility.decode(pro.getProperty("luma.password"));

    @Test
    public void signOut(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnSigninBtn();
        loginPage.enterEmail(validEmail);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


        homePageAfterLogin.clickOnDropDown();
        homePageAfterLogin.clickOnSignOutLink();

        //sign out validation
        String expectedMesssage="You are signed out";
        String actualMessage=homePageAfterLogin.getSignOutConfirmationText();
       Assert.assertEquals(actualMessage,expectedMesssage);


    }

}
