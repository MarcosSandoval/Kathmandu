package com.androidtraining.kathmandu.view.utils

import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher

/**
 * Created by Marcos on 20/12/2017.
 */
class PhoneTextWatcher(mask: String) : TextWatcher {
    private var phoneMask = mask
    private val maxLength = mask.length
    private var position = 0
    private var current = ""

    override fun afterTextChanged(editText: Editable) {
        var found = false
        val userInput = editText.toString()
        if(userInput != current){
            if(userInput.length <= maxLength){
                val sb = StringBuilder()
                var input = ""
                var currentMask = ""
                position = if (userInput.length < position)  userInput.length else position
                if(position != 0){
                    sb.append(userInput.substring(0, position))
                    input = userInput.substring(position, userInput.length)
                    currentMask = phoneMask.substring(position, phoneMask.length)
                }
                else{
                    input = userInput
                    currentMask = phoneMask
                }
                if(input.isNotEmpty()){
                    for(symbol in currentMask){
                        if (symbol == '#'){
                            if(!found){
                                sb.append(input)
                                found = true
                            }
                            else{
                                break
                            }
                        }
                        else{
                            sb.append(symbol)
                        }
                    }
                }
                current = sb.toString()
                position = current.length
                editText.filters = arrayOfNulls<InputFilter>(0)
            }
            editText.replace(0, editText.length, current, 0, current.length)
        }

    }

    override fun beforeTextChanged(p0: CharSequence?, startIndex: Int, count: Int, afterIndex: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
    }
}