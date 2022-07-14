package co.edu.udea.compumovil.gr03_20221.lab1

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)
        val pickerDateBtn: Button = findViewById<Button>(R.id.btSelFechaN)
        val fecha: EditText = findViewById<EditText>(R.id.fecha_nac_edit_text)
        val siguienteBtn: Button = findViewById<Button>(R.id.btFinalizar)

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        pickerDateBtn.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, myear, mmonth, mdayOfMonth ->
                fecha.setText(""+ mdayOfMonth +"/"+ mmonth +"/"+ myear)
            }, year, month, day)
            datePickerDialog.show()
        }

        siguienteBtn.setOnClickListener{
            if(validateFields()){

                val intent = Intent(this, ContactDataActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun validateFields(): Boolean {
        val nombres: EditText = findViewById(R.id.nombres_edit_text)
        val apellidos: EditText = findViewById(R.id.apellidos_edit_text)
        val fechaNac: EditText = findViewById(R.id.fecha_nac_edit_text)

        if (nombres?.text.isNullOrEmpty()) {
            nombres.setError("Requerido")
            return false
        }
        if (apellidos?.text.isNullOrEmpty()) {
            apellidos.setError("Requerido")
            return false
        }
        if (fechaNac?.text.isNullOrEmpty()) {
            fechaNac.setError("Requerido")
            return false
        }


        sendLog("Actividad", this.title.toString())
        sendLog("Nombres", nombres.text.toString())
        sendLog("Apellidos", apellidos.text.toString())
        sendLog("FechaNac", fechaNac.text.toString())

        return true

    }

    private fun sendLog(campo: String, valor: String) {
        Log.i(campo, valor)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val flowData = findViewById<Flow>(R.id.flowDatos)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            flowData.setMaxElementsWrap(4)
            Toast.makeText(baseContext, "Landscape Mode", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            flowData.setMaxElementsWrap(2)
            Toast.makeText(baseContext, "Portrait Mode", Toast.LENGTH_SHORT).show()
        }
    }
}
