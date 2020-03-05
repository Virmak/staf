package com.sparkit.staf.runtime.libs.builtin.selenium;

import com.sparkit.staf.ast.types.AbstractStafObject;
import com.sparkit.staf.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.runtime.libs.annotations.Keyword;
import com.sparkit.staf.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.runtime.libs.builtin.selenium.exceptions.NoBrowserOpenedException;
import com.sparkit.staf.runtime.libs.builtin.selenium.exceptions.UnsupportedBrowserDriverException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {
    private WebDriver webDriver;

    @Keyword(name = "open browser")
    public void openBrowser(AbstractStafObject browser) throws UnsupportedBrowserDriverException {
        String browserString = browser.getValue().toString();
        System.out.println("open browser : " + browserString);
        if (browserString.equals("chrome")) {
            webDriver = new ChromeDriver();
        } else if (browserString.equals("firefox"))  {
            webDriver = new FirefoxDriver();
        } else {
            throw new UnsupportedBrowserDriverException(browserString);
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Keyword(name = "close browser")
    public void closeBrowser() {
        webDriver.close();
    }

    @Keyword(name = "input text")
    public void input(@KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).sendKeys(value.getValue().toString());
    }

    @Keyword(name = "click element")
    public void clickButton(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).click();
    }

    @Keyword(name = "input value")
    public String getInputValue(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return webDriver.findElement(elementSelector).getAttribute("value");
    }

    @Keyword(name = "capture page screenshot")
    public void captureScreenshot(AbstractStafObject filename) {
        System.out.println("taking screenshot -- not implemented");
    }

    @Keyword(name = "wait until element is visible")
    public void waitUntilElementIsVisible(AbstractStafObject selector, AbstractStafObject timeout) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, (Integer)timeout.getValue());
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
        } else {
            webDriver.findElement(elementSelector);
        }
    }

    @Keyword(name = "go to")
    public void gotToUrl(@KeywordArgument AbstractStafObject url) throws NoBrowserOpenedException {
        try {
            webDriver.get(url.getValue().toString());
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
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
}
