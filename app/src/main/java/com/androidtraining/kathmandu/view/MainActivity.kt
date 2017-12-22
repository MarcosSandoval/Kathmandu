package com.androidtraining.kathmandu.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.androidtraining.kathmandu.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_master.*

class MainActivity : MasterDetail(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setScreenSize(details_layout != null)
        btn_goToLinear.setOnClickListener(this)
        btn_GoToRelative.setOnClickListener(this)
        btn_goToContraint.setOnClickListener(this)
        btn_goToOptimized.setOnClickListener(this)
        btn_goToEditText.setOnClickListener(this)
        showDefaultDetail()

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_goToLinear -> showDetailsLinear()
            R.id.btn_GoToRelative -> showDetailsRelative()
            R.id.btn_goToOptimized -> showDetailsOptimized()
            R.id.btn_goToEditText -> showDetailsEditText()
            else -> showDetailsConstraint()
        }
    }
}
