package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import com.sparkit.staf.core.Main;
import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {
    public static final int DEFAULT_TIMEOUT = 5;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private void setDefaultTimeout(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    @Keyword(name = "open browser")
    public WebDriver openBrowser(AbstractStafObject browser) throws UnsupportedBrowserDriverException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("81.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        RemoteWebDriver selenoidDriver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );
        setDefaultTimeout(selenoidDriver);
        return selenoidDriver;
    }

    @Keyword(name = "close browser")
    public void closeBrowser(WebDriver webDriver) {
        try {
            webDriver.close();
        } catch (NullPointerException ignored) {
        }
    }

    @Keyword(name = "set window size", doc = "Set window size")
    public void setWindowSize(WebDriver webDriver, @KeywordArgument StafInteger width, @KeywordArgument StafInteger height) {
        webDriver.manage().window().setSize(new Dimension((int)width.getValue(), (int)height.getValue()));
    }

    @Keyword(name = "maximize browser window", doc = "Maximize current browser window")
    public void maximizeWindow(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    @Keyword(name = "press key", doc = "Simulates the user pressing key to an element")
    public void pressKey(WebDriver webDriver, @KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) {
        WebElement element;
        String locator;
        if (value == null) {
            value = selector;
            locator = "tag:body";
        } else {
            locator = value.getValue().toString();
        }
        By elementSelector = getLocatorFromString(locator);
        element = webDriver.findElement(elementSelector);
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
    public void input(WebDriver webDriver, @KeywordArgument AbstractStafObject selector, @KeywordArgument AbstractStafObject value) throws InterruptedException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        element.clear();
        Actions navigator = new Actions(webDriver);
        navigator.click(element).sendKeys(value.getValue().toString()).perform();
    }

    @Keyword(name = "click element", doc = "Click element by locator")
    public void clickButton(WebDriver webDriver, @KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).click();
    }

    @Keyword(name = "open context menu", doc = "Right click element")
    public void openContextMenu(WebDriver webDriver, @KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        Actions action= new Actions(webDriver);
        action.contextClick(webDriver.findElement(elementSelector)).build().perform();
    }


    @Keyword(name = "set focus to element", doc = "Focus element by locator")
    public void setFocus(WebDriver webDriver, @KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).sendKeys("");
    }


    @Keyword(name = "input value")
    public StafString getInputValue(WebDriver webDriver, @KeywordArgument AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafString(webDriver.findElement(elementSelector).getAttribute("value"));
    }

    @Keyword(name = "capture screenshot")
    public void captureScreenshot(WebDriver webDriver, AbstractStafObject filename) throws IOException {
        WebDriver augmentedDriver = new Augmenter().augment(webDriver);
        File SrcFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + "/" + filename.getValue());
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @Keyword(name = "wait until element is visible")
    public void waitUntilElementIsVisible(WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout)
            throws ElementShouldBeVisibleNotFoundException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, (Integer) timeout.getValue());
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
        } else {
            List<WebElement> elements = webDriver.findElements(elementSelector);
            if (elements.size() == 0) {
                throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
            }
        }
    }

    @Keyword(name = "wait until element is enabled")
    public void waitUntilElementIsEnabled(WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, (Integer) timeout.getValue());
            wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        } else {
            webDriver.findElement(elementSelector);
        }
    }

    @Keyword(name = "element should be visible")
    public void elementShouldBeVisible(WebDriver webDriver, AbstractStafObject selector) throws ElementShouldBeVisibleNotFoundException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        List<WebElement> elementList = webDriver.findElements(elementSelector);
        if (elementList.size() == 0) {
            throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
        }
    }

    @Keyword(name = "element should be enabled")
    public void elementShouldBeEnabled(WebDriver webDriver, AbstractStafObject selector) throws ElementShouldBeVisibleNotFoundException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        if (!element.isEnabled()) {
            throw new ElementShouldBeEnabledException(selector.getValue().toString());
        }
    }

    @Keyword(name = "element should contain", doc = "Verifies that element 'locator' contains text expected.")
    public void elementShouldContain(WebDriver webDriver, AbstractStafObject selector, AbstractStafObject expected, AbstractStafObject message)
            throws ElementShouldContainException {
        By elementSelector = By.xpath("//*[contains(text(),'" + expected.getValue() + "')]");
        List<WebElement> elementList = webDriver.findElements(elementSelector);
        if (elementList.size() == 0) {
            if (message != null) {
                throw new ElementShouldContainException(message.getValue().toString());
            } else {
                throw new ElementShouldContainException("Could not find element that contains '" + expected + "'");
            }
        }
    }

    @Keyword(name = "page should contain element", doc = "Verifies that page contains element 'locator'")
    public void pageShouldContainElement(WebDriver webDriver, AbstractStafObject selector)
            throws ElementShouldContainException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (webDriver.findElements(elementSelector).size() == 0) {
            throw new PageShouldContainException();
        }
    }

    @Keyword(name = "page contains element", doc = "Returns if page contains element 'locator'")
    public StafBoolean pageContainsElement(WebDriver webDriver, AbstractStafObject selector)
            throws ElementShouldContainException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafBoolean(webDriver.findElements(elementSelector).size() > 0);
    }

    @Keyword(name = "wait until element is not visible")
    public void waitUntilElementIsNotVisible(WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout) {
        int timeoutInt = DEFAULT_TIMEOUT;
        if (timeout != null) {
            timeoutInt = (int) timeout.getValue();
        }
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInt);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementSelector));
    }

    @Keyword(name = "get element count", doc = "Returns the number of elements matching 'locator'")
    public StafInteger getElementCount(WebDriver webDriver, AbstractStafObject selector)
            throws ElementShouldContainException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafInteger(webDriver.findElements(elementSelector).size());
    }

    @Keyword(name = "go to")
    public void gotToUrl(WebDriver webDriver, @KeywordArgument AbstractStafObject url) throws NoBrowserOpenedException {
        try {
            webDriver.get(url.getValue().toString());
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    @Keyword(name = "get element attribute")
    public StafString getElementAttribute(WebDriver webDriver, AbstractStafObject selector, AbstractStafObject attributeName) throws NoBrowserOpenedException {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        try {
            WebElement element = webDriver.findElement(elementSelector);
            return new StafString(element.getAttribute(attributeName.getValue().toString()));
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    @Keyword(name = "click element using javascript")
    public void clickElementJS(WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    @Keyword(name = "checkbox should be selected")
    public void checkboxShouldBeSelected(WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        if (!element.isSelected()) {
            throw new CheckboxShouldBeSelectedException(selector.getValue().toString());
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
