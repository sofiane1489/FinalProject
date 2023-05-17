//package us.piit.automation;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import us.piit.base.CommonAPI;
//
//public class UserLogin extends CommonAPI {
//    Logger log = LogManager.getLogger(UserLogin.class.getName());
//
//    @Test
//    public void validCredentials() {
//        // Verify the title of the page
//        String expectedTitle = "Automation Exercise";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        // Enter Email, password, and click on login button
//        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
//        type("//input[@type='email']", "adam2023@outlook.com");
//        log.info("enter email success");
//        type("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]", "Adana2023#");
//        log.info("enter password success");
//        clickOn("//button[contains(text(),'Login')]");
//        log.info("click on login button Success");
//        waitFor(5);
//
//        // Check if user is logged in
//        String expectedHomePageHeader = "Full-Fledged practice website for Automation Engineers";
//        String actualHomePageHeader = getElementText("div.container div.row div.col-sm-12 div.carousel.slide div.carousel-inner div.item.active:nth-child(1) div.col-sm-6:nth-child(1) > h2:nth-child(2)");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        log.info("user logged in success");
//    }
//    @Test
//    public void invalidemail() {
//        // verify the title of the homepage
//        String expectedTitle = "Automation Exercise";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//
//        // Clickon signin,enter  email, password, and click on login button
//        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
//        type("//input[@type='email']", "adam2023@outlook.comhgf");
//        log.info("enter email success");
//        type("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]", "Adana2023#");
//        log.info("enter password success");
//        clickOn("//button[contains(text(),'Login')]");
//        log.info("click on login button Success");
//        waitFor(4);
//
//        //validate the error message
//        String expectedError = "Your email or password is incorrect!";
//        String actualError = getElementText("//p[contains(text(),'Your email or password is incorrect!')]");
//        Assert.assertEquals(expectedError, actualError);
//        log.info("validate error success");
//    }
//    @Test
//    public void invalidPassword (){
//        String expectedTitle = "Automation Exercise";
//        String actualTitle = getCurrentTtile();
//        Assert.assertEquals(expectedTitle, actualTitle);
//        //clickon signin,enter  email, password, and click on login button
//        clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]");
//        log.info("click on login success");
//        type("//input[@type='email']", "adam2023@outlook.com");
//        log.info("enter email success");
//        type("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]", "adcd123");
//        log.info("enter password success");
//        clickOn("//button[contains(text(),'Login')]");
//        log.info("click on login button Success");
//        waitFor(4);
//
//        //validate the error message
//        String expectedError = "Your email or password is incorrect!";
//        String actualError = getElementText("//p[contains(text(),'Your email or password is incorrect!')]");
//        Assert.assertEquals(expectedError, actualError);
//        log.info("validate error success");
//    }
//}
//
//
//
//
