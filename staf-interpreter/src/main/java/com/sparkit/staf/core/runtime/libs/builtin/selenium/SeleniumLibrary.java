package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.*;
import com.sparkit.staf.core.runtime.libs.exceptions.InvalidSelectorException;
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

    private void setDefaultTimeout() {
        webDrivers.peek().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
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
        setDefaultTimeout();
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
        @Keyword(name = "maximize browser window", doc = "Maximize current browser window")
    public void maximizeWindow(@KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        webDrivers.peek().manage().window().maximize();
    }

    @Keyword(name = "press key", doc = "Simulates the user pressing key to an element")
    public void pressKey(@KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        WebElement element;
        String locator;
        if (value == null) {
            value = selector;
            locator = "tag:body";
        } else {
            locator = value.getValue().toString();
        }
        By elementSelector = getLocatorFromString(locator);
        element = webDrivers.peek().findElement(elementSelector);
        switch (value.getValue().toString()) {
            case "Escape":
                element.sendKeys(Keys.ESCAPE);
                break;
            case "Enter":
                element.sendKeys(Keys.ENTER);
                break;
        }
    }

    @Keyword(name = "input text", doc = "Types the given text into text field identified by locator")
    public void input(@KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDrivers.peek().findElement(elementSelector);
        element.clear();
        element.sendKeys(value.getValue().toString());
    }

    @Keyword(name = "click element", doc = "Click element by locator")
    public void clickButton(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDrivers.peek().findElement(elementSelector).click();
    }

    @Keyword(name = "set focus to element", doc = "Focus element by locator")
    public void setFocus(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDrivers.peek().findElement(elementSelector).sendKeys("");
    }


    @Keyword(name = "input value")
    public StafString getInputValue(@KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafString(webDrivers.peek().findElement(elementSelector).getAttribute("value"));
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

    @Keyword(name = "page should contain element", doc = "Verifies that page contains and element 'locator'")
    public void pageShouldContainElement(AbstractStafObject selector)
            throws ElementShouldContainException {
        By elementSelector =getLocatorFromString(selector.getValue().toString());
        if (webDrivers.peek().findElements(elementSelector).size() == 0) {
            throw new PageShouldContainException();
        }
    }

    @Keyword(name = "get element count", doc = "Returns the number of elements matching 'locator'")
    public StafInteger getElementCount(AbstractStafObject selector)
            throws ElementShouldContainException {
        By elementSelector =getLocatorFromString(selector.getValue().toString());
        return new StafInteger(webDrivers.peek().findElements(elementSelector).size());
    }

    @Keyword(name = "go to")
    public void gotToUrl(@KeywordArgument AbstractStafObject url) throws NoBrowserOpenedException {
        try {
            webDrivers.peek().get(url.getValue().toString());
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    @Keyword(name = "get element attribute")
    public StafString getElementAttribute(AbstractStafObject selector, AbstractStafObject attributeName) throws NoBrowserOpenedException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        try {
            WebElement element = webDrivers.peek().findElement(elementSelector);
            return new StafString(element.getAttribute(attributeName.getValue().toString()));
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    private By getLocatorFromString(String selector) {
        String selectorType = "";
        try {
            selectorType = selector.substring(0, selector.indexOf(':'));
        } catch (Exception e) {
            throw new InvalidSelectorException("Invalid selector : " + selector);
        }
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
                throw new InvalidSelectorException("Invalid selector : " + selector);
        }
    }
}
