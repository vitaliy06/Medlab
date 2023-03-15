package com.example.medlab

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText

class enter : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)
        val editText1 = findViewById<EditText>(R.id.editTextTextEmailAddress)

        button = findViewById(R.id.buttonDal)
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
        editText1.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(s.toString().isNullOrEmpty()){



                }
                else{
                    val isEmail = emailRegex.matches(s.toString())
                    if(isEmail){
                        button.isEnabled = true
                        button.isClickable = true}
                    else{
                        button.isEnabled = false
                        button.isClickable = false
                        editText1.error = "Введите корректный адрес электронной почты"
                    }
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    fun onClickemail(view: View) {
        val intent = Intent(this, codeEmail::class.java)
        startActivity(intent)
    }

}