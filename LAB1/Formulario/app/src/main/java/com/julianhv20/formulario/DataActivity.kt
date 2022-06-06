package com.julianhv20.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DataActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        showData()

        val backButton = findViewById<Button>(R.id.btnBack)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showData() {
        val bundle = intent.extras
        val textView = findViewById<TextView>(R.id.data_text)

        val name = bundle?.getString("intentName")
        val email = bundle?.getString("intentEmail")
        val password = bundle?.getString("intentPass")
        val confirmPass = bundle?.getString("intentConfirmPass")
        val date = bundle?.getString("intentDate")

        //val city = bundle?.getString("intentCity")

        val message = "Nombre: $name\nEmail: $email\nPassword: $password\nConfirmar Password: $confirmPass\nDate: $date"
        textView.text = message
    }
}