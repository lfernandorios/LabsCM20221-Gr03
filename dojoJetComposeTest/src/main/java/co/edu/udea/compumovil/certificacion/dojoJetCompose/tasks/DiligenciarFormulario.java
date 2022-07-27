package co.edu.udea.compumovil.certificacion.dojoJetCompose.tasks;

import co.edu.udea.compumovil.certificacion.dojoJetCompose.userinterfaces.FormPerson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.compumovil.certificacion.dojoJetCompose.utils.Constantes.*;

public class DiligenciarFormulario implements Task {

    private String name;
    private String lastName;
    private String city;

    public DiligenciarFormulario(String name, String lastName, String city) {
        this.name = name;
        this.lastName = lastName;
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(this.name).into(FormPerson.NOMBRES_TEXTO),
                Enter.theValue(this.lastName).into(FormPerson.APELLIDOS_TEXTO),
                Enter.theValue(this.city).into(FormPerson.CIUDAD_TEXTO)
        );

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        actor.remember(CAMPO_NOMBRES_PERSONA,this.name);
        actor.remember(CAMPO_APELLIDOS_PERSONA,this.lastName);
        actor.remember(CAMPO_CIUDAD_PERSONA,this.city);
    }

    public static DiligenciarFormulario ingresarDatos(String name, String lastName, String city){
        return Tasks.instrumented(DiligenciarFormulario.class, name, lastName, city);
    }

}
