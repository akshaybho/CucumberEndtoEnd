package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@type='search']")
    WebElement search;
    @FindBy(css = "h4.product-name")
    WebElement productName;
    @FindBy(css = "a.increment")
    WebElement incrementBtn;
    @FindBy(xpath = "//button[contains(text(), 'ADD TO CART')]")
    WebElement addToCartBtn;
    @FindBy(css = "a.cart-icon")
    WebElement basketBtn;
    @FindBy(xpath = "//button[contains(text(), 'PROCEED TO CHECKOUT')]")
    WebElement proceedBtn;
    @FindBy(xpath = "//table/tbody/tr/td[2]")
    WebElement productNameOnCart;
    @FindBy(xpath = "(//button)[1]")
    WebElement ApplyBtn;
    @FindBy(xpath = "(//button)[2]")
    WebElement placeOrderBtn;
    public void searchItem(String name)
    {
        search.sendKeys(name);
    }
    public String getSearchProductName()
    {
        return productName.getText();
    }
    public void addMore() throws InterruptedException {
        for(int i=0; i<5; i++)
        {
            incrementBtn.click();
            Thread.sleep(2000);
        }
    }
    public void clickOnAddToCart()
    {
        addToCartBtn.click();
    }
    public void clickOnBasket()
    {
        basketBtn.click();
    }
    public void clickOnProceed()
    {
        proceedBtn.click();
    }
    public String getProductName()
    {
        return productNameOnCart.getText();
    }
    public boolean checkISDisplayed() throws InterruptedException {
        ApplyBtn.isDisplayed();
        Thread.sleep(2000);
        placeOrderBtn.isDisplayed();
        return true;
    }
}
