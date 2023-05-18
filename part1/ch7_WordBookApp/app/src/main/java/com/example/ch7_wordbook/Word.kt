package com.example.ch7_wordbook

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize // 직렬화
@Entity(tableName = "word")
data class Word(
    val text : String,
    val mean : String,
    val type : String,
    @PrimaryKey(autoGenerate = true)val id: Int = 0,
) : Parcelable
