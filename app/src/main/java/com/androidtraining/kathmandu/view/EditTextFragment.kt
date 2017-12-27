package com.androidtraining.kathmandu.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.androidtraining.kathmandu.R
import kotlinx.android.synthetic.main.fragment_edit_text.*
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * A simple [Fragment] subclass.
 */
class EditTextFragment : Fragment(), TextWatcher {


    private val EMAIL_PATTERN = "^[a-zA-Z]+[a-zA-Z0-9!#\$%&'*+-/=?^_`{|}~;]*@[a-zA-Z]+[a-zA-Z0-9-]*[.][a-zA-Z]+\$"
    private val URL_PATTERN = "^((http(s)*|ftp|mailto|file|data|irc):\\/\\/){1}(([a-zA-Z]+[a-zA-Z0-9!#\$%&'*+-\\/=?^_`{|}~;]*)(:+[a-zA-Z0-9]+[a-zA-Z0-9!#\$%&'*+-\\/=?^_`{|}~;]*)?@?)?([[0-9A-Za-z]{1}[0-9a-zA-Z_.]{0,62}|(([0-9]{1,3}\\.){3}[0-9]{1,3}))(:{1}[0-9]+)*(\\/{1}[a-zA-Z0-9!#\$%&'*+-\\/=?^_`{|}~;]+)*\$"
    private val PHONE_PATTERN = "^(\\({1}\\+\\d{1,3}\\){1}|(\\+\\d{1,3}))?((\\d{4}[-.*_]{1}\\d{4})|((\\d{2}[-.*_]{1}){3}(\\d{2}){1}))+\$"
    private val YEAR_PATTERN = "([0-9]{2}|[0-9]{4})"
    private val MONTH_PATTERN = "(0?[1-9]{1}|[1-2]{1}[0-2]{1})"
    private val DAY_PATTERN = "([1-2]{1}\\d{0,1}|3{1}[0-1]{1}|0*[1-9]{1})"
    private val HOUR_PATTERN = "(0?\\d{1}|1{1}\\d{1}|2{1}[0-3]{1})"
    private val MINUTE_SECOND_PATTERN = "([0-5]{1}\\d{0,1})"
    private val DATE_TIME_PATTERN = "^("+DAY_PATTERN+"{1}[-_\\/.]{1}"+MONTH_PATTERN+"{1}[-_\\/.]{1}"+YEAR_PATTERN+"{1})\$"
    private var pattern = Pattern.compile(DATE_TIME_PATTERN)
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
