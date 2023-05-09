package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class SearchBarTest extends SetUp {
    Logger log= LogManager.getLogger(SearchBarTest.class.getName());

       @Test
       public void searchTest(){
           // website validation with luma logo
           boolean actualTitle=isVisible("//a[@aria-label='store logo']//img");
           Assert.assertTrue(actualTitle);
           log.info("landed on luma home page success");

           typeEnter("#search","bag pack for man");
           log.info("type text and hit enter success");

        //search result validation
        String expectedPageWraperTitle="Search results for: 'bag pack for man'";
        String actualPageWraperTitle=getElementText("//div[@class='page-title-wrapper']");
        Assert.assertEquals(actualPageWraperTitle,expectedPageWraperTitle);
             log.info("serach bar result success");
       }

}
