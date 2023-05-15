package us.piit.automationpractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.AutomationPracticePages.AutoLoginPage;
import us.piit.AutomationPracticePages.CreateAccountAuthenticationPage;
import us.piit.base.CommonAPI;

public class CreatAccountTest extends CommonAPI {
    Logger log = LogManager.getLogger(CreatAccountTest.class.getName());
    String validUseEmail ="Exemple@gmail.com";
    String customerFirstName = "Jhon";
    String customerLastName = "Claud";
    String customerPassword ="abcd1234$";
    String customerGender = "Mr";
    int customerMonth = 5;
    int customerDay = 4;
    int customerYear = 1991;


    @Test
    public void validCred() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage homePage = new CreateAccountAuthenticationPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.emailAccountCreation(validUseEmail);
        loginPage.clickOnCreateAccountBtn();
        homePage.selectGender();
        homePage.enterFirstName(customerFirstName);
        homePage.enterLasrName(customerLastName);
        homePage.selectMonth();
        homePage.selectDay();
        homePage.selectYear();
        homePage.enterPassword(customerPassword);
        homePage.clickOnRegister();

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = homePage.getHeaderText();
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);



    }

    @Test
    public void ExistingEmail() {
        AutoLoginPage loginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage homePage = new CreateAccountAuthenticationPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        loginPage.ClickOnSignInBtn();
        loginPage.emailAccountCreation(validUseEmail);
        loginPage.clickOnCreateAccountBtn();
        log.info("click on sign in success");
        // enter existing
        loginPage.ClickOnSignInBtn();
        loginPage.enterUsername(validUseEmail);
        loginPage.clickOnCreateAccountBtn();
        log.info("enter email success");
        log.info("click on create an account success");
        //error validation
        String expectedErrorValidation = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String actualErrorValidation = homePage.getHeaderText();
        Assert.assertEquals(actualErrorValidation, expectedErrorValidation);

    }
}