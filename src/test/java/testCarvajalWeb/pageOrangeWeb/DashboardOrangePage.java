package testCarvajalWeb.pageOrangeWeb;

import org.openqa.selenium.By;

import java.util.Map;

public class DashboardOrangePage implements LocatorProviderWeb {

   private final Map<String, By> locatorDasboardOrange = Map.of(
           "EmployeeListButton", By.xpath("//a[text()='Employee List ']"),
           "personalDetailsButton", By.xpath("//a[text()='Personal Details ']"),
           "myInfo", By.xpath("//a[text()='My Info ']"),
           "contactDetails", By.xpath("//a[text()='Contact Details ']"),
           "filterButton", By.xpath("//i[text()='oxd_filter']")
   );

    public By getLocator(String key) {
        return locatorDasboardOrange.getOrDefault(key, null);
    }
}
