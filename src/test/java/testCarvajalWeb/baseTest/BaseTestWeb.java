package testCarvajalWeb.baseTest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class BaseTestWeb {

    private static volatile BaseTestWeb instance;
    private static final Logger log = LogManager.getLogger(BaseTestWeb.class);
    private WebDriver driver;
    private JavascriptExecutor js;
    private FluentWait<WebDriver> wait;


    private BaseTestWeb() {

    }

    public static BaseTestWeb getInstance() {
        if (instance == null) {
            synchronized (BaseTestWeb.class) {
                if (instance == null) {
                    instance = new BaseTestWeb();
                }
            }
        }
        return instance;
    }

    DriverSetUp driverSetUp;

    public void setUp() {
        driverSetUp = new DriverSetUp();
        driver = driverSetUp.getDriver();
        js = (JavascriptExecutor) driver;
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(13))
                .pollingEvery(Duration.ofSeconds(2));
    }

    public void setUp(String urlPage) {
        if (driver==null){
            setUp();
        }
        driver.get(urlPage);
    }

    public void quitDriver() throws IOException {
        driver.quit();
        driver = null;
       try{
           /* Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
            Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe /T");*/
        }catch (Exception e){
        }
    }

    public WebDriver getDriver(){
        return driver;
    }


    public void writeLocator(By locator, String valueToWrite){
        waitToAppear(locator);
        driver.findElement(locator).sendKeys(valueToWrite);
    }

    public void sendKeyEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void waitToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void isClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickElement(By locator){
        waitToAppear(locator);
        isClickable(locator);
        driver.findElement(locator).click();
    }

    public void uploadFile(By locator){
        URL fileUrl = BaseTestWeb.class.getClassLoader().getResource("pdfDummy/test.pdf");
        if (fileUrl != null) {
            File file = new File(fileUrl.getPath());
            System.out.println(file.getAbsolutePath());
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        } else {
            System.out.println("El archivo no se encuentra en el classpath.");
        }

    }

    public void countElementTable(By locator){
        int maxAttempts = 2;
        int attempts = 0;
        waitToAppear(locator);
        while (attempts < maxAttempts) {
            List<WebElement> listElementText = driver.findElements(locator);
            if (listElementText.size() >= 2) {
                break;
            }

            attempts++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void countMinElementTable(By locator){
        int maxAttempts = 2;
        int attempts = 0;
        waitToAppear(locator);
        while (attempts < maxAttempts) {
            List<WebElement> listElementText = driver.findElements(locator);
            if (listElementText.size() <= 1) {
                System.out.println("entro");
                break;
            }

            attempts++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void selectContentTable(By locator, String textSelect) {
        waitToAppear(locator);
        countMinElementTable(locator);
        List<WebElement> rows = driver.findElements(locator);
        for (WebElement row : rows) {
            List<WebElement> tdWithLinks = row.findElements(By.xpath("//td"));
            for (WebElement td : tdWithLinks) {
                if(td.getText().contains(textSelect)){
                    td.click();
                    break;
                }
            }
        }
    }

    public void selectElementByList(By locator, String textSelect){
        boolean is_found = false;
        waitToAppear(locator);
        List<WebElement> listElementText = driver.findElements(locator);
        List<String> lisValueText = new ArrayList<>();
        listElementText.forEach(values -> lisValueText.add(values.getText()));
        for (WebElement webElement : listElementText) {

            if (webElement.getText().equals(textSelect)) {
                webElement.click();
                is_found = true;
                break;
            }
        }
        assertTrue("## ERROR in selector ## '" + locator+"' - Value to select list not " +
                "found: value to find '" + textSelect + "' list values " + lisValueText,is_found);
    }

    public void clickElementJs(Object scriptLocator){
        WebElement elemento = (WebElement) js.executeScript((String)scriptLocator);
        elemento.click();
    }




}
