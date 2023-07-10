package com.example.part3_ch4_imageexractionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.part3_ch4_imageexractionapp.databinding.ActivityMainBinding
import com.example.part3_ch4_imageexractionapp.mvc.MvcActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
            it.view = this
        }
    }

    fun openMvc() {
        startActivity(Intent(this, MvcActivity::class.java))
    }

    fun openMvp() {

    }

    fun openMvvm() {

    }

    fun openMvi() {

    }
}