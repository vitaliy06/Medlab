package com.example.medlab

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class pin : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)
       var pincode = ""
        var j = 0
        var tv:TextView
       val arr = arrayOf(findViewById<Button>(R.id.buttone),findViewById<Button>(R.id.butttwo),findViewById<Button>(R.id.buttthree),findViewById<Button>(R.id.buttfour),findViewById<Button>(R.id.buttfive),findViewById<Button>(R.id.buttsix),findViewById<Button>(R.id.buttseven),findViewById<Button>(R.id.butteigh),findViewById<Button>(R.id.buttnine),findViewById<Button>(R.id.buttzero))
        for(i in arr.indices){
            arr[i].setOnClickListener {
                if (pincode.length != 4) {
                    pincode += arr[i].text.toString()
                    j += 1
                    if (pincode.length == 1 ){
                        tv = findViewById(R.id.pin1)
                        tv.foreground.setTint(Color.parseColor("#1A6FEE"))
                    }
                    if (pincode.length == 2 ){
                        tv = findViewById(R.id.pin2)
                        tv.foreground.setTint(Color.parseColor("#1A6FEE"))
                    }
                    if (pincode.length == 3 ){
                        tv = findViewById(R.id.pin3)
                        tv.foreground.setTint(Color.parseColor("#1A6FEE"))
                    }
                    if (pincode.length == 4 ){
                        tv = findViewById(R.id.pin4)
                        tv.foreground.setTint(Color.parseColor("#1A6FEE"))
                        Log.d("pin",pincode)
                    }

                } else {
                    Log.d("pin", pincode)
                }
            }


        }


    }

    override fun onClick(v: View?) {

    }


}