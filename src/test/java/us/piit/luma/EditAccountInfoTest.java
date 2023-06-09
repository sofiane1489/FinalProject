package us.piit.luma;

import jdk.jshell.execution.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class EditAccountInfoTest extends CommonAPI {

    Properties pro=Utility.loadProperties();

    String email=Utility.decode(pro.getProperty("luma.otherEmail"));
    String password= Utility.decode(pro.getProperty("luma.password"));

    @Test
    public void editLastName(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        EditAccountInformationPage editAccountInformationPage=new EditAccountInformationPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.checkHomePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(email);

        loginPage.enterPassword(password);

        loginPage.clickOnLoginBtn();

        //validate user logged in
        //validate the dropdown visibility
        Assert.assertTrue( homePageAfterLogin.checkDropDownVisibility());

        //validate the dropdown interactivity
        Assert.assertTrue( homePageAfterLogin.checkDropDownInteractibility());

        homePageAfterLogin.clickOnDropDown();

        homePageAfterLogin.clickOnMyAccount();

        myAccountPage.clickOnEdit();

        editAccountInformationPage.deleteLastName();

        editAccountInformationPage.enterNewLastName(useFakeLastName());

        editAccountInformationPage.clickOnSaveBtn();

        //edit account information validation
        String expectedMess="You saved the account information.";
        Assert.assertEquals(expectedMess,myAccountPage.getSaveEditTextConfirmation());

    }

    @Test(dependsOnMethods = "editLastName")
    public void editBillingAddress() {
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        EditAccountInformationPage editAccountInformationPage=new EditAccountInformationPage(getDriver());
        HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.checkHomePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(email);

        loginPage.enterPassword(password);

        loginPage.clickOnLoginBtn();

        //validate user logged in
        //validate the dropdown visibility
        Assert.assertTrue( homePageAfterLogin.checkDropDownVisibility());

        //validate the dropdown interactivity
        Assert.assertTrue( homePageAfterLogin.checkDropDownInteractibility());

        homePageAfterLogin.clickOnDropDown();

        homePageAfterLogin.clickOnMyAccount();

        myAccountPage.clickOnEditAddressLink();

        myAccountPage.enterNewAddress(useFakeAddress());

        myAccountPage.enterNewcity(useFakeCity());

       myAccountPage.selectState(useFakeState());

        myAccountPage.enterNewZipcode(useFakeZipcode());

        myAccountPage.enterTelephoneNumber(useFakePhoneNumber());

        myAccountPage.clickOnSaveAddressBtn();

        //edit address validation
        String expectedMessage="You saved the address.";
       Assert.assertEquals(myAccountPage.getSaveEditTextConfirmation(),expectedMessage);



    }

}
