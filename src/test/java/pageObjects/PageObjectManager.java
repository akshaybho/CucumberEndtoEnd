package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    public CheckoutPage cp;
    public OffersPage op;
    public WebDriver driver;
    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }
    public LandingPage lp;
    public LandingPage getLandingPage()
    {
        lp = new LandingPage(driver);
        return lp;
    }
    public OffersPage getOffersPage()
    {
        op = new OffersPage(driver);
        return op;
    }
    public CheckoutPage getCheckoutPage()
    {
        cp = new CheckoutPage(driver);
        return cp;
    }
}
