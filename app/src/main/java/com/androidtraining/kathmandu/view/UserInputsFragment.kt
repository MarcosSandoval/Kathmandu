package com.androidtraining.kathmandu.view

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.androidtraining.kathmandu.R
import com.androidtraining.kathmandu.view.utils.PhoneTextWatcher
import com.androidtraining.kathmandu.view.utils.RegularExpresionValidator
import kotlinx.android.synthetic.main.fragment_user_inputs.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * A simple [Fragment] subclass.
 */
class UserInputsFragment : Fragment() {


    private val EMAIL_PATTERN = "^\\w+[\\w\\d!#\$%&'*+-/=?^_`{|}~;]*@\\w+[\\w\\d-]*[.]\\w+\$"
    private val URL_SHEME_PATTER = "((http(s)*|ftp|mailto|file|data|irc):\\/\\/){1}"
    private val USER_PASS_PATTERN = "((\\w+[\\w\\d!#\$%&'*+-\\/=?^_`{|}~;]+)(:+[\\w\\d]+[\\w\\d!#\$%&'*+-\\/=?^_`{|}~;]*){0,1}@{1}){0,1}"
    private val DOMAIN_PATTERN = "([\\d\\w]{1}[\\d\\w_.-]{0,62}|((\\d{1,3}\\.){3}\\d{1,3}))"
    private val PORT_PATTERN = "(:{1}\\d+){0,1}"
    private val PATH_PATTERN = "(\\/{1}[\\w\\d!#\$%&'*+-\\/=?^_`{|}~;]+){0,1}"
    private val URL_PATTERN = "^"+URL_SHEME_PATTER+USER_PASS_PATTERN+DOMAIN_PATTERN+PORT_PATTERN+PATH_PATTERN+"\$"
    private val PHONE_PATTERN = "^(\\({1}\\+\\d{1,3}\\){1}|(\\+\\d{1,3}))?((\\d{4}[-.*_]{1}\\d{4})|((\\d{2}[-.*_]{1}){3}(\\d{2}){1}))+\$"
    private val YEAR_PATTERN = "([0-9]{2}|[0-9]{4})"
    private val MONTH_PATTERN = "(0?[1-9]{1}|[1-2]{1}[0-2]{1})"
    private val DAY_PATTERN = "([1-2]{1}\\d{0,1}|3{1}[0-1]{1}|0*[1-9]{1})"
    private val HOUR_PATTERN = "(0?\\d{1}|1{1}\\d{1}|2{1}[0-3]{1})"
    private val MINUTE_SECOND_PATTERN = "([0-9]{1}|[0-5]{1}\\d{0,1})"
    private val DATE_TIME_PATTERN = "^((("+DAY_PATTERN+"{1}[-_\\/.]{1}"+MONTH_PATTERN+"{1}[-_\\/.]{1}"+YEAR_PATTERN+"{1})|" +
            "("+MONTH_PATTERN+"{1}[-_\\/.]{1}"+DAY_PATTERN+"{1}[-_\\/.]{1}"+YEAR_PATTERN+")){1})([ ]{1}"+HOUR_PATTERN+"[Hh:.]{1}"+
            MINUTE_SECOND_PATTERN+"[Mm:.]{1}("+MINUTE_SECOND_PATTERN+"[Ss]{0,1}){0,1}){0,1}\$"
    private lateinit var pattern : Pattern
    private lateinit var matcher : Matcher

    companion object {
        fun newInstance() : Fragment{
            return UserInputsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_user_inputs, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        ti_email.addTextChangedListener(RegularExpresionValidator(ti_email.id, til_email, matcherFunction))
        ti_url.addTextChangedListener(RegularExpresionValidator(ti_url.id, til_url, matcherFunction))
        ti_phone_number.addTextChangedListener(RegularExpresionValidator(ti_phone_number.id, til_phone_number, matcherFunction))
        ti_date_time.addTextChangedListener(RegularExpresionValidator(ti_date_time.id, til_date_time, matcherFunction))
        ti_phone_mask.addTextChangedListener(PhoneTextWatcher("(+###) ##-##-##-##"))
    }

    private var matcherFunction : (String, TextInputLayout, Int) -> Unit = {
        text, layout, editTextId ->
        var error = ""

        when(editTextId){
            ti_email.id -> {
                pattern = Pattern.compile(EMAIL_PATTERN)
                error = getString(R.string.wrong_email)
            }
            ti_url.id -> {
                pattern = Pattern.compile(URL_PATTERN)
                error = getString(R.string.wrong_url)
            }
            ti_phone_number.id -> {
                pattern = Pattern.compile(PHONE_PATTERN)
                error = getString(R.string.wrong_phone_number)
            }
            ti_date_time.id -> {
                pattern = Pattern.compile(DATE_TIME_PATTERN)
                error = getString(R.string.wrong_date)
            }
        }
        matcher = pattern.matcher(text)
        if(!matcher.matches()){
            layout.error = error
        }
        else{
            layout.isErrorEnabled = false
        }
    }
}
