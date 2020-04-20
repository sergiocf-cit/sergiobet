package com.example.sergiobet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sergiobet.dao.AppDatabase
import com.example.sergiobet.databinding.ActivityLoginBinding
import com.example.sergiobet.service.NextMatchesApiService
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inflateBinding()
        initLoginName()
        initLoginButton()
    }

    private fun loadNextMatches() {
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/ ")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

        val service = retrofit.create(NextMatchesApiService::class.java)

        service.nextMatches().subscribeOn(Schedulers.io())
            .subscribe {
                AppDatabase.getDatabase(this).nextMatchesDao().deleteAll()
                AppDatabase.getDatabase(this).nextMatchesDao().insertAll(it)
            }
    }

    private fun initLoginButton() {
        binding.loginButton.setOnClickListener {

            if (isNotPasswordValid()) return@setOnClickListener

            loadNextMatches()

            startActivity(
                Intent(this, HomeActivity::class.java)
            )
        }
    }

    private fun isNotPasswordValid(): Boolean {
        if (binding.loginPassword.text.toString() != "123") {
            binding.loginPasswordLayout.error = "Password is wrong"
            return true
        }

        binding.loginPasswordLayout.error = null;
        return false
    }

    private fun initLoginName() {
        binding.loginName.setText(getPreferences(Context.MODE_PRIVATE).getString(LOGIN_NAME, ""))

        binding.loginName.setOnFocusChangeListener { _, _ ->
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

