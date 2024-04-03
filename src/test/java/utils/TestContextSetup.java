package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public String laningPageproductName;
    public PageObjectManager po;
    public TestBase testBase;
    public GenericUtils genericUtils;
    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        po = new PageObjectManager(testBase.WebDriverManager());
        genericUtils = new GenericUtils(testBase.WebDriverManager());
    }
}
