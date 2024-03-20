package stepDefinition;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDef {

    OffersPage of;

    LandingPage lp;
    TestContextSetup testContextSetup;

    public String  offerPageproductname;


    public OfferPageStepDef(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

    @Then("User go and search for {string} shortname in offers page")
    public void user_go_and_search_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

        of = new OffersPage(testContextSetup.driver);
        switchToOffersPage();
        of.searchItem(shortName);
        Thread.sleep(2000);
        offerPageproductname = of.getProductName();

    }
    public void switchToOffersPage()
    {
        lp = new LandingPage(testContextSetup.driver);
        lp.topDealPage();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWinodw = i1.next();

        testContextSetup.driver.switchTo().window(childWinodw);
    }

    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_Offers_page()
    {
        Assert.assertEquals(offerPageproductname, testContextSetup.laningPageproductName);
    }

}
