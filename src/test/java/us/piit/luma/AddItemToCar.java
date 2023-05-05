package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class AddItemToCar extends SetUp {
    Logger log= LogManager.getLogger(LoginTest.class.getName());
    @Test
    public void addItem(){
        //website validation
        String expectedTitle="Home Page";
        String actualTitle=getCurrentTtile();
        Assert.assertEquals(expectedTitle,actualTitle);
             log.info("landed on luma home page success");

        clickOn("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");
             log.info("click on sign in success");

        type("#email","so@gmail.com");
            log.info("email enter success");

        type("#pass","1234Abcd$");
             log.info("password enter success");

        clickOn("#send2");
             log.info("click on sign in success");

        //check user logged in
        String expectedWelcomeMess="Welcome, accene lost!";
        String actualWelcomeMess=getElementText("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, accene lost!']");
        Assert.assertEquals(expectedWelcomeMess,actualWelcomeMess);
              log.info("login success");

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
}
