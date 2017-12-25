package com.androidtraining.kathmandu.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidtraining.kathmandu.R
import kotlinx.android.synthetic.main.fragment_master.*


/**
 * A simple [Fragment] subclass.
 */
class MasterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_master, container, false)
        return view
    }
}
