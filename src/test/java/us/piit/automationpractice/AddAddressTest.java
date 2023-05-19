package us.piit.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPracticePages.AddAddressPage;
import us.piit.automationPracticePages.AutoHomePage;
import us.piit.automationPracticePages.AutoLoginPage;
import us.piit.automationPracticePages.MyAddressesPage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AddAddressTest extends CommonAPI {
    Properties pro = Utility.loadProperties();
    String validUsername = Utility.decode(pro.getProperty("automationpractice.email"));
    String validPassword = Utility.decode(pro.getProperty("automationpractice.password"));
    String firstName = Utility.decode(pro.getProperty("automationpractice.firstName"));
    String lastName = Utility.decode(pro.getProperty("automationpractice.lastName"));
    String address = Utility.decode(pro.getProperty("automationpractice.address"));
    String city = Utility.decode(pro.getProperty("automationpractice.city"));
    String state = Utility.decode(pro.getProperty("automationpractice.state"));
    String zipCode = Utility.decode(pro.getProperty("automationpractice.zipcode"));
    String phoneNumber = Utility.decode(pro.getProperty("automationpractice.number"));
    String addressReference = Utility.decode(pro.getProperty("automationpractice.reference"));
    @Test
    public void AddFirstAddressTest() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        AddAddressPage addAddressPage = new AddAddressPage(getDriver());
        MyAddressesPage myaddressesPage = new MyAddressesPage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.enterPassword(validPassword);
        autoLoginPage.clickOnLoginBtn();
        autoHomePage.clickOnAddFirstAddressBtn();
        addAddressPage.enterFirstname(firstName);
        addAddressPage.enterLastname(lastName);
        addAddressPage.enterAddress(address);
        addAddressPage.enterCityName(city);
        addAddressPage.clickOnStateBox();
        waitFor(2);
        addAddressPage.selectStateName(Integer.parseInt(state));
        addAddressPage.enterZipCode(zipCode);
        addAddressPage.enterPhoneNumber(phoneNumber);
        addAddressPage.enterAddressReference(addressReference);
        addAddressPage.clickOnSubmitBtn();
        String expectedAddedAddressMessageConfirmation = "Your addresses are listed below.";
        String actualAddedAddressMessageConfirmation = myaddressesPage.getValidationMessage();
        Assert.assertEquals(expectedAddedAddressMessageConfirmation, actualAddedAddressMessageConfirmation);
    }
}
