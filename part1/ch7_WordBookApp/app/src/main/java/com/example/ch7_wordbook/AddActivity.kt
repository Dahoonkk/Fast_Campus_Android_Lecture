package com.example.ch7_wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.children
import androidx.core.widget.addTextChangedListener
import com.example.ch7_wordbook.databinding.ActivityAddBinding
import com.google.android.material.chip.Chip

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    private var originWord : Word? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        binding.addButton.setOnClickListener {
            if(originWord == null) add() else edit()
        }
    }

    private fun initViews() {
        val types = listOf(
            "명사", "동사", "대명사", "형용사", "부사", "감탄사", "전치사", "접속사"
        )
        binding.typeChipGroup.apply {
            types.forEach { text ->
                addView(createChip(text))
            }
        }

        binding.textInputEditText.addTextChangedListener {
            it?.let {text ->
                binding.textTextInputLayout.error = when(text.length) {
                    0 -> "값을 입력해주세요"
                    1 -> "2자 이상을 입력해주세요"
                    else -> null
                }

            }
        }

        originWord = intent.getParcelableExtra("originWord")
        originWord?.let {word ->
            binding.textInputEditText.setText(word.text)
            binding.meanTextInputEditText.setText(word.text)
            val selectedChip = binding.typeChipGroup.children.firstOrNull { (it as Chip).text == word.type} as? Chip
            selectedChip?.isChecked = true
        }
    }

    private fun createChip(text: String): Chip {
        return Chip(this).apply {
            setText(text)
            isCheckable = true
            isClickable = true
        }
    }

    private fun add() {
        val text = binding.textInputEditText.text.toString()
        val mean = binding.meanTextInputEditText.text.toString()
        val type = findViewById<Chip>(binding.typeChipGroup.checkedChipId).text.toString() // selected된 chip 타입을 받아옴
        val word = Word(text, mean, type)

        Thread { // thread로 선언해줘야 UI에 잘 뜨게 된다. 안 그러면 Log에서 에러를 볼 수 있을 것.
            AppDatabase.getInstance(this)?.wordDao()?.insert(word)
            runOnUiThread {
                Toast.makeText(this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
            }
            val intent = intent.putExtra("isUpdated", true)
            setResult(RESULT_OK, intent)  // 활동이 완료되면 registerForActivityResult에게 넘겨줌
            finish()
        }.start()

    }

    private fun edit() {
        val text = binding.textInputEditText.text.toString()
        val mean = binding.meanTextInputEditText.text.toString()
        val type = findViewById<Chip>(binding.typeChipGroup.checkedChipId).text.toString() // selected된 chip 타입을 받아옴
        val editWord = originWord?.copy(text = text, mean = mean, type = type)

        Thread {
            editWord?.let {word ->
                AppDatabase.getInstance(this)?.wordDao()?.update(word)
                val intent = Intent().putExtra("editWord", editWord)
                setResult(RESULT_OK, intent)
                runOnUiThread {
                    Toast.makeText(this, "수정이 완료됐습니다.", Toast.LENGTH_SHORT).show()
                }
                finish()
            }
        }.start()
    }
}