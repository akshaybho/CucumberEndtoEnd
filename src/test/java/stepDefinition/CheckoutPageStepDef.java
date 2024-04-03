package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDef {
    TestContextSetup testContextSetup;

    PageObjectManager po;
    public CheckoutPageStepDef(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }
    CheckoutPage cp;
    String landingPageProduct;
    @Given("^User search a product (.+) and check actual name of product$")
    public void user_search_a_product_tom_and_check_actual_name_of_product(String shortName) throws InterruptedException
    {
       cp = testContextSetup.po.getCheckoutPage();
       cp.searchItem(shortName);
       Thread.sleep(2000);
       landingPageProduct = cp.getSearchProductName();
       Assert.assertEquals(landingPageProduct, "Tomato - 1 Kg");

    }
    @Then("Add more number of same product")
    public void add_more_number_of_same_product() throws InterruptedException {
        cp.addMore();
        Thread.sleep(2000);
    }
    @Then("Click on add to cart")
    public void click_on_add_to_cart() throws InterruptedException {
        cp.clickOnAddToCart();
        Thread.sleep(2000);
    }
    @Then("Go to basket")
    public void go_to_basket() throws InterruptedException {
        cp.clickOnBasket();
        Thread.sleep(2000);
    }
    @Then("Click on proceed to checkout")
    public void click_on_procedd_to_checkout() throws InterruptedException {
        cp.clickOnProceed();
        Thread.sleep(2000);
    }
    @Then("Validate the product name on cart page")
    public void validate_the_product_name_on_cart_page() {
        Assert.assertEquals(cp.getProductName(), landingPageProduct);
    }
    @Then("Validate Apply and Place Order button is displayed")
    public void validate_apply_and_place_order_button_is_displayed() throws InterruptedException {
        cp.checkISDisplayed();
    }
}
