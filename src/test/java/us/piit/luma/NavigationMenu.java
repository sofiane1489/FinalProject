package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class NavigationMenu extends SetUp {
    Logger log= LogManager.getLogger(NavigationMenu.class.getName());

    @Test
    public void navigationMenu(){

        boolean actual1= isVisible("//ul[@id='ui-id-2']");
        Assert.assertTrue(actual1);
        log.info("navigate menu is visible");

        boolean actual= isInteractable("//ul[@id='ui-id-2']");
        Assert.assertTrue(actual);
        log.info("navigate menu is interactable");
    }
}
