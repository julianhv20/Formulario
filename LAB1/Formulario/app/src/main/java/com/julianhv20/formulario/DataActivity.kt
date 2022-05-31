package com.julianhv20.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val backButton = findViewById<Button>(R.id.back_button)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    fun showData() {
        val bundle = intent.extras
        val textView = findViewById<TextView>(R.id.data_text)

        val name = bundle?.getString("name")
        val email = bundle?.getString("email")
        val password = bundle?.getString("password")
        val city = bundle?.getString("intentCity")

        val message = "Nombre: $name\nEmail: $email\nPassword: $password\nCiudad: $city"
        textView.text = message
    }
}