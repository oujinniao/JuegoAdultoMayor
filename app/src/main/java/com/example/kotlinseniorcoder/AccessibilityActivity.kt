package com.example.kotlinseniorcoder

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kotlinseniorcoder.databinding.ActivityAccessibilityBinding

class AccessibilityActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccessibilityBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccessibilityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("AccessibilityPreferences", MODE_PRIVATE)
        initializeTextSize()
        initializeHighContrast()
        initializeTextToSpeech()
    }

    private fun initializeTextSize() {
        val textSize = sharedPreferences.getInt("textSize", 16)
        binding.textSizeSeekBar.progress = textSize
        binding.accessibilityTitle.textSize = textSize.toFloat()
        binding.textSizeLabel.textSize = textSize.toFloat()

        binding.textSizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.accessibilityTitle.textSize = progress.toFloat()
                binding.textSizeLabel.textSize = progress.toFloat()
                sharedPreferences.edit().putInt("textSize", progress).apply()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun initializeHighContrast() {
        val isHighContrast = sharedPreferences.getBoolean("highContrast", false)
        setHighContrastMode(isHighContrast)

        binding.highContrastButton.setOnClickListener {
            val newContrastSetting = !isHighContrast
            setHighContrastMode(newContrastSetting)
            sharedPreferences.edit().putBoolean("highContrast", newContrastSetting).apply()
        }
    }

    private fun setHighContrastMode(enabled: Boolean) {
        if (enabled) {
            binding.root.setBackgroundColor(ContextCompat.getColor(this, android.R.color.black))
            binding.accessibilityTitle.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            binding.textSizeLabel.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        } else {
            binding.root.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))
            binding.accessibilityTitle.setTextColor(ContextCompat.getColor(this, android.R.color.black))
            binding.textSizeLabel.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        }
    }

    private fun initializeTextToSpeech() {
        val ttsHelper = TextToSpeechHelper(this)

        binding.textToSpeechButton.setOnClickListener {
            ttsHelper.speak("Configuraciones de accesibilidad activadas")
        }
    }
}