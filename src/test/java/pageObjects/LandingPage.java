package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  {

    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    WebElement search;

    @FindBy(css = "h4.product-name")
    WebElement productName;

    @FindBy(linkText = "Top Deals")
    WebElement topDeal;

    public void searchItem(String name)
    {
        search.sendKeys(name);
    }

    public String getProductName()
    {
        return productName.getText();
    }

    public void topDealPage()
    {
        topDeal.click();
    }


}
