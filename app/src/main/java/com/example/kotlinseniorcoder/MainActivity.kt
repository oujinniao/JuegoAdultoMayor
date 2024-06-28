package com.example.kotlinseniorcoder

import android.content.Intent
import android.os.Bundle

import com.example.kotlinseniorcoder.AccessibilityActivity
import com.example.kotlinseniorcoder.ChallengeActivity
import com.example.kotlinseniorcoder.ProgressActivity
import com.example.kotlinseniorcoder.TutorialActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinseniorcoder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            val intent = Intent(this, ChallengeActivity::class.java)
            startActivity(intent)
        }

        binding.tutorialButton.setOnClickListener {
            val intent = Intent(this, TutorialActivity::class.java)
            startActivity(intent)
        }

        binding.progressButton.setOnClickListener {
            val intent = Intent(this, ProgressActivity::class.java)
            startActivity(intent)
        }

        binding.accessibilityButton.setOnClickListener {
            val intent = Intent(this, AccessibilityActivity::class.java)
            startActivity(intent)
        }
    }
}