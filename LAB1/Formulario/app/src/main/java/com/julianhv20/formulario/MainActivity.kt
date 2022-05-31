package com.julianhv20.formulario

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*

abstract class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var adapterCities: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var spinner: Spinner = findViewById(R.id.spinner)

        val adapterCities = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item
        )

        adapterCities.addAll(listOf("Select a city","Bogota","Medellin","Cali","Barranquilla","Cartagena","Pereira"))

        spinner.onItemSelectedListener = this
        spinner.adapter = adapterCities


        val sendButton = findViewById<Button>(R.id.send_button)


    }

    fun checkValues(){
        //Check if values are not empty
        val name = findViewById<EditText>(R.id.name_text)
        val email = findViewById<EditText>(R.id.email_text)
        val pass = findViewById<EditText>(R.id.pass_text)
        val passConfirm = findViewById<EditText>(R.id.confirm_pass_text)
        val spiner = findViewById<Spinner>(R.id.spinner).selectedItem.toString()

        if (name.text.isEmpty()){
            name.error = "Please enter your name"
        } else if (email.text.isEmpty()){
            email.error = "Please enter your email"
        } else if (pass.text.isEmpty()){
            pass.error = "Please enter your password"
        } else if (passConfirm.text.isEmpty()){
            passConfirm.error = "Please confirm your password"
        } else if (pass.text.toString() != passConfirm.text.toString()){
            passConfirm.error = "Passwords do not match"
        } else {
            //Send data to server
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("intentName", name.text.toString())
            intent.putExtra("intentEmail", email.text.toString())
            intent.putExtra("intentPass", pass.text.toString())
            intent.putExtra("intentConfirmPass", passConfirm.text.toString())
            intent.putExtra("intentCity", spiner)
            startActivity(intent)
        }



    }

    fun showError(){
        //Show error message
        Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()
    }





}