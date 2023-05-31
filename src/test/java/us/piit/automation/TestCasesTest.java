package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.automationPages.HomePage;
import us.piit.automationPages.TestCasespage;
import us.piit.base.CommonAPI;





public class TestCasesTest extends CommonAPI {
    Logger log= LogManager.getLogger(TestCasesTest.class.getName());

    @Test
    public void testCaseTest(){
        HomePage homePage=new HomePage(getDriver());
        TestCasespage testCasespage=new TestCasespage(getDriver());

        //verify the title of the homepage is displayed
        String expectedTitle = "Automation Exercise";
        String actualTitle =getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on test cases button
        homePage.clickontestcases();
        waitFor(4);

        // verify test case title is visible
        boolean expectedtitle5 =true;
        boolean actualtitle5=testCasespage.gettitle5();
                Assert.assertEquals(expectedtitle5,actualtitle5);









    }
}
