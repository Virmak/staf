package com.sparkit.staf.core.runtime.libs.builtin.selenium;

import com.sparkit.staf.core.runtime.libs.builtin.selenium.exceptions.UnsupportedBrowserDriverException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class WebDriverFactory {
    public WebDriver create(String webDriverUrl, String browserName, String browserVersion, String enableVnc, String enableVideo, boolean remote)
            throws MalformedURLException {
        if (remote) {
            Capabilities capabilities = createBrowserCapabilities(browserName, browserVersion, enableVnc, enableVideo);
            return createRemoteWebDriver(webDriverUrl, capabilities);
        }
        return createLocalWebDriver(browserName);
    }

    public WebDriver createLocalWebDriver(String browserName) {
        if (Browser.CHROME.equalsName(browserName)) {
            return new ChromeDriver();
        } else if (Browser.FIREFOX.equalsName(browserName)) {
            return new FirefoxDriver();
        } else if(Browser.OPERA.equalsName(browserName)) {
            return new OperaDriver();
        } else {
            throw new UnsupportedBrowserDriverException("");
        }
    }

    public RemoteWebDriver createRemoteWebDriver(String webDriverUrl, Capabilities capabilities) throws MalformedURLException {
        return new RemoteWebDriver( new URL(webDriverUrl), capabilities);
    }

    public Capabilities createBrowserCapabilities(String browserName, String browserVersion, boolean enableVnc, boolean enableVideo) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browserName);
        capabilities.setVersion(browserVersion);
        capabilities.setCapability("enableVNC", enableVnc);
        capabilities.setCapability("enableVideo", enableVideo);
        return capabilities;
    }

    public Capabilities createBrowserCapabilities(String browserName, String browserVersion, String enableVnc, String enableVideo) {
        return createBrowserCapabilities(browserName, browserVersion, "true".equals(enableVnc), "true".equals(enableVideo));
    }
}
