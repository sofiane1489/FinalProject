package us.piit.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.SetUp;

public class BuyProduct extends SetUp {
    Logger log= LogManager.getLogger(BuyProduct.class.getName());
  @Test
    public void menTisherts(){
    clickOn("//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]");
    clickOn("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]");
    clickOn("//body/section[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/span[1]/button[1]");
    waitFor(3);


  }
}
