package com.androidtraining.kathmandu.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.androidtraining.kathmandu.R


/**
 * A simple [Fragment] subclass.
 */
class DetailFragmentConstraint : Fragment() {

    companion object {
        fun newInstance() : Fragment{
            return DetailFragmentConstraint()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_detail_fragment_constraint, container, false)
    }

}// Required empty public constructor
