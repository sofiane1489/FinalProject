package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;

import java.util.Properties;

public class AutomationLogoTest extends CommonAPI {
    Logger log = LogManager.getLogger(AutomationLogoTest.class.getName());
    Properties pop = Utility.loadProperties();

    @Test
    public void logoTest(){
        HomePage homePage =new HomePage(getDriver());

        // verify logo website is visible
        boolean expectedLogoText=true;
        boolean actualLogoTest=homePage.getLogoText();
        Assert.assertTrue(actualLogoTest);

    }
}
