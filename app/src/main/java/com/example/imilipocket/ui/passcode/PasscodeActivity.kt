package com.example.imilipocket.ui.passcode

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imilipocket.R
import com.example.imilipocket.databinding.ActivityPasscodeBinding
import com.example.imilipocket.ui.dashboard.DashboardActivity

class PasscodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPasscodeBinding
    private val correctPasscode = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasscodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.editName.text.toString().trim()                    // NEW
            val email = binding.editEmail.text.toString().trim()                  // NEW
            val password = binding.editPassword.text.toString()                   // NEW
            val rePassword = binding.editRePassword.text.toString()              // NEW

            // Validation logic
            if (name.isEmpty()) {
                binding.editName.error = "Name is required"
            } else if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editEmail.error = "Valid email is required"
            } else if (password.length < 6) {
                binding.editPassword.error = "Password must be at least 6 characters"
            } else if (password != rePassword) {
                binding.editRePassword.error = "Passwords do not match"
            } else {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                // Navigate to DashboardActivity
                val intent = Intent(this, DashboardActivity::class.java)         // NEW
                startActivity(intent)                                            // NEW
                finish()



            }
        }
    }
} 