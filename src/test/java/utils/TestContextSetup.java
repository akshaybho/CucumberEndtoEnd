package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;

    public String laningPageproductName;

    public PageObjectManager po;

    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup()
    {
        testBase = new TestBase();
        po = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
