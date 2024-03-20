package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {

    WebDriver driver;
    public OffersPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='search']")
    WebElement search;

    @FindBy(css = "tr td:nth-child(1)")
    WebElement productName;

    public void searchItem(String name)
    {
        search.sendKeys(name);
    }

    public String getProductName()
    {
        return productName.getText();
    }

}
