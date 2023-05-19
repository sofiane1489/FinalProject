package us.piit.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPracticePages.AutoHomePage;
import us.piit.automationPracticePages.AutoLoginPage;
import us.piit.automationPracticePages.CustomerServicePage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class ContactServiceProvidedTest extends CommonAPI {
    Properties pro = Utility.loadProperties();

    String validUsername = Utility.decode(pro.getProperty("automationpractice.email"));
    String validPassword = Utility.decode(pro.getProperty("automationpractice.password"));
    String customerChoose = Utility.decode(pro.getProperty("automationpractice.choose"));
    String orderReference = Utility.decode(pro.getProperty("automationpractice.orderReference"));
    String orderSummary = Utility.decode(pro.getProperty("automationpractice.summary"));
    String message = Utility.decode(pro.getProperty("automationpractice.message"));
    @Test
    public void contactServiceTest() {
        AutoLoginPage autoLoginPage = new AutoLoginPage(getDriver());
        AutoHomePage autoHomePage = new AutoHomePage(getDriver());
        CustomerServicePage cuctomerServicePage = new CustomerServicePage(getDriver());
        String expectedTitle = "My Store";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on sign in, enter  username, password, and click on login button
        autoLoginPage.ClickOnSignInBtn();
        autoLoginPage.enterUsername(validUsername);
        autoLoginPage.enterPassword(validPassword);
        autoLoginPage.clickOnLoginBtn();
        autoHomePage.clickOnContactBtn();
        cuctomerServicePage.clickOnContactOptionBox();
        cuctomerServicePage.chooseContactOption(Integer.parseInt(customerChoose));
        cuctomerServicePage.enterEmailAddress(validUsername);
        cuctomerServicePage.clickOnOrderReferenceBox();
        cuctomerServicePage.selectOrderReference(Integer.parseInt(orderReference));
        cuctomerServicePage.clickOnselectProduct();
        cuctomerServicePage.selectProductSummary(Integer.parseInt(orderSummary));
        cuctomerServicePage.clickOnAttachFieldBox();
        cuctomerServicePage.clickOnMessageField(message);
        cuctomerServicePage.clickOnSubmitBtn();

    }
}