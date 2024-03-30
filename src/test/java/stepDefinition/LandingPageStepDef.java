package stepDefinition;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;



public class LandingPageStepDef {

    public PageObjectManager po;
    LandingPage lp;
    TestContextSetup testContextSetup;
    public String laningPageproductName;

    public LandingPageStepDef(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {


    }
    @When("^User searched with Shortname (.+) and extract actual name of product$")
    public void user_searched_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {

        lp = testContextSetup.po.getLandingPage();
        lp.searchItem(shortName);

        Thread.sleep(2000);

        testContextSetup.laningPageproductName = lp.getProductName().split("-")[0].trim();
        System.out.println(laningPageproductName+" is extracted from homepage");

    }

}
