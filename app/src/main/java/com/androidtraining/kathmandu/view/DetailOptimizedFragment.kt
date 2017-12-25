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
class DetailOptimizedFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment{
            return DetailOptimizedFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_detail_optimized, container, false)
    }

}// Required empty public constructor
