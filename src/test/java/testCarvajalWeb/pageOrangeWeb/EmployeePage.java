package testCarvajalWeb.pageOrangeWeb;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class EmployeePage implements LocatorProviderWeb {

    public static final String ADD_BUTTON = "addButton";
    public static final String INPUT_NAME = "inputName";
    public static final String INPUT_LAST_NAME = "inputLastName";
    public static final String PERSONAL_DETAILS_TITLE = "personalDetailsTitle";
    public static final String EMPLOYMENT_DETAILS_TITLE = "employmentDetailsTitle";
    public static final String ONBOARDING_TITLE = "onboardingTitle";
    public static final String NEXT_BUTTON = "nextButton";
    public static final String SAVE_BUTTON = "saveButton";
    public static final String LOCATION_BUTTON = "locationButton";
    public static final String LIST_LOCATION = "listLocation";

    public static final String SEARCH_EMPLOYEE = "searchEmpoyee";
    public static final String SEARCH_BUTTON = "searchButton";
    public static final String SEARCH_ICON_BUTTON = "searchIconButton";
    public static final String INPUT_EMPLOYEE_NAME = "inputEmployeeName";
    public static final String TR_TABLE_EMPLOYEE = "trTableEmployee";
    public static final String INPUT_MIDDLE_NAME = "inputMiddleName";
    public static final String ADD_BUTTON_FILE = "addButtonFile";
    public static final String UPLOAD_BUTTON_FILE = "uploadButtonFile";

    private final Map<String, By> locatorEmployee = new HashMap<>();

    public EmployeePage() {
        locatorEmployee.put(ADD_BUTTON, By.xpath("//i[text()='add']"));
        locatorEmployee.put(INPUT_NAME, By.id("first-name-box"));
        locatorEmployee.put(INPUT_LAST_NAME, By.id("last-name-box"));
        locatorEmployee.put(PERSONAL_DETAILS_TITLE, By.xpath("//h4[text()='Personal Details']"));
        locatorEmployee.put(EMPLOYMENT_DETAILS_TITLE, By.xpath("//h4[text()='Employment Details']"));
        locatorEmployee.put(ONBOARDING_TITLE, By.xpath("//h4[text()='Onboarding']"));
        locatorEmployee.put(NEXT_BUTTON, By.xpath("//button[text()='Next']"));
        locatorEmployee.put(SAVE_BUTTON, By.xpath("//button[text()='Save']"));
        locatorEmployee.put(LOCATION_BUTTON, By.id("location"));
        locatorEmployee.put(LIST_LOCATION, By.xpath("//span[@ng-if='!optionTranslate']"));
        locatorEmployee.put(SEARCH_EMPLOYEE, By.id("employee_name_quick_filter_employee_list_value"));
        locatorEmployee.put(SEARCH_ICON_BUTTON, By.id("quick_search_icon"));
        locatorEmployee.put(SEARCH_BUTTON, By.xpath("//a[text()='Search']"));
        locatorEmployee.put(INPUT_EMPLOYEE_NAME, By.id("emp_search_mdl_employee_name_filter_value"));

        locatorEmployee.put(TR_TABLE_EMPLOYEE, By.xpath("//table[@id='employeeListTable']//tr"));
        locatorEmployee.put(INPUT_MIDDLE_NAME, By.id("middleName"));

        locatorEmployee.put(ADD_BUTTON_FILE, By.xpath("//a[text()='Add']"));
        locatorEmployee.put(UPLOAD_BUTTON_FILE, By.xpath("//div[@id='modal-holder']//input"));
        //div[@id='modal-holder']//button[@id='modal-save-button']
    }

    @Override
    public By getLocator(String key) {
        return locatorEmployee.getOrDefault(key, null);
    }
}
