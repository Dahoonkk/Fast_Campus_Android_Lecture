package com.example.ch3_unitconvertapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.ch3_unitconvertapp.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // lateinit으로 초기화 지연
    var cmToM = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        // view binding의 끝

        val outputTextView = binding.outputTextView
        val outputUnitTExtView = binding.outputUnitTextView
        val inputEditText = binding.inputEditText
        val inputUnitTextView = binding.inputUnitTextView
        val imageButton = binding.imageButton

        var inputNumber : Int = 0

        inputEditText.addTextChangedListener { text ->
            inputNumber = if (text.isNullOrEmpty()) {
                0
            } else {
                text.toString().toInt()
            }

            var outputNumber = inputNumber.times(0.01)
            outputTextView.text = outputNumber.toString()

            if(cmToM) {
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }

            Log.d("inputNumber", inputNumber.toString())
        }

        imageButton.setOnClickListener{
            cmToM = cmToM.not()
            if(cmToM) {
                inputUnitTextView.text = "cm"
                outputUnitTExtView.text = "m"
                outputTextView.text = inputNumber.times(0.01).toString()
            } else {
                inputUnitTextView.text = "m"
                outputUnitTExtView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }

    // 하위 메소드들은 상태 저장을 위한 메소드
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean("cmToM", cmToM)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        cmToM = savedInstanceState.getBoolean("cmToM")
        Log.d("cmToM", cmToM.toString())
        binding.inputUnitTextView.text = if(cmToM) "cm" else "m"
        binding.outputUnitTextView.text = if(cmToM) "m" else "cm"
        super.onRestoreInstanceState(savedInstanceState)
    }
}