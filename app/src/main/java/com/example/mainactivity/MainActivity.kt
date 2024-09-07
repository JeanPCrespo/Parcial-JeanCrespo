package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
// Parcial Jean Paul Crespo 92320024
    companion object {
        const val VALID_USERNAME = "uac123"
        const val VALID_PASSWORD = "12345678"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etUsername = findViewById<EditText>(R.id.Usuario)
        val etPassword = findViewById<EditText>(R.id.Contraseña)
        val btnLogin = findViewById<Button>(R.id.BotonLogin)
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            when {
                username.isEmpty() || password.isEmpty() -> {
                    showToast("Llene los campos")
                }
                username == VALID_USERNAME && password == VALID_PASSWORD -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    showToast("Usuario o contraseña incorrectos")
                }
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
