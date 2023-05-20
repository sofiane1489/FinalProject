package us.piit.luma;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.HomePageBeforeLogin;
import us.piit.utility.Utility;

import java.util.Properties;

public class SubscribeTest extends CommonAPI {

    Properties pro= Utility.loadProperties();
    String invalidEmail=Utility.decode(pro.getProperty("luma.invalidEmail"));

    @Test(dependsOnMethods = "subscribeWithInvalidEmail")
    public void subscribeWithValidEmail(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);

        //website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.enterEmailToSubscribe(useFakeEmail());
        homePageBeforeLogin.clickOnSubscribeBtn();

        //subscribe validation
        String expectedConfirmationText="Thank you for your subscription.";
        String actualConfirmationText=homePageBeforeLogin.getSubscribeConfirmationText();
        Assert.assertEquals(actualConfirmationText,expectedConfirmationText);

    }

    @Test
    public void subscribeWithInvalidEmail(){
        HomePageBeforeLogin homePageBeforeLogin=new HomePageBeforeLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);

       homePageBeforeLogin.scrollDown(getDriver());

        homePageBeforeLogin.enterEmailToSubscribe(invalidEmail);
        waitFor(1);
        homePageBeforeLogin.clickOnSubscribeBtn();

        //error validation
        String expectedErrorText="Please enter a valid email address (Ex: johndoe@domain.com).";
        String actualErrorText=homePageBeforeLogin.getSubscribeErrorText();
        Assert.assertEquals(actualErrorText,expectedErrorText);

    }
}
