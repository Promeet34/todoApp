package com.promeet.todoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        val firstFragment = FirstFragment()
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, firstFragment).commit()

        bottomNavi.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first -> {
                    val first = FirstFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, first).commit()
                }
                R.id.second -> {
                    val second = SecondFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, second).commit()
                }
            }
            false
        }
    }
}
