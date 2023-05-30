package stepDef;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class SearchBarStepDef{
    SetUp setUp;

    public SearchBarStepDef(SetUp setUp){
        this.setUp=setUp;
    }

    @Given("user navigates to luma url {string}")
    public void i_navigate_to_orange_url(String url) {
        setUp.driver.get(url);
    }

    @Then("user should see title {string} and luma logo should be present")
    public void i_should_see_title(String title) {
        Assert.assertEquals(setUp.driver.getTitle(),title);
        Assert.assertTrue(setUp.driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1678540400/frontend/Magento/luma/en_US/images/logo.svg']")).isDisplayed());

    }
    @And("i type  product name {string} in the search bar")
    public void i_type_product_name_in_the_search_bar(String text) {
        setUp.driver.findElement(By.cssSelector("#search")).sendKeys(text, Keys.ENTER);
    }
    @Then("i should get the search result {string}")
    public void i_should_get_the_search_result(String searchResult) {
        Assert.assertEquals(setUp.driver.findElement(By.cssSelector(".base")).getText(),searchResult);

    }

}
