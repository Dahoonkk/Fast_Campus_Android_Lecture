package com.example.ch7_wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch7_wordbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), WordAdapter.ItemClickListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var wordadapter : WordAdapter
    private var selectedWord:Word? = null
    private val updateAddWordResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val isUpdated = result.data?.getBooleanExtra("isUpdated", false) ?: false

        if(result.resultCode == RESULT_OK && isUpdated) {
            updateAddWord()
        }
    }

    private val updateEditWordResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val editWord = result.data?.getParcelableExtra<Word>("editWord")

        if(result.resultCode == RESULT_OK && editWord != null) {
            updateEditWord(editWord)
        }
    }

    private fun updateEditWord(word: Word) {
        val index = wordadapter.list.indexOfFirst{it.id == word.id}
        wordadapter.list[index] = word
        runOnUiThread {
            selectedWord = word
            wordadapter.notifyItemChanged(index)
            binding.textTextView.text = word.text
            binding.meanTextView.text = word.mean
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.addButton.setOnClickListener {
            Intent(this, AddActivity::class.java).let {
                updateAddWordResult.launch(it)
            }
        }

        binding.deleteImageView.setOnClickListener {
            delete()
        }

        binding.editImageView.setOnClickListener {
            edit()
        }
    }

    private fun edit() {
        if(selectedWord == null) return

        val intent = Intent(this, AddActivity::class.java).putExtra("originWord", selectedWord)
        updateEditWordResult.launch(intent)
    }

    private fun initRecyclerView() {
        wordadapter = WordAdapter(mutableListOf(), this) // click 리스너 설정해줬을 때 this까지 추가해주는거 잊으면 안됨
        binding.wordRecyclerView.apply {
            adapter = wordadapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            val dividerItemDecoration = DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }

        Thread {
            val list = AppDatabase.getInstance(this)?.wordDao()?.getAll() ?: emptyList()
            Thread.sleep(1000)
            wordadapter.list.addAll(list)  // adapter에 list를 넣었다고 해서 데이터를 load하는 것은 아님
            // adpater는 데이터가 변화한 것을 알 수 없음
            // 화면을 load할 때 데이터가 있는 list가 있어야 화면에 보여주는 것
            // 다라서 list가 업데이트 되면 adpater에게 알려주는 것은 필수적
            runOnUiThread { wordadapter.notifyDataSetChanged()} // 따라서 데이터가 변화하게 되면 adapter에게 알려줘서 ui가 변경되도록 해야함
            // 그렇기 때문에 runOnUiThread안에 notifyDataSetChanged를 선언해주는 것
            // adapter를 사용할 때 가장 주의해야할 것은 IndexOutOfBoundsExcpetion임
            // 포지션 값에 대해 exception이 발생할 수 있기 때문에 이를 주의해서 사용해야 함
        }.start()
    }

    private fun updateAddWord() {
          Thread {
              AppDatabase.getInstance(this)?.wordDao()?.getLatestWord()?.let { word ->
                  wordadapter.list.add(0, word)
                  runOnUiThread {
                      wordadapter.notifyDataSetChanged()
                  }
              }
          }.start()
    }

    private fun delete() {
        if(selectedWord == null) return
        Thread {
            selectedWord?.let {word ->
                AppDatabase.getInstance(this)?.wordDao()?.delete(word)
                runOnUiThread{
                    wordadapter.list.remove(word)
                    wordadapter.notifyDataSetChanged()
                    binding.textTextView.text = ""
                    binding.meanTextView.text = ""
                    Toast.makeText(this, "삭제가 완료됐습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    override fun onClick(word: Word) {
        selectedWord = word
        binding.textTextView.text = word.text
        binding.meanTextView.text = word.mean
        Toast.makeText(this, "${word.text}가 클릭 됐습니다", Toast.LENGTH_SHORT).show();
    }
}