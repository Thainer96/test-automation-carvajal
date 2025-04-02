package testCarvajalWeb.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCarvajalWeb.baseTest.BaseTestWeb;
import testCarvajalWeb.pageOrangeWeb.DashboardOrangePage;
import testCarvajalWeb.pageOrangeWeb.EmployeePage;
import testCarvajalWeb.pageOrangeWeb.LocatorProviderWeb;

import java.util.HashMap;
import java.util.Map;

public class EmployeeSteps {

    private BaseTestWeb baseTest = BaseTestWeb.getInstance();
    private LocatorProviderWeb employeePage;
    private LocatorProviderWeb dasboardOrange;


    public EmployeeSteps(){
        this.employeePage = new EmployeePage();
        this.dasboardOrange = new DashboardOrangePage();
    }

    @And("presione el boton +")
    public void presioneElBoton() {
        baseTest.clickElement(employeePage.getLocator("addButton"));
    }

    @When("complete la informacion del formulario")
    public void complete_la_informacion_del_formulario(DataTable dataFeature) {
        Map<String, Object> data = new HashMap<>();
        dataFeature.asMaps(String.class, Object.class).forEach(row -> row.forEach(data::put));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.ADD_BUTTON));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.LOCATION_BUTTON));
        baseTest.selectElementByList(employeePage.getLocator(EmployeePage.LIST_LOCATION), data.get("location").toString());

        baseTest.writeLocator(employeePage.getLocator(EmployeePage.INPUT_NAME),data.get("nombre").toString());
        baseTest.writeLocator(employeePage.getLocator(EmployeePage.INPUT_LAST_NAME),data.get("apellido").toString());

        baseTest.clickElement(employeePage.getLocator(EmployeePage.NEXT_BUTTON));
        baseTest.waitToAppear(employeePage.getLocator(EmployeePage.PERSONAL_DETAILS_TITLE));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.NEXT_BUTTON));
        baseTest.waitToAppear(employeePage.getLocator(EmployeePage.EMPLOYMENT_DETAILS_TITLE));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.NEXT_BUTTON));
        baseTest.waitToAppear(employeePage.getLocator(EmployeePage.ONBOARDING_TITLE));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.SAVE_BUTTON));
    }

    @Then("permite crear el cliente")
    public void permite_crear_el_cliente(DataTable dataFeature) {
        Map<String, Object> data = new HashMap<>();
        dataFeature.asMaps(String.class, Object.class).forEach(row -> row.forEach(data::put));
        baseTest.clickElement(dasboardOrange.getLocator("personalDetailsButton"));

    }

    @Given("un usuario que realiza la busqueda de un empleado {string}")
    public void unUsuarioQueRealizaLaBusquedaDeUnEmpleado(String employee) {
        baseTest.clickElement(dasboardOrange.getLocator("EmployeeListButton"));
        baseTest.countElementTable(employeePage.getLocator(EmployeePage.TR_TABLE_EMPLOYEE));
        baseTest.clickElement(employeePage.getLocator(EmployeePage.SEARCH_EMPLOYEE));
        baseTest.writeLocator(employeePage.getLocator(EmployeePage.SEARCH_EMPLOYEE), employee);
        baseTest.clickElement(employeePage.getLocator(EmployeePage.SEARCH_ICON_BUTTON));
    }

    @When("encuentre el empleado {string}")
    public void encuentreElEmpleado(String employee) {
        baseTest.selectContentTable(employeePage.getLocator(EmployeePage.TR_TABLE_EMPLOYEE), employee);
    }

    @Then("permite realizar la modificacion del segundo nombre {string}")
    public void permiteRealizarLaModificacionDelSegundoNombre(String middleName) {
        baseTest.clickElement(dasboardOrange.getLocator("personalDetailsButton"));

        baseTest.clickElement(employeePage.getLocator(EmployeePage.INPUT_MIDDLE_NAME));
        baseTest.writeLocator(employeePage.getLocator(EmployeePage.INPUT_MIDDLE_NAME), middleName);

        baseTest.clickElement(employeePage.getLocator(EmployeePage.SAVE_BUTTON));
    }

    @Given("un usuario en la opcion de contact details")
    public void unUsuarioEnLaOpcionDeContactDetails() {
        baseTest.clickElement(dasboardOrange.getLocator("myInfo"));
        baseTest.clickElement(dasboardOrange.getLocator("contactDetails"));

        baseTest.clickElement(employeePage.getLocator(EmployeePage.ADD_BUTTON_FILE));
    }

    @When("realice el cargue de un archivo pdf")
    public void realiceElCargueDeUnArchivoPdf() {
        //baseTest.clickElement(employeePage.getLocator(EmployeePage.UPLOAD_BUTTON_FILE));
        baseTest.uploadFile(employeePage.getLocator(EmployeePage.UPLOAD_BUTTON_FILE));
    }

    @Then("se visualiza cargado correctamente")
    public void seVisualizaCargadoCorrectamente() {
        
    }

    @And("se puede eliminar el archivo cargado")
    public void sePuedeEliminarElArchivoCargado() {
    }
}
