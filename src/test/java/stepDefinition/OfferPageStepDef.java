package stepDefinition;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;
import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDef {
    TestContextSetup testContextSetup;
    public String  offerPageproductname;
    public PageObjectManager po;
    public OfferPageStepDef(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }
    @Then("^User go and search for (.+) shortname in offers page$")
    public void user_go_and_search_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {

        OffersPage of = testContextSetup.po.getOffersPage();
        switchToOffersPage();
        of.searchItem(shortName);
        Thread.sleep(2000);
        offerPageproductname = of.getProductName();
    }
    public void switchToOffersPage()
    {
        //po = new PageObjectManager(testContextSetup.driver);
        //lp = new LandingPage(testContextSetup.driver);
        LandingPage lp = testContextSetup.po.getLandingPage();
        lp.topDealPage();
        testContextSetup.genericUtils.switchToChildWindow();
    }
    @Then("validate product name in offers page matches with landing page")
    public void validate_product_name_in_Offers_page()
    {
        Assert.assertEquals(offerPageproductname, testContextSetup.laningPageproductName);
    }

}
