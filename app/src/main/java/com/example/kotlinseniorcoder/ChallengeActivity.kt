package com.example.kotlinseniorcoder

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinseniorcoder.databinding.ActivityChallengeBinding

class ChallengeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChallengeBinding

    private val currentChallenge = Challenge(
        description = "Corrige el siguiente código para que compile correctamente.",
        code = "fun main() { println(Hello, World!) }",
        errors = listOf("Falta de comillas alrededor del texto en println.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.runButton.setOnClickListener {
            val userCode = binding.codeArea.text.toString()
            val errors = validateCode(userCode)
            if (errors.isEmpty()) {
                showMessage("¡Correcto!")
            } else {
                showMessage(errors.joinToString("\n"))
            }
        }

        binding.helpButton.setOnClickListener {
            showMessage(currentChallenge.errors.joinToString("\n"))
        }

        binding.hintButton.setOnClickListener {
            showMessage("Revisa la sintaxis de Kotlin para imprimir un mensaje.")
        }
    }

    private fun validateCode(userCode: String): List<String> {
        val errors = mutableListOf<String>()

        if (!userCode.contains("\"")) {
            errors.add("Error: Falta de comillas en el texto.")
        }

        return errors
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}