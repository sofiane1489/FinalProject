package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;

public class RemoveItemsFromCart extends CommonAPI {
    Logger log = LogManager.getLogger(RemoveItemsFromCart.class.getName());

    @Test
    public void removeItem(){
        // verify the title of the homepage
        String expectedTitle = "Automation Exercise";
        String actualTitle = getCurrentTtile();
        Assert.assertEquals(expectedTitle, actualTitle);

        //Enter Email, password, and click on login button
        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
        type("//input[@type='email']", "adam20023@outlook.com");
        log.info("enter email success");
        type("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]", "Adana2023#");
        log.info("enter password success");
        clickOn("//button[contains(text(),'Login')]");
        log.info("click on login button Success");
        waitFor(1);

        // Check if user is logged in
        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
        String actualHomePageHeader = getElementText("div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

        clickOn("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]");
        log.info("add to cart success");

        clickOn("//u[contains(text(),'View Cart')]");
        log.info("click on view cart  success");

        clickOn("//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
        log.info("clickon shooping cart success");
        clickOn(".cart_delete");
        log.info("delete product success");

        // validate that product is deleted
        String expectedText="";
        String actualText=getElementText("//b[contains(text(),'Cart is empty!')]");
        Assert.assertEquals(expectedText,actualText);











    }
}
