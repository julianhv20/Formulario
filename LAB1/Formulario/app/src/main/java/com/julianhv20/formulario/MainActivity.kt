package com.julianhv20.formulario


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import com.julianhv20.formulario.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etDate.setOnClickListener { showDatePickerDialog() }


        binding.btnRegister.setOnClickListener{
            checkValues()
        }


    }

    private fun showDatePickerDialog() {


        val datePicker = DatePickerFragment { year, month, day -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }


    fun onDateSelected(day:Int, month:Int, year:Int) {
        val realMonth = month + 1
        binding.etDate.setText("$day/$realMonth/$year")
    }

    private fun checkValues(){
        //Check if values are not empty
        val name = findViewById<EditText>(R.id.etName)
        val email = findViewById<EditText>(R.id.etEmail)
        val pass = findViewById<EditText>(R.id.etPassword)
        val passConfirm = findViewById<EditText>(R.id.etConfirmPass)
        val date = findViewById<EditText>(R.id.etDate)
        val hobbie1 = findViewById<CheckBox>(R.id.cbHobbie1)
        val hobbie2 = findViewById<CheckBox>(R.id.cbHobbie2)
        val hobbie3 = findViewById<CheckBox>(R.id.cbHobbie3)
        val hobbie4 = findViewById<CheckBox>(R.id.cbHobbie4)
        val male = findViewById<RadioButton>(R.id.rbMale)
        val female = findViewById<RadioButton>(R.id.rbFemale)


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
        } else if (date.text.isEmpty()){
            date.error = "Please enter your date of birth"
        } else if (!hobbie1.isChecked && !hobbie2.isChecked && !hobbie3.isChecked && !hobbie4.isChecked){
            Toast.makeText(this, "Please select at least one hobby", Toast.LENGTH_SHORT).show()
        }

        else {
            //Send data to server
            val intent = Intent(this, DataActivity::class.java)
            intent.putExtra("intentName", name.text.toString())
            intent.putExtra("intentEmail", email.text.toString())
            intent.putExtra("intentPass", pass.text.toString())
            intent.putExtra("intentConfirmPass", passConfirm.text.toString())
            intent.putExtra("intentDate", date.text.toString())
            if (hobbie1.isChecked) {
                intent.putExtra("intentHobbie1", hobbie1.text.toString())
            }
            if (hobbie2.isChecked) {
                intent.putExtra("intentHobbie2", hobbie2.text.toString())
            }
            if (hobbie3.isChecked) {
                intent.putExtra("intentHobbie3", hobbie3.text.toString())
            }
            if (hobbie4.isChecked) {
                intent.putExtra("intentHobbie4", hobbie4.text.toString())
            }
            if (male.isChecked){
                intent.putExtra("intentMale",male.text.toString())
            }
            if (female.isChecked){
                intent.putExtra("intentFemale",female.text.toString())
            }



            startActivity(intent)
        }



    }

    fun showError(){
        //Show error message
        Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()
    }





}