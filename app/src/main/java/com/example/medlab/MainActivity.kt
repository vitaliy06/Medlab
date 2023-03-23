package com.example.medlab

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.RecoverySystem
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import org.w3c.dom.Text
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2

    private lateinit var imageList:ArrayList<Int>
    private lateinit var textList:ArrayList<String>
    private lateinit var textDescrpList:ArrayList<String>
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val sh = getSharedPreferences("data",Context.MODE_PRIVATE)
        val pincode = sh.getString("pin","")
        Log.d("pin",pincode.toString())

            init( )
            val viewPager = findViewById<ViewPager2>(R.id.viewPager2)


            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    val textview = findViewById<TextView>(R.id.textView)

                    if(position==2){
                        Log.d("position",position.toString())
                        textview.text = "Завершить"
                        val sh = getSharedPreferences("data",Context.MODE_PRIVATE)
                        val pincode = sh.getString("pin","")
                        Log.d("pin",pincode.toString())
                    }
                    else{
                        Log.d("position",position.toString())
                        textview.text = "Пропустить"
                        val sh = getSharedPreferences("data",Context.MODE_PRIVATE)
                        val pincode = sh.getString("pin","")
                        Log.d("pin",pincode.toString())
                    }
                }
            })




    }



    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)

        imageList = ArrayList()
        textList = ArrayList()
        textDescrpList = ArrayList()

        textDescrpList.add("Эксресс сбор и получение проб")
        textDescrpList.add("Вы быстро узнаете о результатах")
        textDescrpList.add("Наши врачи всегда наблюдают за вашими показателями здоровья")


        textList.add("Анализы")
        textList.add("Уведомления")
        textList.add("Мониторинг")

        imageList.add(R.drawable.colb)
        imageList.add(R.drawable.male)
        imageList.add(R.drawable.women)
        adapter = ImageAdapter(imageList, viewPager2,textList,textDescrpList)




        viewPager2.adapter =  adapter



    }

    fun onTextClick(view: View) {
        val text = view.findViewById<TextView>(R.id.textView)
        val intent = Intent(this, enter::class.java)
        if(text.text.toString()=="Заврешить"){
            startActivity(intent)
        }
        else{
            startActivity(intent)
        }

    }

}


