package us.piit.luma;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddToCompareTest extends CommonAPI {

    Properties pro= Utility.loadProperties();

    String validEmail=Utility.decode(pro.getProperty("luma.email")) ;
    String validPassword=Utility.decode(pro.getProperty("luma.password")) ;

    @Test
    public void addToCompareList() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        TopsPage topsPage = new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage = new CassiusSparringTankPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());


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

        cassiusSparringTankPage.clickOnAddToCompareLink();

        //add to compare validation
        String expectedTextConfirmation="You added product Cassius Sparring Tank to the comparison list.";
        Assert.assertEquals(cassiusSparringTankPage.getConfirmationText(),expectedTextConfirmation);

    }

    @Test(dependsOnMethods = "addToCompareFeature")
    public void removeFromCompareList() {
        HomePageBeforeLogin homePageBeforeLogin = new HomePageBeforeLogin(getDriver());
        MenCategoryPage menPage = new MenCategoryPage(getDriver());
        TopsPage topsPage = new TopsPage(getDriver());
        CassiusSparringTankPage cassiusSparringTankPage = new CassiusSparringTankPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());
        LoginPage loginPage=new LoginPage(getDriver());

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

        homePageAfterLogin.clickOnCasiusSparking(getDriver());

        homePageAfterLogin.clickOnOKAlert(getDriver());

        //remove from comparison list validation
        String expectedTextConfirmation="You removed product Cassius Sparring Tank from the comparison list.";
       Assert.assertEquals(homePageAfterLogin.getRemoveProductConfirmationText(),expectedTextConfirmation);

    }
}
