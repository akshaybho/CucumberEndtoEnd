package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = ".//Features",
                 glue = "stepDefinition",
                  monochrome = true,
                 dryRun = false,
                   tags = "@PlaceOrder or @OffersPage",
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failed_scenarios.txt"}
)
public class Runner extends AbstractTestNGCucumberTests {

   /* @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }*/
}
