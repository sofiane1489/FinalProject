package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegistrationTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userFirstName=Utility.decode(pro.getProperty("tutorialsninja.firstname")) ;
    String userLastName=Utility.decode(pro.getProperty("tutorialsninja.lastname")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;
    String userPhoneNumber=Utility.decode(pro.getProperty("tutorialsninja.phonenumber")) ;
    String newEmail=Utility.decode(pro.getProperty("tutorialsninja.newEmail")) ;



    @Test
    public void userRegitrationTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        AffirmationAccountCreationPage affirmationAccountCreationPage = new AffirmationAccountCreationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.clickOnContinueBtn();
        registrationPage.enterFirstName(userFirstName);
        registrationPage.enterLastName(userLastName);
        registrationPage.enterEmail(newEmail);
        registrationPage.enterPhoneNumber(userPhoneNumber);
        registrationPage.enterPassword(userPassword);
        registrationPage.confirmPassword(userPassword);
        registrationPage.clickOnAgreementCheckBox();
        registrationPage.clickOnContinueBtn();



        //registration confirmation
        String expectedMessage = "Congratulations! Your new account has been successfully created!";
        String actualMessage = affirmationAccountCreationPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        captureScreenshot();
    }

   // @Test
    public void ExistingCred() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.clickOnContinueBtn();
        registrationPage.enterFirstName(userFirstName);
        registrationPage.enterLastName(userLastName);
        registrationPage.enterEmail(validEmail);
        registrationPage.enterPhoneNumber(userPhoneNumber);
        registrationPage.enterPassword(userPassword);
        registrationPage.confirmPassword(userPassword);
        registrationPage.clickOnAgreementCheckBox();
        registrationPage.clickOnContinueBtn();

        //error validation

        boolean expectedErrorMessage = true;
        boolean actualErrorMessage = registrationPage.checkPresenceOfErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}