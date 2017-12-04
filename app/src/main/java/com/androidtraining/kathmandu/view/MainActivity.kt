package com.androidtraining.kathmandu.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidtraining.kathmandu.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_master.*

class MainActivity : AppCompatActivity() {

    var isLargeScreen = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isLargeScreen = details_layout != null
        btn_goToLinear.setOnClickListener { showDetails()}

    }

    private fun showDetails(){
        if(!isLargeScreen){
            var intent = Intent(applicationContext, DetailActivity::class.java)
            startActivity(intent)
        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.details_layout,  DetailFragmentLinear.newInstance())
        }
    }
}
