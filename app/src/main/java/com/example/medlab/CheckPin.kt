package com.example.medlab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CheckPin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_pin)
        val sh = getSharedPreferences("data", Context.MODE_PRIVATE)
        val pincode = sh.getString("pin","").toString()
        val tv = findViewById<TextView>(R.id.textView11)
        tv.text = pincode

    }
}