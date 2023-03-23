package com.example.medlab

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class cardOfCustomer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_of_customer)

        var j = 0
        val button = findViewById<Button>(R.id.buttonCreatePerson)
        button.isClickable = false
        button.isEnabled = false
        button.background.setTint(Color.parseColor("#C9D4FB"))

        val spinner = findViewById<Spinner>(R.id.spinner2)

        val items = listOf("Мужской","Женский")

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.prompt = "Пол"

        val tvnext = findViewById<TextView>(R.id.textView14)
        val intent = Intent(this,MainPage::class.java)
        tvnext.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {


                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)

            }
        })


        spinner.adapter = adapter
        var arredittext = arrayOf(findViewById<EditText>(R.id.editTextName),findViewById<EditText>(R.id.editTextTextSecondName),findViewById<EditText>(R.id.editTextTextFamilia),findViewById<EditText>(R.id.editTextDate))
        for (i in arredittext.indices){
            arredittext[i].addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrEmpty()){
                        j++
                    }
                    else{
                        j--
                    }
                    if (j>=4){
                        button.isClickable = true
                        button.isEnabled = true
                        button.background.setTint(Color.parseColor("#1A6FEE"))
                    }
                    else{
                        button.isClickable = false
                        button.isEnabled = false
                        button.background.setTint(Color.parseColor("#C9D4FB"))
                    }
                }

            })
        }
    }
}