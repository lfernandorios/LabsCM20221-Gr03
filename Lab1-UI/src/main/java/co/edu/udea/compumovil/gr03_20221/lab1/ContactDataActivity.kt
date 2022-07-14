package co.edu.udea.compumovil.gr03_20221.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class ContactDataActivity : AppCompatActivity() {

    val finalizarBtn =  findViewById<Button>(R.id.btFinalizar)
    val telefonoEditText = findViewById<EditText>(R.id.telefono_edit_text)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_data)

        finalizarBtn.setOnClickListener{
            if (validateFields()){
                intent.getStringExtra("apellidos")?.let { it1 -> sendLog("apellidos", it1) }
                sendLog("télefono", telefonoEditText.text.toString())
            }
        }
    }

    private fun validateFields(): Boolean {
        if (telefonoEditText?.text.isNullOrEmpty()) {
            telefonoEditText?.error = R.string.apellido_msg_validate.toString()
            return false
        }

        return true
    }

    private fun sendLog(campo : String, valor: String) {
            Log.i(campo, valor)
    }


}