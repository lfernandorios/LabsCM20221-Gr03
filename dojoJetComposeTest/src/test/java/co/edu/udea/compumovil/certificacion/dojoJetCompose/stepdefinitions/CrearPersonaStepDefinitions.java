package co.edu.udea.compumovil.certificacion.dojoJetCompose.stepdefinitions;

import co.edu.udea.compumovil.certificacion.dojoJetCompose.questions.CamposDiligenciados;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.questions.VisualizarLista;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.runners.CrearPersona;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.tasks.ConfirmarFormulario;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.tasks.DiligenciarFormulario;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.tasks.Inicializar;
import co.edu.udea.compumovil.certificacion.dojoJetCompose.userinterfaces.ListPersons;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static co.edu.udea.compumovil.certificacion.dojoJetCompose.utils.Constantes.*;

public class CrearPersonaStepDefinitions {

    @Before
    public void setUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("^El usuario inicia el app y le da click en el boton nuevo$")
    public void elUsuarioIniciaElApp() {
        OnStage.theActorInTheSpotlight().attemptsTo(Inicializar.crearPersona());
    }

    @When("^El usuario ingresa el (.*), el (.*) y la (.*) en el formulario$")
    public void elUsuarioIngresaElNombreElApellidoYLaCiudadEnElFormularioYConfirmaConElBotonAnadir(
            String name, String lastName, String city
    ) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                DiligenciarFormulario.ingresarDatos(name, lastName, city )
        );
    }

    @When("^Confirma con el boton anadir$")
    public void confirmaConElBoton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ConfirmarFormulario.enviarDatos()
        );
    }


    @Then("^El usuario visualiza la nueva persona en la lista$")
    public void elUsuarioVisualizaLaNuevaPersonaEnLaLista() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(CamposDiligenciados.validarCampo(CAMPO_NOMBRES_PERSONA), Matchers.not(Matchers.isEmptyOrNullString())),
                GivenWhenThen.seeThat(CamposDiligenciados.validarCampo(CAMPO_APELLIDOS_PERSONA), Matchers.not(Matchers.isEmptyOrNullString())),
                GivenWhenThen.seeThat(CamposDiligenciados.validarCampo(CAMPO_CIUDAD_PERSONA), Matchers.not(Matchers.isEmptyOrNullString()))
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VisualizarLista.validarPersona())
        );
    }
}
