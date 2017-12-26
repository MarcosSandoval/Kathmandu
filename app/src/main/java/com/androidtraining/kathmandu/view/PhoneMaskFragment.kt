package com.androidtraining.kathmandu.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.androidtraining.kathmandu.R
import com.androidtraining.kathmandu.view.utils.PhoneTextWatcher
import kotlinx.android.synthetic.main.fragment_phone_mask.*


/**
 * A simple [Fragment] subclass.
 */
class PhoneMaskFragment : Fragment() {

    companion object {
        fun newInstance() : Fragment{
            return PhoneMaskFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_phone_mask, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
       // super.onViewCreated(view, savedInstanceState)
        et_phone.addTextChangedListener( PhoneTextWatcher("(+###) ####-####"))

    }
}
