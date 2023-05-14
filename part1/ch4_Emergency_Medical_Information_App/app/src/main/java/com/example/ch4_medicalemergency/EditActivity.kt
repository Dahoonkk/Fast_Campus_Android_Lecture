package com.example.ch4_medicalemergency

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ch4_medicalemergency.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bloodtypeSpinner.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_list_item_1
        )

        binding.birthdateLayer.setOnClickListener {
            val listener = OnDateSetListener { _, year, month, dayOfMonth ->
                binding.birthdateValueTextView.text = "$year-${month.inc()}-$dayOfMonth"
            }
            DatePickerDialog(
                this,
                listener,
                2023,
                6,
                13
            ).show() // show를 해줘야 datepicker가 보임
        }

        binding.wargningCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.errorEditText.isVisible = isChecked
        }

        binding.errorEditText.isVisible = binding.wargningCheckBox.isChecked

        binding.saveButton.setOnClickListener {
            saveData()
            finish()
        }
    }
    private fun saveData() {
        with(getSharedPreferences(USER_INFORMATION, Context.MODE_PRIVATE).edit()) {
            putString(NAME, binding.nameEditText.text.toString())
            putString(BIRTHDATE, binding.birthdateValueTextView.text.toString())
            putString(BLOOD_TYPE, getBloodType())
            putString(EMERCENGY_CONTACT, binding.phoneValueEditText.text.toString())
            putString(WARNING, getWarning())
            apply()
        }
        Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show()
    }

    private fun getBloodType() : String {
        val bloodAlphabet = binding.bloodtypeSpinner.selectedItem.toString()
        val bloodSign = if(binding.bloodTypePlus.isChecked) "+" else "-"
        return "$bloodSign$bloodAlphabet"
    }

    private fun getWarning() : String {
        return if(binding.wargningCheckBox.isChecked) binding.errorEditText.text.toString() else ""
    }
}