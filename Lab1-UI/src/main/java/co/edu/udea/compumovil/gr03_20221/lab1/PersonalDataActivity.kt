package co.edu.udea.compumovil.gr03_20221.lab1

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import java.util.*

class PersonalDataActivity : AppCompatActivity() {

    val apellidos = findViewById<EditText>(R.id.apellidos_edit_text)
    val pickerDateBtn = findViewById<Button>(R.id.btSelFechaN)
    val fecha = findViewById<EditText>(R.id.fecha_nac_edit_text)
    val siguienteBtn = findViewById<Button>(R.id.btFinalizar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data)

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
            validateFields()
        }

    }

    private fun validateFields(){
        if (apellidos?.text.isNullOrEmpty()) {
            apellidos?.error = R.string.apellido_msg_validate.toString()
            return
        }
        sendMessage()
    }

    private fun sendMessage() {

        val message = apellidos.text.toString()
        val intent = Intent(this, ContactDataActivity::class.java).apply {
            putExtra("apellidos", message)
        }
        startActivity(intent)
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