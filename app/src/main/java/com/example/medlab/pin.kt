package com.example.medlab

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class pin : AppCompatActivity(), View.OnClickListener {
    var pincode = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pin)

        var j = 0
        var tv:TextView
        val butDel = findViewById<Button>(R.id.buttdel)
        val sh = getSharedPreferences("data",Context.MODE_PRIVATE)
        val shedit = sh.edit()
       val arr = arrayOf(findViewById<Button>(R.id.buttone),findViewById<Button>(R.id.butttwo),findViewById<Button>(R.id.buttthree),findViewById<Button>(R.id.buttfour),findViewById<Button>(R.id.buttfive),findViewById<Button>(R.id.buttsix),findViewById<Button>(R.id.buttseven),findViewById<Button>(R.id.butteigh),findViewById<Button>(R.id.buttnine)/*,findViewById<Button>(R.id.buttzero)*/)
        for(i in arr.indices){
            arr[i].setOnClickListener {
                if (pincode.length != 4) {
                    pincode += arr[i].text.toString()
                    j += 1
                    when(pincode.length){
                        1 -> findViewById<TextView>(R.id.pin1).foreground.setTint(Color.parseColor("#1A6FEE"))
                        2 -> findViewById<TextView>(R.id.pin2).foreground.setTint(Color.parseColor("#1A6FEE"))
                        3 -> findViewById<TextView>(R.id.pin3).foreground.setTint(Color.parseColor("#1A6FEE"))
                        4 -> {
                            findViewById<TextView>(R.id.pin4).foreground.setTint(Color.parseColor("#1A6FEE"))
                            Log.d("pin",pincode)
                            shedit.putString("pin",pincode.toString())
                            shedit.apply()
                        }
                    }

                } else {
                    Log.d("pin", pincode)
                }
            }


        }


    }

    override fun onClick(v: View?) {

    }

    fun butDel(view: View) {
        pincode = pincode.substring(0,pincode.length-1)
        var tv:TextView
        when (pincode.length) {
            3 -> findViewById<View>(R.id.pin4).apply { foreground.setTintList(null) }
            2 -> findViewById<View>(R.id.pin3).apply { foreground.setTintList(null) }
            1 -> findViewById<View>(R.id.pin2).apply { foreground.setTintList(null) }
            0 -> {
                findViewById<View>(R.id.pin1).apply { foreground.setTintList(null) }
                Log.d("pin", pincode)
            }
        }

    }

    fun onClickNext(view: View) {
        val intent = Intent(this,cardOfCustomer::class.java)
        startActivity(intent)


    }


}