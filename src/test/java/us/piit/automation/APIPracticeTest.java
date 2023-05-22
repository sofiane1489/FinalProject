
package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.API_ListPage;
import us.piit.automationPages.HomePage;
import us.piit.base.CommonAPI;
import us.piit.utility.Utility;
import java.util.Properties;

public class APIPracticeTest extends CommonAPI {
    Logger log = LogManager.getLogger(APIPracticeTest.class.getName());
    Properties pop= Utility.loadProperties();

    @Test
    public void apiPracticeTest(){
        HomePage homePage = new HomePage(getDriver());
        API_ListPage apiListPage=new API_ListPage(getDriver());

        // click on API Testing
        homePage.clickonAPITesting();
        apiListPage.getRedText();
        apiListPage.clickonhomePage();

        // Verify the title of the page
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();

       Assert.assertEquals(expectedTitle,actualTitle);



    }

}
