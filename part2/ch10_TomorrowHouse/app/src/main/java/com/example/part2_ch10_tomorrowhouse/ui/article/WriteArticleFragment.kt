package com.example.part2_ch10_tomorrowhouse.ui.article

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.part2_ch10_tomorrowhouse.R
import com.example.part2_ch10_tomorrowhouse.databinding.FragmentWriteBinding

class WriteArticleFragment : Fragment(R.layout.fragment_write) {

    private lateinit var binding : FragmentWriteBinding

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if(uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWriteBinding.bind(view)

        pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

}