package com.example.part2_ch3_daynotice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextview = findViewById<EditText>(R.id.serverHostEditText)
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        val informationTextView = findViewById<TextView>(R.id.informationTextView)
        val client = OkHttpClient() // Request를 먼저 만들어준 다음 클라이언트에게 call 해달라고 요청하는 방식을 활용
        var serverHost = ""

        editTextview.addTextChangedListener {
            serverHost = it.toString()
        }

        confirmButton.setOnClickListener {
            val request: Request = Request.Builder()
                .url("http://$serverHost:8080")  // 안드로이드는 기본적으로 http 통신이 막혀있음 -> 실습을 위해 Manifest에 <application> 태그 안에 android:usesCleartextTraffic="true" 추가
                .build()

            val callback = object: Callback {
                override fun onFailure(call: Call, e: IOException) {

                    runOnUiThread {
                        Toast.makeText(this@MainActivity, "수신에 실패했습니다.", Toast.LENGTH_SHORT).show() // MainActivity의 Context에 넘겨줌
                    }
                    Log.e("Client", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.isSuccessful) {
                        val response = response.body?.string()

                        val message = Gson().fromJson(response, message::class.java) // Gson을 활용해 Json 파일 읽어오기

                        runOnUiThread {
                            informationTextView.isVisible = true
                            informationTextView.text = message.msg
                            Log.e("Client", "$message.msg")

                            editTextview.isVisible = false
                            confirmButton.isVisible = false
                        }
                    } else {
                        runOnUiThread { Toast.makeText(this@MainActivity, "수신에 실패했습니다.", Toast.LENGTH_SHORT).show() } // MainActivity의 Context에 넘겨줌
                    }
                }

            }

            client.newCall(request).enqueue(callback)
        }


        /*
        try {
            val response = client.newCall(request).enqueue() // execute()는 직접 실행이어서 스레드 블락이 생기게 됨 -> 멈춘다. -> 그럼 어떻게 호출? 콜백 활용

            Log.e("Client", "${response.body?.string()}") // "<h1> Hello World </h1> 부분을 가져옴
        } catch(e: Exception) {
            Log.e("Client", e.toString())
        }
         */

        /* 소켓 구현방식
        Thread {
            try {
                val socket = Socket("10.0.2.2", 8080)  // 애뮬레이터 한정 localhost -> 소켓을 직접 열었
                val printer = PrintWriter(socket.getOutputStream())
                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))

                // 데이터를 직접 활
                printer.println("GET / HTTP/1.1")
                printer.println("Host: 127.0.0.1:8080")
                printer.println("User-Agent: android")
                printer.println("\r\n")
                printer.flush()

                // 데이터를 직접 읽었음
                var input: String? = "-1"
                while(input != null) {
                    input = reader.readLine()
                    Log.e("Client", "$input")
                }

                // 소켓을 직접 닫아주었음
                reader.close()
                printer.close()
                socket.close()
            } catch (e: Exception) {
                Log.e("Client", e.toString())
            }

        }.start()
        */

    }
}