package com.fw.tests;

import com.fw.util.Config;
import com.fw.util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Common {
    protected WebDriver getLocalDriver(){

        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))){
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }

    protected WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities caps = new ChromeOptions();
        if (Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))){
            caps = new FirefoxOptions();
        }
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        return new RemoteWebDriver(new URL(url),caps);

    }
}
