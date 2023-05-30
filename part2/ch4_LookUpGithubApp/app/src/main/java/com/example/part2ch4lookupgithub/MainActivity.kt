package com.example.part2ch4lookupgithub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.part2ch4lookupgithub.adapter.UserAdapter
import com.example.part2ch4lookupgithub.databinding.ActivityMainBinding
import com.example.part2ch4lookupgithub.model.UserDto
import com.example.part2ch4lookupgithub.network.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter

    private val handler = Handler(Looper.getMainLooper())
    private var searchFor: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter {
            val intent = Intent(this@MainActivity, RepoActivity::class.java)
            intent.putExtra("username", it.username)
            startActivity(intent)
        }

        binding.userRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }

        // RxJava와 같은 기능 구현해보기 위한 Runnable 객체 및 Handler 연습
        //  이 기능을 통해 editText 입력이 끝나여 레포 조회를 진행한다.
        val runnable = Runnable {
            searchUser()
        }

        binding.searchEditText.addTextChangedListener {
            searchFor = it.toString()
            handler.removeCallbacks(runnable)
            handler.postDelayed(
                runnable,
                3,
            )
        }

    }

    private fun searchUser() {
        val githubService = APIClient.retrofit.create(GithubService::class.java)

        githubService.searchUsers(searchFor).enqueue(object : Callback<UserDto> {
            override fun onResponse(call: Call<UserDto>, response: Response<UserDto>) {
                Log.e("MainActivity", "Search User : ${response.body().toString()}")
                userAdapter.submitList(response.body()?.items)
            }

            override fun onFailure(call: Call<UserDto>, t: Throwable) {
                Toast.makeText(this@MainActivity, "에러가 발생했습니다.", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }

        })
    }
}