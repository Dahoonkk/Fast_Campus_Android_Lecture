package com.example.countnumapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberTextView = findViewById<TextView>(R.id.numberTextView)
        val resetBtn = findViewById<Button>(R.id.resetButton)
        val plusBtn = findViewById<Button>(R.id.plusButton)

        var number = 0

        resetBtn.setOnClickListener {
            number = 0
            numberTextView.text = number.toString()
            Log.d("onClick", "리셋 버튼이 클릭 됐습니다. 리셋된 숫자는 $number")
        }

        plusBtn.setOnClickListener {
            number += 1
            numberTextView.text = number.toString()
            Log.d("onClick", "+ 버튼이 클릭 됐습니다. 플러스된 숫자는 $number")
        }

    }
}