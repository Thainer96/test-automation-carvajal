@Employee
Feature: Crear cliente en el portal web
  yo como usuario en el portal web
  quiero crear un nuevos clientes
  para mantener el flujo de creacion de empleado operativo

  Background: usuario con ingreso valido
    Given un usuario en ambiente de pruebas "QA"
    And ingrese un correo valido "Admin"
    And ingrese una contrasena valida "V@8oGoUlZ6"
    Then presione el boton permitiendo el inicio de sesion exitoso

  @RegistroEmpleado
  Scenario Outline: Registro de empleado
    Given un usuario que da click en el boton lista de empleado
    And presione el boton +
    When complete la informacion del formulario
      | nombre   | apellido   | location   |
      | <nombre> | <apellido> | <location> |
    Then permite crear el cliente
      | nombre   |
      | <nombre> |
    Examples:
      | nombre | apellido | location      |
      | zapata | perez    | Mexico Office |
      | cortes | perez    | Mexico Office j |


  @buscarEmpleado
  Scenario Outline: Buscar empleado
    Given un usuario que realiza la busqueda de un empleado "<empleado>"
    When encuentre el empleado "<empleado>"
    Examples:
      | empleado |
      | zapata   |

  @editarEmpleado
  Scenario Outline: Edicion de empleado
    Given un usuario que realiza la busqueda de un empleado "<empleado>"
    When encuentre el empleado "<empleado>"
    Then permite realizar la modificacion del segundo nombre "<segundoNombre>"
    Examples:
      | empleado |segundoNombre|
      | zapata   |Andres|

  @cargarEliminarArchivo
  Scenario: Cargar y eliminar un archivo
    Given un usuario en la opcion de contact details
    When realice el cargue de un archivo pdf
    Then se visualiza cargado correctamente
    And se puede eliminar el archivo cargado
