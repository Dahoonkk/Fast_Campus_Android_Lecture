package com.example.ch4_medicalemergency

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ch4_medicalemergency.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goInputActivityButton.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java) // 명시적 Intent
            startActivity(intent)
        }

        binding.deleteButton.setOnClickListener {
            deleteData()
        }

        binding.phoneLayer.setOnClickListener {
            with(Intent(Intent.ACTION_VIEW)) { // 암시적 Intent
                val phoneNumber = binding.phoneValueTextView.text.toString()
                    .replace("-", "")
                data = Uri.parse("tel:$phoneNumber")
                startActivity(this)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataUiUpdate()
    }

    private fun getDataUiUpdate() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE)) {
            binding.nameValueTextView.text = getString(NAME, "미정")
            binding.birthdateValueTextView.text = getString(BIRTHDATE, "미정")
            binding.bloodTypeValueTextView.text = getString(BLOOD_TYPE, "미정")
            binding.phoneValueTextView.text = getString(EMERCENGY_CONTACT, "미정")
            val warning = getString(WARNING, "")

            binding.errorTextView.isVisible = warning.isNullOrEmpty().not()
            binding.errorValueTextView.isVisible = warning.isNullOrEmpty().not()
            if (!warning.isNullOrEmpty()) {
                binding.errorValueTextView.text = getString(WARNING, "미정")
            }
        }
    }

    private fun deleteData() {
        with(getSharedPreferences(USER_INFORMATION, MODE_PRIVATE).edit()) {
            clear() // 데이터 제거
            apply() // apply를 해줘야 데이터 추가 또는 제거가 적용됨
            getDataUiUpdate() // 데이터 제거 후 UI 업데이트
        }
        Toast.makeText(this, "초기화를 완료했습니다.", Toast.LENGTH_SHORT).show()
    }
}