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
    String customerFirstName=Utility.decode(pro.getProperty("automationpractice.firstname")) ;
    String customerLastName=Utility.decode(pro.getProperty("automationpractice.lastname")) ;
    String validUseEmail=Utility.decode(pro.getProperty("automationpractice.newEmail")) ;
    String customerPassword=Utility.decode(pro.getProperty("automationpractice.newpassword")) ;
    String customerGender=Utility.decode(pro.getProperty("automationpractice.gender")) ;
    String customerMonth=Utility.decode(pro.getProperty("automationpractice.customerMonth")) ;
    String customerDay=Utility.decode(pro.getProperty("automationpractice.customerDay")) ;
    String customerYear=Utility.decode(pro.getProperty("automationpractice.customerYear")) ;



    @Test
    public void validCred() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        CreateAccountAuthenticationPage CreateAccountAuthenticationPage = new CreateAccountAuthenticationPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.emailAccountCreation(validUseEmail);
        autoLoginPage.clickOnCreateAccountBtn();
        CreateAccountAuthenticationPage.selectGender();
        CreateAccountAuthenticationPage.enterFirstName(customerFirstName);
        CreateAccountAuthenticationPage.enterLasrName(customerLastName);
        CreateAccountAuthenticationPage.selectMonth();
        CreateAccountAuthenticationPage.selectDay();
        CreateAccountAuthenticationPage.selectYear();
        CreateAccountAuthenticationPage.enterPassword(customerPassword);
        CreateAccountAuthenticationPage.clickOnRegister();

        //check user is logged in
        String expectedAccountInformation = "Jhon Claud";
        String actualAccountInformation = autoHomePage.getHeaderText();
        Assert.assertEquals(expectedAccountInformation, actualAccountInformation);



    }

    @Test
    public void ExistingEmail() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());

        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter existing
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUseEmail);
        autoLoginPage.clickOnCreateAccountBtn();

        //error validation

        Assert.assertTrue(autoLoginPage.checkPresenceOfErrorMessage());

    }
}