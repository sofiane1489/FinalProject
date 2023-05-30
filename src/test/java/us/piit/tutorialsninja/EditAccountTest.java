package us.piit.tutorialsninja;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.tutorialsninjaPage.AccountInformationPage;
import us.piit.tutorialsninjaPage.HomePage;
import us.piit.tutorialsninjaPage.LoginPage;
import us.piit.tutorialsninjaPage.WelcomePage;
import us.piit.utility.Utility;

import java.util.Properties;

public class EditAccountTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validEmail = Utility.decode(pro.getProperty("tutorialsninja.email"));
    String userPassword = Utility.decode(pro.getProperty("tutorialsninja.password"));



    @Test
    public void editUserInformationAccount() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AccountInformationPage accountInformationPage = new AccountInformationPage(getDriver());
        String expectedTitle = "Your Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //enter  username, password, and click on login button
        welcomePage.clickOnMyAccountBtn();
        welcomePage.hoverOverAndClickOnHeaderLoginBtn();
        loginPage.enterValidEmail(validEmail);
        loginPage.enterValidPassword(userPassword);
        loginPage.clickOnLoginBtn();
        waitFor(2);
        homePage.clickOnEditAccountBtn();
        waitFor(2);
        useFakeFirstName();
        useFakeLastName();
        useFakeEmail();
        useFakePhoneNumber();
        accountInformationPage.clickOnSubmitBtn();
        //edit account validation
        String expectedMessage = "Success: Your account has been successfully updated.";
        String actualMessage = homePage.getEditAccountConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
