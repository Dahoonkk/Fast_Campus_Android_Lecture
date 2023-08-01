package com.example.part3_ch4_imageexractionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.part3_ch4_imageexractionapp.databinding.ActivityMainBinding
import com.example.part3_ch4_imageexractionapp.mvc.MvcActivity
import com.example.part3_ch4_imageexractionapp.mvi.MviActivity
import com.example.part3_ch4_imageexractionapp.mvp.MvpActivity
import com.example.part3_ch4_imageexractionapp.mvvm.MvvmActivity

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
        startActivity(Intent(this, MvpActivity::class.java))
    }

    fun openMvvm() {
        startActivity(Intent(this, MvvmActivity::class.java))
    }

    fun openMvi() {
        startActivity(Intent(this, MviActivity::class.java))
    }
}