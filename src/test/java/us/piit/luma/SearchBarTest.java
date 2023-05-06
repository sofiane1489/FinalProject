package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class SearchBarTest extends SetUp {
    Logger log= LogManager.getLogger(SearchBarTest.class.getName());

       @Test
    public void searchTest(){
           // website validation
           String expectedTitle="Home Page";
           String actualTitle=getCurrentTtile();
           Assert.assertEquals(expectedTitle,actualTitle);
           log.info("landed on luma home page success");

           typeEnter("#search","bag pack for man");
              log.info("type and hit enter text success");

        //search result validation
        boolean expectedPageWraperTitle=true;
        boolean actualPageWraperTitle=isVisible("#maincontent div h1 span");
        Assert.assertEquals(actualPageWraperTitle,expectedPageWraperTitle);
             log.info("serach bar result success");
       }
}
