package com.sparkit.staf.runtime.libs.builtin.selenium;

import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {
    private WebDriver webDriver;

    @Keyword(name = "open browser")
    public void openBrowser(String browser) throws UnsupportedBrowserDriverException {
        System.out.println("opeennnnnn browser");
        if (browser.equals("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browser.equals("firefox"))  {
            webDriver = new FirefoxDriver();
        } else {
            throw new UnsupportedBrowserDriverException(browser);
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Keyword(name = "close browser")
    public void closeBrowser() {
        webDriver.close();
    }

    @Keyword(name = "input text")
    public void input(@KeywordArgument String selector, @KeywordArgument String value) {
        By elementSelector = getLocatorFromString(selector);
        webDriver.findElement(elementSelector).sendKeys(value);
    }

    @Keyword(name = "click element")
    public void clickButton(@KeywordArgument String selector) {
        By elementSelector = getLocatorFromString(selector);
        webDriver.findElement(elementSelector).click();
    }

    @Keyword(name = "input value")
    public String getInputValue(@KeywordArgument String selector) {
        By elementSelector = getLocatorFromString(selector);
        return webDriver.findElement(elementSelector).getAttribute("value");
    }

    @Keyword(name = "go to")
    public void gotToUrl(@KeywordArgument String url) {
        webDriver.get(url);
    }

    private By getLocatorFromString(String selector) {
        String selectorType = selector.substring(0, selector.indexOf(':'));
        String selectorValue= selector.substring(selectorType.length() + 1);

        switch (selectorType) {
            case "name":
                return By.name(selectorValue);
            case "id":
                return By.id(selectorValue);
            case "css":
                return By.cssSelector(selectorValue);
            case "xpath":
                return By.xpath(selectorValue);
            case "class":
                return By.className(selectorValue);
            case "link":
                return By.linkText(selectorValue);
            case "partial link":
                return By.partialLinkText(selectorValue);
            case "tag":
                return By.tagName(selectorValue);
            default:
                return null;
        }
    }

    @Override
    protected Class<? extends AbstractStafLibrary> getClassName() {
        return SeleniumLibrary.class;
    }
}