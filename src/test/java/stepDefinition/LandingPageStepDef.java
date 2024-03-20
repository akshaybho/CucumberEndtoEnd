package stepDefinition;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;
import utils.TestContextSetup;



public class LandingPageStepDef {

    LandingPage lp;
    TestContextSetup testContextSetup;
    public String laningPageproductName;

    public LandingPageStepDef(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
        WebDriverManager.chromedriver().setup();
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.driver.manage().window().maximize();

    }
    @When("User searched with Shortname {string} and extract actual name of product")
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {

        lp = new LandingPage(testContextSetup.driver);
        lp.searchItem(shortName);

        Thread.sleep(2000);

        testContextSetup.laningPageproductName = lp.getProductName().split("-")[0].trim();
        System.out.println(laningPageproductName+" is extracted from homepage");

    }

}
