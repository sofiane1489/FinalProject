//package us.piit.automation;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//
//public class CheckOutConfirme extends CommonAPI {
//    Logger log = LogManager.getLogger(CheckOutConfirme.class.getName());
//
//    @Test
//    public void checkout() {
//
//        //Enter Email, password, and click on login button
//        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
//        type("//input[@type='email']", "adam20023@outlook.com");
//        log.info("enter email success");
//        type("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]", "Adana2023#");
//        log.info("enter password success");
//        clickOn("//button[contains(text(),'Login')]");
//        log.info("click on login button Success");
//        waitFor(1);
//
//        // Check user is logged in
//        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
//        String actualHomePageHeader = getElementText("div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("user logged in success");
//
//        //click on cart,proceed to checkout,place order and confirm
//        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/i[1]");
//        log.info("click on shooping cart success");
//
//        clickOn("//a[contains(text(),'Proceed To Checkout')]");
//        log.info("checkout proceed success");
//
//        clickOn("//a[contains(text(),'Place Order')]");
//        log.info("place order success");
//
//        type("//body/section[@id='cart_items']/div[1]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]","adam izem");
//        log.info("type name success");
//
//        type(".form-control.card-number","123456789");
//        log.info("type card number success");
//
//        type(".form-control.card-cvc","098");
//        log.info("cvs enter success");
//
//        type(".form-control.card-expiry-month","11");
//        log.info("expiry-month enter success");
//
//        type(".form-control.card-expiry-year","2027");
//        log.info("expiry-year enter success");
//
//        clickOn("#submit");
//        log.info("pay and confirm order success");
//
//
//        // validate the payment of the product
//        String expectedtext="Congratulations! Your order has been confirmed!";
//        String actualtext=getElementText("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
//        Assert.assertEquals(expectedtext,actualtext);
//        log.info("order pay and confirm success");
//
//    }
//}
