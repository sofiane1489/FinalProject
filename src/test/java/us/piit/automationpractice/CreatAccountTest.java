package us.piit.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPracticePages.AutoHomePage;
import us.piit.automationPracticePages.AutoLoginPage;
import us.piit.automationPracticePages.CreateAccountAuthenticationPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class CreatAccountTest extends CommonAPI {
    Properties pro= Utility.loadProperties();
    String validUsername=Utility.decode(pro.getProperty("automationpractice.email")) ;
    String customerFirstName=Utility.decode(pro.getProperty("automationpractice.firstname")) ;
    String customerLastName=Utility.decode(pro.getProperty("automationpractice.lastname")) ;
    String customerPassword=Utility.decode(pro.getProperty("automationpractice.newpassword")) ;
    String customerMonth=Utility.decode(pro.getProperty("automationpractice.customerMonth")) ;
    String customerDay=Utility.decode(pro.getProperty("automationpractice.customerDay")) ;
    String customerYear=Utility.decode(pro.getProperty("automationpractice.customerYear")) ;



    @Test
    public void validCred() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage createAccountAuthenticationPage = new CreateAccountAuthenticationPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.emailAccountCreation(useFakeEmail());
        autoLoginPage.clickOnCreateAccountBtn();
        createAccountAuthenticationPage.selectGender();
        createAccountAuthenticationPage.enterFirstName(customerFirstName);
        createAccountAuthenticationPage.enterLastName(customerLastName);
        createAccountAuthenticationPage.enterPassword(customerPassword);
        createAccountAuthenticationPage.selectDay(Integer.parseInt(customerDay));
        createAccountAuthenticationPage.selectMonth(Integer.parseInt(customerMonth));
        createAccountAuthenticationPage.selectYear(customerYear);

        createAccountAuthenticationPage.clickOnRegister();

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = autoHomePage.getHeaderText();
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);



    }

   // @Test
    public void ExistingEmail() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());

        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter existing
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.clickOnCreateAccountBtn();

        //error validation

        Assert.assertTrue(autoLoginPage.checkPresenceOfErrorMessage());
        captureScreenshot();
    }
}