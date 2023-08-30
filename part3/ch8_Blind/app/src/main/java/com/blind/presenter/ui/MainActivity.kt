package com.blind.presenter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.blind.R
import com.blind.databinding.ActivityMainBinding
import com.blind.domain.model.Content
import com.blind.presenter.ui.list.ListAdapter

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { ListAdapter(Handler()) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
        }
    }

    fun onClickAdd() {

    }

    inner class Handler {
        fun onClickItem(item : Content) {

        }

        fun onLongClickItem(item: Content) : Boolean {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("정말 삭제 하시겠습니까?")
                .setPositiveButton("네") { _, _ ->

                }
                .setNegativeButton("아니오") { _, _ ->

                }
                .show()

            return false
        }
    }
}