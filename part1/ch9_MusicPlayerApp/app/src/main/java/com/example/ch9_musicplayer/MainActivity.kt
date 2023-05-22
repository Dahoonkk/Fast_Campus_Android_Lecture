package com.example.ch9_musicplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch9_musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener { mediaPlayerPlay() }
        binding.pauseButton.setOnClickListener { mediaPlayPause() }
        binding.stopButton.setOnClickListener { mediaPlayStop() }
    }

    private fun mediaPlayStop() {
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply{ action = MEDIA_PLAYER_STOP }
        startService(intent)
    }

    private fun mediaPlayPause() {
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply{ action = MEDIA_PLAYER_PAUSE }
        startService(intent)
    }

    private fun mediaPlayerPlay() {
        val intent = Intent(this, MediaPlayerService::class.java)
            .apply{ action = MEDIA_PLAYER_PLAY }
        startService(intent)
        /*
        if(mediaPlayer==null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.yangdail_this_night).apply {
                isLooping = true
            }
        }
        mediaPlayer?.start()

         */
    }

    override fun onDestroy() {
        stopService(Intent(this, MediaPlayerService::class.java))
        super.onDestroy()
    }
}