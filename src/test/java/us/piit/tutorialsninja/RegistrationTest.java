package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.tutorialsninjaPage.*;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegistrationTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String userPassword=Utility.decode(pro.getProperty("tutorialsninja.password")) ;
    String existingEmail=Utility.decode(pro.getProperty("tutorialsninja.email"));

    @Test(priority = 1)
    public void userRegistrationTest() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        AffirmationAccountCreationPage affirmationAccountCreationPage = new AffirmationAccountCreationPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderRegisterBtn();
        registrationPage.enterFirstName(useFakeFirstName());
        registrationPage.enterLastName(useFakeLastName());
        registrationPage.enterEmail(useFakeEmail());
        registrationPage.enterPhoneNumber(useFakePhoneNumber());
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

    @Test(priority = 2)
    public void ExistingCred() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderRegisterBtn();
        registrationPage.enterFirstName(useFakeFirstName());
        registrationPage.enterLastName(useFakeLastName());
        registrationPage.enterEmail(existingEmail);
        registrationPage.enterPhoneNumber(useFakePhoneNumber());
        registrationPage.enterPassword(userPassword);
        registrationPage.confirmPassword(userPassword);
        registrationPage.clickOnAgreementCheckBox();
        registrationPage.clickOnContinueBtn();

        //error validation


        boolean actualErrorMessage = registrationPage.checkPresenceOfErrorMessage();
        Assert.assertTrue(actualErrorMessage);
    }
}