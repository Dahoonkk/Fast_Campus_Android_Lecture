package com.example.part2_ch5_newsapp

import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.part2_ch5_newsapp.databinding.ActivityWebviewBinding

class WebViewActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")

        binding.webView.webViewClient = WebViewClient()  // webview client 지정
        binding.webView.settings.javaScriptEnabled = true

        if (url.isNullOrEmpty()) {  // url이 null인 경우
            Toast.makeText(this, "잘못된 URL 입니다.", Toast.LENGTH_SHORT).show()
            finish()
        } else {  // 그 외의 경우 webview에 불러오기
            binding.webView.loadUrl(url)
        }


    }
}