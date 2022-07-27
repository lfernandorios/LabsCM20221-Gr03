package co.edu.udea.compumovil.certificacion.dojoJetCompose.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ListPersons {

    public static final Target NUEVA_PERSONA_BOTON = Target.the("Nueva Persona")
            .located(By.className("android.widget.Button"));

}
