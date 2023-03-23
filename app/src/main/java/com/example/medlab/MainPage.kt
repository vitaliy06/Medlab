package com.example.medlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_page)


        val analyzesFragment = AnalysisFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView3,analyzesFragment).commit()



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_analyses -> {
                    // Действия при выборе элемента 1
                    val analyzesFragment = AnalysisFragment()
                    super.finish()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView3,analyzesFragment).commit()
                    true
                }
                R.id.nav_results -> {
                    // Действия при выборе элемента 2
                    val resultsFragment = ResultsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView3,resultsFragment).commit()
                    true
                }
                R.id.nav_support -> {
                    // Действия при выборе элемента 3
                    val supportFragment = SupportFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView3,supportFragment).commit()
                    true
                }
                R.id.nav_profile->{
                    //дейстивия при выборе элемента 4
                    val profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView3,profileFragment).commit()
                    true
                }
                else -> false
            }
        }

    }

}