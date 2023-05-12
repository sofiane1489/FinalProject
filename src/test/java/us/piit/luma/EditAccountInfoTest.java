package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.lumaPages.*;

public class EditAccountInfoTest extends CommonAPI {
    Logger log= LogManager.getLogger(EditAccountInfoTest.class.getName());

    String validEmail="Alphabetta@gmail.com";
    String validPassword="1234Abcd$";
    String newLastName="doe";
    @Test
    public void editAccountInfo(){
        LoginPage loginPage=new LoginPage(getDriver());
        HomePageBeforeLogin homePageBefore=new HomePageBeforeLogin(getDriver());
        MyAccountPage myAccountPage=new MyAccountPage(getDriver());
        EditAccountInformationPage editAccountInformationPage=new EditAccountInformationPage(getDriver());

        // website validation with Title
        String expextedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(actualTitle,expextedTitle);
        // website validation with luma logo
        Assert.assertTrue(homePageBefore.homePageLogoVisibility());

        homePageBefore.clickOnSigninBtn();

        loginPage.enterEmail(validEmail);

        loginPage.enterPassword(validPassword);

        loginPage.clickOnLoginBtn();

        //validate user logged in
        //validate the dropdown visibility
        Assert.assertTrue( homePageBefore.checkDropDownVisibility());


        //validate the dropdown interactivity
        Assert.assertTrue( homePageBefore.checkDropDownInteractibility());

       homePageBefore.clickOnDropDown();

       homePageBefore.clickOnMyAccount();

       myAccountPage.clickOnEdit();

       waitFor(3);
       editAccountInformationPage.doubleClickOnLastName();

        waitFor(2);
       editAccountInformationPage.deleteLastName();

       editAccountInformationPage.enterNewLastName(newLastName);


       editAccountInformationPage.clickOnSaveBtn();

         //edit account information validation
        String expectedMess="You saved the account information.";
        String actualMess=myAccountPage.getEditTextConfirmation();
        Assert.assertEquals(expectedMess,expectedMess);

    }

}

