package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"stepDef"},
       //  tags = "@zoom",
        plugin={"summary","pretty","html:target/Reports/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//the console output will be displayed in a more readable format without additional formatting or colors.
        monochrome = true,
        dryRun=false
)
public class Runner extends AbstractTestNGCucumberTests {
}


