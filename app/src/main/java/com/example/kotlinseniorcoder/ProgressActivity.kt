package com.example.kotlinseniorcoder

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinseniorcoder.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProgressBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("UserProgress", Context.MODE_PRIVATE)
        displayUserProgress()
    }

    private fun displayUserProgress() {
        val challengesCompleted = sharedPreferences.getInt("challengesCompleted", 0)
        val totalChallenges = 10 // Supongamos que hay 10 desafíos en total
        val progressPercentage = (challengesCompleted.toDouble() / totalChallenges * 100).toInt()

        binding.progressContent.text = "Has completado $challengesCompleted de $totalChallenges desafíos."
        binding.progressBar.progress = progressPercentage
    }
}