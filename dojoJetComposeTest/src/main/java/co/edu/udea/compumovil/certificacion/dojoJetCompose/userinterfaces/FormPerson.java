package co.edu.udea.compumovil.certificacion.dojoJetCompose.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormPerson {

    public static final Target NOMBRES_TEXTO = Target.the("Nombre Texto")
            .located(By.xpath("//android.widget.EditText//*[matches(@text,'^Name')]/.."));

    public static final Target APELLIDOS_TEXTO = Target.the("Apellidos Texto")
            .located(By.xpath("//android.widget.EditText//*[matches(@text,'^LastName')]/.."));

    public static final Target CIUDAD_TEXTO = Target.the("Ciudad Texto")
            .located(By.xpath("//android.widget.EditText//*[matches(@text,'^City')]/.."));

    /*
    public static final Target CIUDAD_TEXTO = Target.the("Ciudad Texto")
            .located(By.id("00000000-0000-03a8-0000-000700000004"));
    */

    public static final Target ANADIR_PERSONA_BOTON = Target.the("Anadir Persona")
            .located(By.className("android.widget.Button"));

}
