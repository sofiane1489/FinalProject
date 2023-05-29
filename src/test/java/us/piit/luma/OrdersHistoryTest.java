package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class OrdersHistoryTest extends CommonAPI{

    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("luma.email")) ;
    String validPassword=Utility.decode(pro.getProperty("luma.password")) ;

    @Test
    public void checkOrdersHistory(){
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());
        EditAccountInformationPage editAccountInformationPage=new EditAccountInformationPage(getDriver());
        MyOrdersPage myOrdersPage=new MyOrdersPage(getDriver());


        // website validation with Title
        String expextedTitle = "Home Page";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(actualTitle, expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

        //check user logged in
        String expectedWelcomeMess="Welcome, mike lee!";
        String actualWelcomeMess=homePageAfterLogin.getWelcomeMessage();
        Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);

        homePageAfterLogin.clickOnDropDown();

        homePageAfterLogin.clickOnMyAccount();

        editAccountInformationPage.clickOnMyOrdersBtn(getDriver());

        //orders history validation
        String expectedTotalOrders="2 Item(s)";
        Assert.assertEquals(myOrdersPage.getToolbarAmountText(),expectedTotalOrders);

    }
}
