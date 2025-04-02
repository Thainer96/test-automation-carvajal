package testCarvajalWeb.pageOrangeWeb;

import org.openqa.selenium.By;

import java.util.Map;

public class PageLoginOrange implements LocatorProviderWeb {

    private final Map<String, By> locators = Map.of(
            "shadow-root-username", By.cssSelector("#username"),
            "locatorUsername", By.id("txtUsername"),
            "shadow-root-password", By.id("current-password"),
            "locatorPassword", By.id("txtPassword"),
            "locatorButton", By.xpath("//button[text()='Login']")
    );

    @Override
    public By getLocator(String key) {
        return locators.getOrDefault(key, null);
    }
}

