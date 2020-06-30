package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafBoolean;
import com.sparkit.staf.core.ast.types.StafInteger;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Inject;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.*;
import com.sparkit.staf.core.runtime.libs.exceptions.InvalidSelectorException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@StafLibrary(name = "selenium", builtin = true)
public class SeleniumLibrary extends AbstractStafLibrary {
    public static final int DEFAULT_TIMEOUT = 5;
    private static final Logger logger = LoggerFactory.getLogger(SeleniumLibrary.class);
    @Autowired
    private WebDriverFactory webDriverFactory;

    private void setDefaultTimeout(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    @Keyword(name = "open browser")
    public WebDriver openBrowser(AbstractStafObject browser) throws MalformedURLException {
        String webDriverAddress = System.getProperty("webDriverAddress");
        String browserName = System.getProperty("browserName");
        String browserVersion = System.getProperty("browserVersion");
        String remote = System.getProperty("remote");
        String enableVnc = System.getProperty("enableVnc");
        String enableVideo = System.getProperty("enableVideo");
        logger.info("{} browser instance started", browser.getValue());
        WebDriver webDriver = webDriverFactory.create(webDriverAddress, browserName, browserVersion, enableVnc, enableVideo, "true".equals(remote));
        setDefaultTimeout(webDriver);
        return webDriver;
    }

    @Keyword(name = "close browser")
    public void closeBrowser(@Inject(name = "__web_driver__") WebDriver webDriver) {
        try {
            webDriver.close();
        } catch (NullPointerException ignored) {//
        }
    }

    @Keyword(name = "set window size", doc = "Set window size")
    public void setWindowSize(@Inject(name = "__web_driver__") WebDriver webDriver, StafInteger width, StafInteger height) {
        webDriver.manage().window().setSize(new Dimension((int) width.getValue(), (int) height.getValue()));
    }

    @Keyword(name = "maximize browser window", doc = "Maximize current browser window")
    public void maximizeWindow(@Inject(name = "__web_driver__") WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    @Keyword(name = "press key", doc = "Simulates the user pressing key to an element")
    public void pressKey(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject value) {
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
            default:
        }
    }

    @Keyword(name = "input text", doc = "Types the given text into text field identified by locator")
    public void input(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject value) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        element.clear();
        Actions navigator = new Actions(webDriver);
        navigator.click(element).sendKeys(value.getValue().toString()).perform();
    }

    @Keyword(name = "click element", doc = "Click element by locator")
    public void clickButton(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).click();
    }

    @Keyword(name = "open context menu", doc = "Right click element")
    public void openContextMenu(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        Actions action = new Actions(webDriver);
        action.contextClick(webDriver.findElement(elementSelector)).build().perform();
    }


    @Keyword(name = "set focus to element", doc = "Focus element by locator")
    public void setFocus(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        webDriver.findElement(elementSelector).sendKeys("");
    }


    @Keyword(name = "input value")
    public StafString getInputValue(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafString(webDriver.findElement(elementSelector).getAttribute("value"));
    }

    @Keyword(name = "capture screenshot")
    public void captureScreenshot(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject filename) throws IOException {
        WebDriver augmentedDriver = new Augmenter().augment(webDriver);
        File sourceFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir"), filename.getValue().toString());
        FileUtils.copyFile(sourceFile, destinationFile);
    }

    @Keyword(name = "wait until element is visible")
    public void waitUntilElementIsVisible(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, (Integer) timeout.getValue());
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementSelector));
        } else {
            List<WebElement> elements = webDriver.findElements(elementSelector);
            if (elements.isEmpty()) {
                throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
            }
        }
    }

    @Keyword(name = "wait until element is enabled")
    public void waitUntilElementIsEnabled(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (timeout != null) {
            WebDriverWait wait = new WebDriverWait(webDriver, (Integer) timeout.getValue());
            wait.until(ExpectedConditions.elementToBeClickable(elementSelector));
        } else {
            webDriver.findElement(elementSelector);
        }
    }

    @Keyword(name = "element should be visible")
    public void elementShouldBeVisible(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        List<WebElement> elementList = webDriver.findElements(elementSelector);
        if (elementList.isEmpty()) {
            throw new ElementShouldBeVisibleNotFoundException(selector.getValue().toString());
        }
    }

    @Keyword(name = "element should be enabled")
    public void elementShouldBeEnabled(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        if (!element.isEnabled()) {
            throw new ElementShouldBeEnabledException(selector.getValue().toString());
        }
    }

    @Keyword(name = "element should contain", doc = "Verifies that element 'locator' contains text expected.")
    public void elementShouldContainText(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector,
                                         AbstractStafObject expected, AbstractStafObject message) {
        By elementSelector = By.xpath("//*[contains(text(),'" + expected.getValue() + "')]");
        List<WebElement> elementList = webDriver.findElements(elementSelector);
        if (elementList.isEmpty()) {
            if (message != null) {
                throw new ElementShouldContainException(message.getValue().toString());
            } else {
                throw new ElementShouldContainException("Could not find element that contains '" + expected + "'");
            }
        }
    }

    @Keyword(name = "page should contain element", doc = "Verifies that page contains element 'locator'")
    public void pageShouldContainElement(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        if (webDriver.findElements(elementSelector).isEmpty()) {
            throw new PageShouldContainException();
        }
    }

    @Keyword(name = "page contains element", doc = "Returns if page contains element 'locator'")
    public StafBoolean pageContainsElement(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafBoolean(!webDriver.findElements(elementSelector).isEmpty());
    }

    @Keyword(name = "wait until element is not visible")
    public void waitUntilElementIsNotVisible(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject timeout) {
        int timeoutInt = DEFAULT_TIMEOUT;
        if (timeout != null) {
            timeoutInt = (int) timeout.getValue();
        }
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInt);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementSelector));
    }

    @Keyword(name = "get element count", doc = "Returns the number of elements matching 'locator'")
    public StafInteger getElementCount(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        return new StafInteger(webDriver.findElements(elementSelector).size());
    }

    @Keyword(name = "go to")
    public void gotToUrl(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject url) {
        try {
            webDriver.get(url.getValue().toString());
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    @Keyword(name = "get element attribute")
    public StafString getElementAttribute(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector, AbstractStafObject attributeName) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        try {
            WebElement element = webDriver.findElement(elementSelector);
            return new StafString(element.getAttribute(attributeName.getValue().toString()));
        } catch (NullPointerException e) {
            throw new NoBrowserOpenedException();
        }
    }

    @Keyword(name = "click element using javascript")
    public void clickElementJS(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
        By elementSelector = getLocatorFromString(selector.getValue().toString());
        WebElement element = webDriver.findElement(elementSelector);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    @Keyword(name = "checkbox should be selected")
    public void checkboxShouldBeSelected(@Inject(name = "__web_driver__") WebDriver webDriver, AbstractStafObject selector) {
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
