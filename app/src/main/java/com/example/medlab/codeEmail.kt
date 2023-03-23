package com.example.medlab

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.concurrent.timer
import kotlin.random.Random

class codeEmail : AppCompatActivity() {

    var i = (1000..9999).random().toString()
    var tick = 60
    private lateinit var textView: TextView
    private lateinit var button: Button
    private val timer = object: CountDownTimer(6000,100){
        override fun onTick(millisUntilFinished: Long) {

            textView.text = "Отправить код повторно можно будет через " + tick.toString() + " секунд"
            tick--
        }

        override fun onFinish() {
            textView.visibility = View.INVISIBLE
            button.visibility = View.VISIBLE
            tick = 60
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_email)

        textView = findViewById(R.id.textView8)
        button = findViewById(R.id.button3)
        Log.d("code",i)
        val dialog = Dialog(this)
        dialog.setTitle("Код")

        val intent = Intent(this, pin::class.java)


        val editText1 = findViewById<EditText>(R.id.editNumber1)
        val editText2 = findViewById<EditText>(R.id.editNumber2)
        val editText3 = findViewById<EditText>(R.id.editNumber3)
        val editText4 = findViewById<EditText>(R.id.editNumber4)
        editText1.requestFocus()

        val editTextArr = arrayOf(editText1,editText2,editText3,editText4)
        for (k in editTextArr.indices){
            editTextArr[k].addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if (!s.isNullOrEmpty()){
                        if(k < editTextArr.size -1){
                            editTextArr[k+1].requestFocus()
                        }
                        else{
                            var enteredCode = ""
                            for (j in editTextArr.indices){
                                enteredCode += editTextArr[j].text.toString()
                            }
                            if(enteredCode == i){
                                Log.d("request","verniy")
                                startActivity(intent)

                            }
                            else{
                                Log.d("request","ne verniy")
                                editText4.error = "Неверный код"
                            }
                        }
                    }
                    else{
                        if (k>0){
                            editTextArr[k-1].requestFocus()
                        }
                    }
                }

            })


        }



        if (button.visibility == View.INVISIBLE){
        timer.start()}
        else{
        }
    }

    fun onClickNewCode(view: View) {
        i = (1000..9999).random().toString()
        Log.d("code",i)
        textView.visibility = View.VISIBLE
        button.visibility = View.INVISIBLE
        timer.start()


    }
}