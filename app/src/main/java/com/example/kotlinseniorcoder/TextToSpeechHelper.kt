package com.example.kotlinseniorcoder

import android.content.Context
import android.speech.tts.TextToSpeech

class TextToSpeechHelper(private val context: Context) {

    private var tts: TextToSpeech? = null

    init {
        initializeTextToSpeech()
    }

    private fun initializeTextToSpeech() {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                // Configurar configuraciones opcionales aquí si es necesario
            } else {
                // Manejar errores de inicialización, si los hay
            }
        }
    }

    fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }
}