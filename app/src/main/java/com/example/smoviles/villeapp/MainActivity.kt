package com.example.smoviles.villeapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var Cities: Spinner
    private lateinit var Opcion: TextView
    private lateinit var Label: TextView
    private lateinit var date: String
    private var sexo = ""
    private var hobbies = ""
    private var city = ""
    private var nacimiento = ""
    private var dd = ""
    private var mm = ""
    private var yyyy = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bfGuardar.setOnClickListener {
            var nombre = editText_Name.text.toString()
            var clave = editText_Password.text.toString()
            var clave_r = editText_Password2.text.toString()
            var correo = editText_Email.text.toString()

            Label = findViewById(R.id.et_conf) as TextView
            if (clave == clave_r && clave != "")
                Label.text = "* Contraseña Correcta"
            if (clave != clave_r)
                Label.text = "* Las Contraseñas No coinciden "


            if(nombre == "" || clave == "" || clave_r == "" || correo == "" || sexo == "" || hobbies == "" ||  city == "" || nacimiento == "")
                Toast.makeText(this,"Hay espacios sin completar",Toast.LENGTH_SHORT).show()
            else
                if(clave != clave_r)
                    Toast.makeText(this, "Contraseñas incorrectas", Toast.LENGTH_SHORT).show()
                    else {
                    var rta =
                        "Nombre: " + nombre + "\n" + "Contraseña: " + clave + "\n" + "Contraseña confirmada: " + clave_r + "\n" + "Correo: " + correo + "\n" + "Sexo: " + sexo + "\n" + "Hobbies: " + hobbies + "\n" + "Fecha de nacimiento: " + nacimiento + "\n" + "Lugar de nacimiento: " + city
                    resultados.text = rta
                    }
        }

        almanaque.setOnClickListener{
            val now = Calendar.getInstance()
            val anho = now.get(Calendar.YEAR)
            val mes = now.get(Calendar.MONTH)
            var diaweek = now.get(Calendar.DAY_OF_WEEK).toString()
            val dia_month = now.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                dd = "$day"
                mm = "${month + 1}"
                yyyy = "$year"
                nacimiento = dd + "/" + mm + "/" + yyyy
            }

            DatePickerDialog(this, datePicker, anho, mes, dia_month).show()
        }


        Cities = findViewById(R.id.ciudades) as Spinner
        Opcion = findViewById(R.id.resultados) as TextView

        val places = arrayOf("Barranquilla", "Bogotá", "Cali", "Manizales", "Medellín")

        Cities.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places)

        Cities.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Opcion.text = "Lugar de nacimiento:"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                city = places.get(p2)
            }
        }
    }

        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                when (view.id) {
                    R.id.leer ->
                        if (view.isChecked)
                            hobbies = hobbies + "Leer "
                        else
                            hobbies = ""
                    R.id.correr ->
                        if (view.isChecked)
                            hobbies = hobbies + "Correr "
                        else
                            hobbies = ""
                    R.id.cantar ->
                        if (view.isChecked)
                            hobbies = hobbies + "Cantar "
                        else
                            hobbies = ""
                    R.id.bailar ->
                        if (view.isChecked)
                            hobbies = hobbies + "Bailar "
                        else
                            hobbies = ""
                }
            }
        }

        fun onRadioButtonClicked(view: View) {
            if (view is RadioButton) {
                val checked = view.isChecked

                when (view.getId()) {
                    R.id.rbutton_M ->
                        if (checked) {
                            sexo = rbutton_M.text.toString()
                        }
                    R.id.rbutton_F ->
                        if (checked) {
                            sexo = rbutton_F.text.toString()
                        }
                }
            }
        }
}


