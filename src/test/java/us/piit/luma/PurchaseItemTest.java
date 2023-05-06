package us.piit.luma;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;
public class PurchaseItemTest extends SetUp {
    Logger log= LogManager.getLogger(PurchaseItemTest.class.getName());

    @Test
    public void addItemToCart(){
        // website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
        log.info("landed on luma home page success");

        //click on men section
        clickOn("#ui-id-5 > span:nth-child(2)");
        log.info("click on men section success");
        clickOn("#narrow-by-list2 > dd > ol > li:nth-child(1) > a");
        log.info("click on Top48 success");

        clickOn("//a[@class='product photo product-item-photo']//img[@alt='Cassius Sparring Tank']");
        log.info("click on Cassius Sparring Tank success");
        clickOn("#option-label-size-143-item-167");
        log.info("click on size S success");
        clickOn("#option-label-color-93-item-50");
        log.info("click on color success");
        delete("#qty");
        log.info("delete quantity success");
        type("#qty","4");
        log.info("update quantity success");
        clickOn("#product-addtocart-button");
        log.info("click on add To cart button success");

        //add to car validation
        String expextedText="You added Cassius Sparring Tank to your shopping cart.";
        String actualText=getElementText("//main[@id='maincontent']/div/div[2]/div/div/div");
        Assert.assertEquals(actualText,expextedText);
        log.info("added to cart success");

    }

    @Test
    public void buyProduct(){
        // website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
        log.info("landed on luma home page success");

        hoverOver("#ui-id-6");
            log.info("hover over Gear success");
        clickOn("#ui-id-26");
           log.info("click on Fitness Equipment success");
        clickOn(".item.product.product-item:nth-child(6) div a span span");
            log.info("click on item Band success");
       clickOn("//button[@id='product-addtocart-button']");
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

         //purchase validation:
        String expectedMessage="Thank you for your purchase!";
        String actualMessage=getElementText("//span[text()='Thank you for your purchase!']");
        Assert.assertEquals(actualMessage,expectedMessage);
        log.info("purchase validation success");

    }
}
