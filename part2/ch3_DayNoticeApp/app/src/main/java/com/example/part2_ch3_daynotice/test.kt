package com.example.part2_ch3_daynotice

import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    Thread {
        val port = 8080
        val server = ServerSocket(port)
        // Blocking 걸릴 수 있음

        while(true) {
            val socket = server.accept()  // 소켓이 튀어나왔다는 의미

            /*
            socket.getInputStream() // 클라이언트로부터 들어오는 스트림 == 클라이언트 socket.outputStream
            socket.getOutputStream() // 클라이언에게 데이터를 주는 스트림 == 클라이언트 socket.inputStream
             */

            val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
            val printer = PrintWriter(socket.getOutputStream())

            var input: String? = "-1"
            while (input != null && input != "") {
                input = reader.readLine()
            }

            println("READ DATA $input")

            // HEADER
            printer.println("HTTP/1.1 200 OK")
            printer.println("Content-Type: text/html\r\n")  // header 부

            // BODY
            printer.println("\"message\" : \"Hello World\"")
            printer.println("\r\n")
            printer.flush()
            printer.close()

            reader.close()

            socket.close()
        }
    }.start()
}