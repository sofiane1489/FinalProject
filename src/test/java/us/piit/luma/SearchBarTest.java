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
          typeEnter("#search","bag pack for man");
              log.info("type and hit enter text success");

        //search result validation
        boolean expectedPageWraperTitle=true;
        boolean actualPageWraperTitle=isVisible("#maincontent div h1 span");
        Assert.assertEquals(actualPageWraperTitle,expectedPageWraperTitle);
        log.info("serach bar result success");


       }
}
