package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.ElementShouldBeVisibleNotFoundException;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.ElementShouldContainException;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.NoBrowserOpenedException;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.UnsupportedBrowserDriverException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {
    private Stack<WebDriver> webDrivers = new Stack<>();

    @Keyword(name = "open browser")
    public void openBrowser(AbstractStafObject browser) throws UnsupportedBrowserDriverException {
        String browserString = browser.getValue().toString();
        System.out.println("open browser : " + browserString);
        if (browserString.equals("chrome")) {
            webDrivers.push(new ChromeDriver());
        } else if (browserString.equals("firefox")) {
            webDrivers.push(new FirefoxDriver());
        } else {
            throw new UnsupportedBrowserDriverException(browserString);
        }
        webDrivers.peek().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Keyword(name = "close browser")
    public void closeBrowser() {
        try {
            webDrivers.peek().close();
        } catch (NullPointerException ignored) {
        }
    }

    @Keyword(name = "close browsers")
    public void closeBrowsers() {
        for (WebDriver webDriver : webDrivers) {
            webDriver.close();
        }
    }

    @Keyword(name = "input text")
    public void input(@KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDrivers.peek().findElement(elementSelector).sendKeys(value.getValue().toString());
    }

    @Keyword(name = "click element")
    public void clickButton(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDrivers.peek().findElement(elementSelector).click();
    }

    @Keyword(name = "input value")
    public String getInputValue(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return webDrivers.peek().findElement(elementSelector).getAttribute("value");
    }

    @Keyword(name = "capture screenshot")
    public void captureScreenshot(AbstractStafObject filename) throws IOException {
        WebDriver augmentedDriver = new Augmenter().augment(webDrivers.peek());
        File SrcFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + "/" + filename.getValue());
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Keyword(name = "wait until element is visible")
    public void waitUntilElementIsVisible(AbstractStafObject selector, AbstractStafObject timeout)
            throws ElementShouldBeVisibleNotFoundException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDrivers.peek(), (Integer) timeout.getValue());
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
        } else {
            List<WebElement> elements = webDrivers.peek().findElements(elementSelector);
            if (elements.size() == 0) {
                throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
            }
        }
    }

    @Keyword(name = "wait until element is enabled")
    public void waitUntilElementIsEnabled(AbstractStafObject selector, AbstractStafObject timeout) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDrivers.peek(), (Integer) timeout.getValue());
            wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        } else {
            webDrivers.peek().findElement(elementSelector);
        }
    }

    @Keyword(name = "element should be visible")
    public void elementShouldBeVisible(AbstractStafObject selector) throws ElementShouldBeVisibleNotFoundException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        List<WebElement> elementList = webDrivers.peek().findElements(elementSelector);
        if (elementList.size() == 0) {
            throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
        }
    }

    @Keyword(name = "element should contain", doc = "Verifies that element 'locator' contains text expected.")
    public void elementShouldContain(AbstractStafObject selector, AbstractStafObject expected, AbstractStafObject message)
            throws ElementShouldContainException {
        By elementSelector = By.xpath("//*[contains(text(),'" + expected.getValue() + "')]");
        List<WebElement> elementList = webDrivers.peek().findElements(elementSelector);
        if (elementList.size() == 0) {
            if (message != null) {
                throw new ElementShouldContainException(message.getValue().toString());
            } else {
                throw new ElementShouldContainException("Could not find element that contains '" + expected + "'");
            }
        }
    }

    @Keyword(name = "go to")
    public void gotToUrl(@KeywordArgument AbstractStafObject url) throws NoBrowserOpenedException {
        try {
            webDrivers.peek().get(url.getValue().toString());
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    private By getLocatorFromString(String selector) {
        String selectorType = selector.substring(0, selector.indexOf(':'));
        String selectorValue = selector.substring(selectorType.length() + 1);

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
