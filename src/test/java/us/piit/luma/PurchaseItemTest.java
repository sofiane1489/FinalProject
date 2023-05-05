package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;
public class PurchaseItemTest extends SetUp {
    Logger log= LogManager.getLogger(PurchaseItemTest.class.getName());

    @Test
    public void purchaseItem(){
        hoverOver("#ui-id-6");
            log.info("hover over Gear success");
        clickOn("#ui-id-26");
           log.info("click on Fitness Equipment success");
        clickOn(".item.product.product-item:nth-child(6) div a span span");
            log.info("click on item Band success");
       clickOn("#product-addtocart-button");
            log.info("click on add to cart button success");

       //add to cart validation
       String expextedText="You added Quest Lumaflex™ Band to your shopping cart.";
       String actualText=getElementText("div[role='alert']");
        Assert.assertEquals(actualText,expextedText);
            log.info("item added to cart success");

      //navigate to cart
        clickOn("div[data-bind='html: $parent.prepareMessageForHtml(message.text)'] a");
             log.info("click on shopping cart success");
        clickOn("button[title='Proceed to Checkout'] span");
           log.info("click on proceed to checkout  cart success");
      type("//div[@class='control _with-tooltip']//input[@id='customer-email']","item@gmail.com");
           log.info("type email success");

       type("//input[@name='firstname']","lu");
        log.info("type first name success");

        type("//input[@name='lastname']","ma");
          log.info("type last name success");

        type("//input[@name='company'] ","luma");
        log.info("type company name success");

        type(" //input[@name='street[0]'] ","1234 broad st");
        log.info("type street address success");

        type("//input[@name='city']","San Diego");
        log.info("type city success");

       selectBy("select[name='region_id']","California");

        type("//input[@name='postcode']","12345");
        log.info("type postcode success");

        type("//input[@name='telephone']","0123456789");
        log.info("type phone number success");

        clickOn("//input[@name='ko_unique_1']");
        log.info("selcect Shipping Methods success");

        clickOn("//span[text()='Next']");
        log.info("click on next success");

         waitFor(3);
         clickOn("//button[@title='Place Order']");

          log.info("click on place order success");

         //purchase validation
        String expectedMessage="Thank you for your purchase!";
        String actualMessage=getElementText("//span[text()='Thank you for your purchase!']");
        Assert.assertEquals(actualMessage,expectedMessage);
        log.info("purchase validation success");

    }
}
