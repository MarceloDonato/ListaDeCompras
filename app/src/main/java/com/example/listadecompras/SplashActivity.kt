package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        chengeToLogin()

    }

    fun chengeToLogin(){
        val intent = Intent(this, MainActivity ::class.java)

        Handler().postDelayed({
            intent.change()
        }, 5000)
    }
    fun Intent.change(){
        startActivity(this)
        finish()
    }
}