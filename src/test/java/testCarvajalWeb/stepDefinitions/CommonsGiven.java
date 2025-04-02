package testCarvajalWeb.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testCarvajalWeb.baseTest.BaseTestWeb;
import testCarvajalWeb.pageOrangeWeb.DashboardOrangePage;
import testCarvajalWeb.pageOrangeWeb.PageLoginOrange;
import testCarvajalWeb.pageOrangeWeb.LocatorProviderWeb;
import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class CommonsGiven {

    private BaseTestWeb baseTest = BaseTestWeb.getInstance();
    private final LocatorProviderWeb pageLoginOrange;
    private final LocatorProviderWeb dashboardOrangePage;

    public CommonsGiven() {
        this.pageLoginOrange = new PageLoginOrange();
        this.dashboardOrangePage = new DashboardOrangePage();
    }

    @Given("un usuario en ambiente de pruebas {string}")
    public void selectEnvironment(String environment) {
        baseTest.setUp(Utils.getPropertyValue("test.properties", environment));

    }


    @Given("ingrese un correo valido {string}")
    public void ingrese_un_correo_valido(String email) {
        baseTest.writeLocator(pageLoginOrange.getLocator("locatorUsername"),email);
    }

    @Given("ingrese una contrasena valida {string}")
    public void ingrese_una_contrasena_valida(String password) {
        baseTest.writeLocator(pageLoginOrange.getLocator("locatorPassword"), password);
    }

    @Then("presione el boton permitiendo el inicio de sesion exitoso")
    public void presione_el_boton_permitiendo_el_inicio_de_sesion_exitoso() {
        baseTest.clickElement(pageLoginOrange.getLocator("locatorButton"));
    }


    @Given("un usuario que da click en el boton lista de empleado")
    public void unUsuarioQueDaClickEnElBotonListaDeEmpleado() {
        baseTest.clickElement(dashboardOrangePage.getLocator("EmployeeListButton"));
    }
}
