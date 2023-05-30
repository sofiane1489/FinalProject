package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ShareWishListStepDef {

    SetUp setUp;

    public ShareWishListStepDef(SetUp setUp){
        this.setUp=setUp;
    }


    @Then("user clicks on Go to Wish List link")
    public void user_clicks_on_go_to_wish_list_link() {
         setUp.driver.findElement(By.cssSelector(".block.block-wishlist div:nth-child(2) div.actions-toolbar div a")).click();
    }
    @Then("user clicks on Share Wish List link")
    public void user_clicks_on_share_wish_list_link(){
        WebElement element=setUp.driver.findElement(By.cssSelector(".base"));
        setUp.scrollToElement(setUp.driver,element);
        setUp.clickWithJavascript(setUp.driver,setUp.driver.findElement(By.cssSelector(".action.share")));
    }
    @Then("user enters email Address {string}")
    public void user_enters_email_address(String email) {
         setUp.driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
    }
    @Then("type a message {string}")
    public void type_a_message(String message) {
        setUp.driver.findElement(By.cssSelector("#message")).sendKeys(message);
    }

    @And("user clicks on Share Wish List button")
    public void user_clicks_on_share_wish_list_button() {
         WebElement element=setUp.driver.findElement(By.cssSelector("#email_address"));
         setUp.scrollToElement(setUp.driver,element);
         setUp.driver.findElement(By.cssSelector(".action.submit.primary")).click();
    }

    @Then("user gets a confirmation message {string}")
    public void user_gets_a_confirmation_message(String confirmationMessage) {
         Assert.assertEquals(setUp.driver.findElement(By.cssSelector(".page.messages")).getText(),confirmationMessage);
    }
}
