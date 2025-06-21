package com.example.codexone

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to the views
        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val forgotPasswordText: TextView = findViewById(R.id.forgotPasswordText)
        val helpButton: Button = findViewById(R.id.helpButton)

        // Set a click listener for the login button
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Basic validation
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // In a real app, you would check credentials here
                // For this example, we'll just show a Toast
                Toast.makeText(this, "Logged in successfully", Toast.LENGTH_SHORT).show()

                // You can navigate to another activity if login is successful
            }
        }

        helpButton.setOnClickListener {
            Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show()
        }

        // Set a click listener for the forgot password text
        forgotPasswordText.setOnClickListener {
            // Handle forgot password click (e.g., open a new screen or display a message)
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show()
        }
    }
}