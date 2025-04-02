package testCarvajalWeb.baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.devtools.DevTools;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverSetUp {

    private static final Logger logger = LogManager.getLogger(DriverSetUp.class);

    private RemoteWebDriver driver;

    private void getDriverByBrowser() {
        String browser = Utils.getPropertyValue("test.properties", "BROWSER");
        logger.info(String.format("**** open browser %s ****", browser));
        switch (browser) {
            case "Chrome" -> setUpChrome();
            case "Firefox"-> setUpFirefox();
            default -> throw new IllegalArgumentException("Navegador no soportado: " + browser);
        }
    }

    private void setUpChrome(){
        Map<String, Object> prefs = new HashMap <String,Object>();
        Map<String, Object> profile = new HashMap <String,Object>();
        Map<String, Object> contentSetting = new HashMap <String,Object>();
        contentSetting.put("geolocation",2);
        profile.put("managed_default_content_settings", contentSetting);
        prefs.put("profile", profile);
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("start-maximized");
        options.addArguments("-window-size=1920,1080");
        options.addArguments("--incognito");
        options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

    }

    private void setUpFirefox(){
        FirefoxOptions optionFi = new FirefoxOptions();
        //optionFi.addArguments("--headless");
        optionFi.addArguments("-window-size=1920,1080");
        optionFi.addArguments("-private");
        optionFi.addArguments("-no-remote");
        optionFi.addArguments("-disable-extensions");
        optionFi.addArguments("-ignore-certificate-errors");
        optionFi.addPreference("browser.bookmarks.showRecentlyBookmarked", false);
        driver =  new FirefoxDriver(optionFi);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        if(driver==null){
            getDriverByBrowser();
        }
        return driver;
    }

    public void quitDriver(){
        if (driver!=null){
            driver.quit();
        }
    }




}