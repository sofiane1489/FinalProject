package us.piit.lumaPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.piit.base.CommonAPI;

public class HomePage extends CommonAPI {
    Logger log= LogManager.getLogger(HomePage.class.getName());

    String actualMessage="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, mike lee!']";

    public String getWelcomeMessage(){
      String message= getElementText(actualMessage);
        log.info("login success");
        return message;
    }
}
