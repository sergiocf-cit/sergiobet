package com.example.sergiobet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sergiobet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflateBinding()
        initLoginName()

        binding.loginButton.setOnClickListener {

            if (isPasswordValid()) return@setOnClickListener

            startActivity(
                Intent(this, HomeActivity::class.java)
            )
        }
    }

    private fun isPasswordValid(): Boolean {
        if (binding.loginPassword.text.toString() != "123") {
            binding.loginPasswordLayout.error = "Password is wrong"
            return true
        }

        binding.loginPasswordLayout.error = null;
        return false
    }

    private fun initLoginName() {
        binding.loginName.setText(getPreferences(Context.MODE_PRIVATE).getString(LOGIN_NAME, ""))

        binding.loginName.setOnFocusChangeListener { v, hasFocus ->
            getPreferences(Context.MODE_PRIVATE).edit()
                .putString(LOGIN_NAME, binding.loginName.text.toString()).apply()
        }
    }

    private fun inflateBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}

private const val LOGIN_NAME = "LOGIN_NAME"

