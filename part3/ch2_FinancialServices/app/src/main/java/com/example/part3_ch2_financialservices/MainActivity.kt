package com.example.part3_ch2_financialservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.part3_ch2_financialservices.databinding.ActivityMainBinding
import com.example.part3_ch2_financialservices.util.AppSignatureHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.view = this

        AppSignatureHelper(this).apply {
            Log.d("hash", "hash : ${appSignature}")
        }

    }

    fun openShuffle() {
        startActivity(Intent(this, PinActivity::class.java))
    }

    fun openVerifyOtp() {
        startActivity(Intent(this, IdentityInputActivity::class.java))
    }
}