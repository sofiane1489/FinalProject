package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class AddItemsToCart extends CommonAPI {
    Logger log = LogManager.getLogger(AddItemsToCart.class.getName());

//    @Test
//    public void menTisherts() {
//
//        // click on view item, add to cart then proceed to checkout
//        clickOn("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]");
//        log.info("click on view product success");
//
//        clickOn("//body/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/button[1]");
//        log.info("click on add to cart  success");
//
//        clickOn("//u[contains(text(),'View Cart')]");
//        log.info("click on view cart  success");
//
//        clickOn("//a[contains(text(),'Proceed To Checkout')]");
//        log.info("proceed to checkout");
//        waitFor(1);
//
//        // validate text
//        String expectedTitle = "Automation Exercise - Checkout";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//
//    }
}
