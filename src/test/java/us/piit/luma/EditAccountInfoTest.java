package us.piit.luma;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class EditAccountInfoTest extends SetUp {
    Logger log= LogManager.getLogger(EditAccountInfoTest.class.getName());
    @Test
    public void editAccountInfo(){
        // website validation with luma logo
        boolean actualTitle=isVisible("//a[@aria-label='store logo']//img");
        Assert.assertTrue(actualTitle);
        log.info("landed on luma home page success");

        clickOn("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");
        log.info("click on sign in success");

        type("#email","Alpha@gmail.com");
        log.info("email enter success");

        type("#pass","abcd1234$");
        log.info("password enter success");

        clickOn("#send2");
        log.info("click on sign in success");

        //validate user logged in
        //validate the dropdown visibility
        boolean actualresultVisible=isVisible(".panel.header ul li:nth-child(2) span button");
        Assert.assertTrue(actualresultVisible);
        log.info("it is visible success");

        //validate the dropdown interactivity
        boolean actualResultInteractable=isInteractable(".panel.header ul li:nth-child(2) span button");
        Assert.assertTrue(actualResultInteractable);
        log.info("it is interactable success");

        clickOn(".panel.header ul li:nth-child(2) span button");
        log.info("click on drop down list success");

        clickOn("//div[@aria-hidden='false']//a[normalize-space()='My Account']");
        log.info("click on My Account success");

        clickOn("//a[@href='https://magento.softwaretestingboard.com/customer/account/edit/']//span[contains(text(),'Edit')]");
        log.info("click on edit success");

        doubleClick("//input[@id='lastname']");
        log.info("double click on last name field success");

        delete("//input[@id='lastname']");
        log.info("delete element success");

        type("//input[@id='lastname']","doe");
        log.info("type last name success");

        clickOn("button[title='Save'] span");
        log.info("click on save button success");

        String expectedMess="You saved the account information.";
        String actualMess=getElementText("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']");
        Assert.assertEquals(expectedMess,expectedMess);
        log.info("account edit success");
    }

}

