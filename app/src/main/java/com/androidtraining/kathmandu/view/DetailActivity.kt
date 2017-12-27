package com.androidtraining.kathmandu.view

import android.os.Bundle
import com.androidtraining.kathmandu.R

class DetailActivity : MasterDetail() {
    enum class DetailsViews {
        LINEAR_DETAILS_VIEW,
        RELATIVE_DETAILS_VIEW,
        CONSTRAINT_DETAILS_VIEW,
        OPTIMIZED_VIEW,
        USER_INPUTS_VIEW
    }

    companion object {
        val FRAGMENT_NAME_EXTRA = "fragment name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var extra = intent.getSerializableExtra(FRAGMENT_NAME_EXTRA) as DetailsViews?
        showDetailsFragment(extra)
    }
}
