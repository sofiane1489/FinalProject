package stepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ReorderPreviousOrderStepDef {

    SetUp setUp;

    public ReorderPreviousOrderStepDef(SetUp setUp){
        this.setUp=setUp;
    }

    @Then("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {
    setUp.driver.findElement(By.cssSelector("body div.page-wrapper header div.panel.wrapper div ul li.authorization-link a")).click();
    }

    @Then("user enter email address {string}")
    public void user_enter_email_address(String email) {
     setUp.driver.findElement(By.cssSelector("#email")).sendKeys(email);
    }

    @Then("user enter password {string}")
    public void user_enter_password(String password) {
     setUp.driver.findElement(By.cssSelector("input[name='login[password]']")).sendKeys(password);
    }

    @Then("user clicks on login in button")
    public void user_clicks_on_login_in_button() {
    setUp.driver.findElement(By.cssSelector(".action.login.primary")).click();
    }

    @Then("user clicks on the upper right corner dropdown")
    public void user_slicks_on_the_upper_right_corner_dropdown() {
    setUp.driver.findElement(By.cssSelector("body div.page-wrapper header div.panel.wrapper div ul li.customer-welcome span button")).click();
    }

    @Then("user clicks on My Account")
    public void user_clicks_on_my_account() {
    setUp.driver.findElement(By.cssSelector("body div.page-wrapper header  div.panel.wrapper div ul li.customer-welcome.active div ul li:nth-child(1)")).click();
         }

    @Then("user clicks on the reorder link associated with a specific order that needs to be reordered.")
    public void user_clicks_on_the_reorder_link_associated_with_a_specific_order_that_needs_to_be_reordered() {
    WebElement element=setUp.driver.findElement(By.cssSelector("#my-orders-table tbody   tr:nth-child(1) td.col.actions a.action.order"));
    setUp.scrollToElement(setUp.driver,element);
    setUp.driver.findElement(By.cssSelector("#my-orders-table tbody   tr:nth-child(1) td.col.actions a.action.order")).click();
    }

    @Then("user clicks on proceed to checkout button")
    public void user_clicks_on_proceed_to_checkout_button() {
      setUp.driver.findElement(By.cssSelector(".cart-summary ul li button ")).click();
    }

    @When("user selects a shipping method and clicks on next")
    public void user_selects_a_shipping_method_and_clicks_on_next() {
    setUp.driver.findElement(By.cssSelector("#checkout-shipping-method-load table.table-checkout-shipping-method tbody tr:nth-child(1) td input ")).click();
    setUp.driver.findElement(By.cssSelector(".button.action.continue.primary")).click();
    }

    @When("user clicks on place order")
    public void user_clicks_on_place_order() throws InterruptedException {
    setUp.waitFor(2);
    setUp.driver.findElement(By.cssSelector(".action.primary.checkout")).click();
    }

    @Then("user should sees thanks message {string}")
    public void user_should_sees_thanks_message_and_order_number(String thanksMessage) throws InterruptedException {
    setUp.waitFor(2);
    Assert.assertEquals(setUp.driver.findElement(By.cssSelector(".page-title")).getText(),thanksMessage);
    }

}
