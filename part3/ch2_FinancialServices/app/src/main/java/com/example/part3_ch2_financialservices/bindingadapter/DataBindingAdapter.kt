package com.example.part3_ch2_financialservices.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.part3_ch2_financialservices.R

@BindingAdapter(value = ["code_text", "code_index"])
fun ImageView.setPin(codeText: CharSequence?, index: Int) {
    if(codeText != null) {
        if(codeText.length > index) {
            setImageResource(R.drawable.baseline_circle_black24)
        } else {
            setImageResource(R.drawable.baseline_circle_gray24)
        }
    }
}