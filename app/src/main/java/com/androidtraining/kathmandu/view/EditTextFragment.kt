package com.androidtraining.kathmandu.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

import com.androidtraining.kathmandu.R
import kotlinx.android.synthetic.main.fragment_edit_text.*
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * A simple [Fragment] subclass.
 */
class EditTextFragment : Fragment(), TextWatcher {


    private final val EMAIL_PATTERN = "^[a-zA-Z]+[a-zA-Z0-9!#\$%&'*+-/=?^_`{|}~;]*@[a-zA-Z]+[a-zA-Z0-9-]*[.][a-zA-Z]+\$"
    private var pattern = Pattern.compile(EMAIL_PATTERN)
    private lateinit var matcher : Matcher

    companion object {
        fun newInstance() : Fragment{
            return EditTextFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_edit_text, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        ti_email.addTextChangedListener(this)
    }

    override fun afterTextChanged(p0: Editable?) {
        var email = p0.toString()
        if (email != "" && !validateEmail(p0.toString())){
            til_email.error = "Wrong email"
        }
        else{
            til_email.isErrorEnabled = false
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    fun validateEmail(email: String) : Boolean{
        matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
