package co.edu.udea.compumovil.gr03_20221.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContactDataActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)
        val finalizarBtn =  findViewById<Button>(R.id.btFinalizar)

        finalizarBtn.setOnClickListener{
            if (validateFields()){
                Toast.makeText(baseContext, "Registro Éxitoso", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(): Boolean {
        val telefonoEditText = findViewById<EditText>(R.id.telefono_edit_text)
        val emailEditText = findViewById<EditText>(R.id.email_edit_text)
        val paisEditText = findViewById<EditText>(R.id.pais_auto_edit_text)

        if (telefonoEditText?.text.isNullOrEmpty()) {
            telefonoEditText.setError("Requerido")
            return false
        }
        if (emailEditText?.text.isNullOrEmpty()) {
            emailEditText.setError("Requerido")
            return false
        }
        if (paisEditText?.text.isNullOrEmpty()) {
            paisEditText.setError("Requerido")
            return false
        }
        sendLog("Actividad", this.title.toString())
        sendLog("Télefono", telefonoEditText.text.toString() )
        sendLog("Email", telefonoEditText.text.toString() )
        sendLog("Pais", telefonoEditText.text.toString() )

        return true
    }

    private fun sendLog(campo : String, valor: String) {
            Log.i(campo, valor)
    }


}