//package us.piit.automation;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//
//public class UpdateCart extends CommonAPI {
//    Logger log = LogManager.getLogger(UpdateCart.class.getName());
//
//    @Test
//    public void verificationQuantity() {
//
//        // click on view product button,increase quantity by four,add to cart then view the cart
//        boolean expectresultVisible = true;
//        boolean actualresultVisible = isVisible("div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)");
//        Assert.assertTrue(actualresultVisible);
//        log.info("homepage is visible success");
//        clickOn("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/a[1]");
//        log.info("view product success");
//
//        clickOn("#quantity");
//        type("#quantity","1");
//        log.info("quantity increase by 10 success");
//
//        clickOn("//body/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/button[1]");
//        log.info("click on add to cart  success");
//
//        clickOn("//u[contains(text(),'View Cart')]");
//        log.info("click on view cart  success");
//
//        boolean expectedProductQuantity=true;
//        boolean actualProductQuantityvisibl=isVisible("//button[contains(text(),'11')]");
//        Assert.assertTrue(actualProductQuantityvisibl);
//        log.info("product quantity visibl success");
//        waitFor(3);
//
//
//
//    }
//
//
//}
//
