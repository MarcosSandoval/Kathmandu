package com.androidtraining.kathmandu.view.utils

import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.TextWatcher

/**
 * Created by marcos on 12/27/17.
 */
class RegularExpresionValidator : TextWatcher{

    var validatorFunction : (text : String, layout : TextInputLayout, viewId: Int) -> Unit
    var editTextId : Int
    var textInputLayout : TextInputLayout

    constructor(id: Int, layout: TextInputLayout, validator : (text: String, layout : TextInputLayout, viewId: Int) -> Unit){
        validatorFunction = validator
        editTextId = id
        textInputLayout = layout
    }

    override fun afterTextChanged(p0: Editable?) {
        var text = p0.toString()
        if(text != ""){
            validatorFunction(text,textInputLayout, editTextId)
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}