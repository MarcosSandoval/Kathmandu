package com.androidtraining.kathmandu.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.androidtraining.kathmandu.R

/**
 * Created by marcos on 12/4/17.
 */
open class MasterDetail : AppCompatActivity(){



    private var isLargeScreen  = false


    protected fun setScreenSize(largeScreen : Boolean) {
        isLargeScreen = largeScreen
    }

    protected fun showDefaultDetail(){
        if (isLargeScreen) {
            showDetailsFragment(DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW)
        }
    }


    protected fun showDetailsLinear(){
        if(!isLargeScreen){
            showDetailsActivity(DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW)
        }
        else{
            showDetailsFragment(DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW)
        }
    }

    protected fun showDetailsRelative(){
        if(!isLargeScreen){
            showDetailsActivity(DetailActivity.DetailsViews.RELATIVE_DETAILS_VIEW)
        }
        else{
            showDetailsFragment(DetailActivity.DetailsViews.RELATIVE_DETAILS_VIEW)
        }
    }

    protected fun showDetailsConstraint(){
        if(!isLargeScreen){
            showDetailsActivity(DetailActivity.DetailsViews.CONSTRAINT_DETAILS_VIEW)
        }
        else{
            showDetailsFragment(DetailActivity.DetailsViews.CONSTRAINT_DETAILS_VIEW)
        }
    }

    protected fun showDetailsFragment(viewsId: DetailActivity.DetailsViews?){
        when(viewsId){
            DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW -> supportFragmentManager.beginTransaction().replace(R.id.details_layout,  DetailFragmentLinear.newInstance()).commit()
            DetailActivity.DetailsViews.RELATIVE_DETAILS_VIEW -> supportFragmentManager.beginTransaction().replace(R.id.details_layout,  DetailFragmentRelative.newInstance()).commit()
            DetailActivity.DetailsViews.CONSTRAINT_DETAILS_VIEW -> supportFragmentManager.beginTransaction().replace(R.id.details_layout,  DetailFragmentConstraint.newInstance()).commit()
            else -> supportFragmentManager.beginTransaction().replace(R.id.details_layout,  DetailFragmentLinear.newInstance()).commit()
        }
    }

    private fun showDetailsActivity(viewsId: DetailActivity.DetailsViews?){
        var intent = Intent(applicationContext, DetailActivity::class.java)
        when(viewsId){
            DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW -> intent.putExtra(DetailActivity.FRAGMENT_NAME_EXTRA, DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW)
            DetailActivity.DetailsViews.RELATIVE_DETAILS_VIEW -> intent.putExtra(DetailActivity.FRAGMENT_NAME_EXTRA, DetailActivity.DetailsViews.RELATIVE_DETAILS_VIEW)
            DetailActivity.DetailsViews.CONSTRAINT_DETAILS_VIEW -> intent.putExtra(DetailActivity.FRAGMENT_NAME_EXTRA, DetailActivity.DetailsViews.CONSTRAINT_DETAILS_VIEW)
            else -> intent.putExtra(DetailActivity.FRAGMENT_NAME_EXTRA, DetailActivity.DetailsViews.LINEAR_DETAILS_VIEW)
        }
        startActivity(intent)
    }
}