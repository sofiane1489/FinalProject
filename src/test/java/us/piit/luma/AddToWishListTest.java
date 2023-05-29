package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddToWishListTest extends CommonAPI {

    Properties pro= Utility.loadProperties();

    String validEmail= Utility.decode(pro.getProperty("luma.email")) ;
    String validPassword=Utility.decode(pro.getProperty("luma.password")) ;


    @Test
    public void addToWishListFeature() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        TopsPage topsPage = new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage = new CassiusSparringTankPage(getDriver());
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

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

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();

        cassiusSparringTankPage.clickOnSizeLabel();

        cassiusSparringTankPage.clickOnBlueColor();

        cassiusSparringTankPage.scrollToAddToCartBtn(getDriver());

        cassiusSparringTankPage.clickOnAddToWishLIstLink();

        //add to wish list validation
        String expectedConfirmatioTest="Cassius Sparring Tank has been added to your Wish List. Click here to continue shopping.";
        Assert.assertEquals(myAccountPage.getAddToWishListTextConfirmation(),expectedConfirmatioTest);


    }

    @Test(dependsOnMethods = "removeProductsFromWishList")
    public void unableToAddToWishList() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        TopsPage topsPage = new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage = new CassiusSparringTankPage(getDriver());
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());

        // website validation with Title
        String expextedTitle = "Home Page";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(actualTitle, expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBeforeLogin.checkHomePageLogoVisibility());

        homePageBeforeLogin.clickOnMenCategory();

        menPage.clickOnTops48InMenCategory();

        topsPage.clickOnCassiusSparringTank();

        cassiusSparringTankPage.clickOnSizeLabel();

        cassiusSparringTankPage.clickOnBlueColor();

        cassiusSparringTankPage.scrollToAddToCartBtn(getDriver());

        cassiusSparringTankPage.clickOnAddToWishLIstLink();

        //error validation
        String expectedError="You must login or register to add items to your wishlist.";
        Assert.assertEquals(myAccountPage.getErrorMessage(),expectedError);

    }

    @Test(dependsOnMethods = "addToWishListFeature")
    public void removeProductsFromWishList() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePageAfterLogin homePageAfterLogin = new HomePageAfterLogin(getDriver());

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
        String expectedWelcomeMess = "Welcome, mike lee!";
        String actualWelcomeMess = homePageAfterLogin.getWelcomeMessage();
        Assert.assertEquals(expectedWelcomeMess, actualWelcomeMess);

        homePageBeforeLogin.clickOnMenCategory();

        menPage.scrollToElement(getDriver());

        menPage.clickOnCrossIconToRemoveProduct(getDriver());

        // remove from wish list validation
        String expectedRemoveConfirmationText="Cassius Sparring Tank has been removed from your Wish List.";
        Assert.assertEquals(menPage.getRemoveFromWishListConfirmationText(),expectedRemoveConfirmationText);


    }

}
