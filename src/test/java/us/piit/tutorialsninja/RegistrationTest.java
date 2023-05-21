package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.AffirmationAccountCreationPage;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.RegistrationPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegistrationTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validEmail=Utility.decode(pro.getProperty("tutorialsninja.email")) ;
    String userFirstName=Utility.decode(pro.getProperty("tutorialsninja.firstname")) ;
    String userLastName=Utility.decode(pro.getProperty("tutorialsninja.lastname")) ;
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;
    String userPhoneNumber=Utility.decode(pro.getProperty("tutorialsninja.phonenumber")) ;
    String invalidEmail=Utility.decode(pro.getProperty("tutorialsninja.invalidemail")) ;


    @Test
    public void validCred() {
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        AffirmationAccountCreationPage affirmationAccountCreationPage = new AffirmationAccountCreationPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        loginPage.clickOnContinueBtn();
        registrationPage.enterFirstName(userFirstName);
        registrationPage.enterLastName(userLastName);
        registrationPage.enterEmail(validEmail);
        registrationPage.enterPhoneNumber(userPhoneNumber);
        registrationPage.enterPassword(userPassword);
        registrationPage.confirmPassword(userPassword);
        registrationPage.clickOnAgreementCheckBox();
        registrationPage.clickOnContinueBtn();


        //registration confirmation
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = affirmationAccountCreationPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
        captureScreenshot();
    }

   // @Test
    public void ExistingCred() {
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        String expectedTitle = "tutorialsninja.com";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button

        loginPage.clickOnContinueBtn();
        registrationPage.enterFirstName(userFirstName);
        registrationPage.enterLastName(userLastName);
        registrationPage.enterEmail(invalidEmail);
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