package com.example.kotlinseniorcoder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinseniorcoder.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    private val tutorials = listOf(
        Tutorial("Introducción a Kotlin", "Kotlin es un lenguaje de programación moderno..."),
        Tutorial("Variables y Tipos de Datos", "En Kotlin, las variables pueden ser declaradas usando las palabras clave 'val' o 'var'..."),
        // Agrega más tutoriales según sea necesario
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayTutorial(0) // Mostrar el primer tutorial al iniciar la actividad
    }

    private fun displayTutorial(index: Int) {
        if (index in tutorials.indices) {
            val tutorial = tutorials[index]
            binding.tutorialTitle.text = tutorial.title
            binding.tutorialContent.text = tutorial.content
        } else {
            binding.tutorialTitle.text = "Tutorial no encontrado"
            binding.tutorialContent.text = ""
        }
    }
}