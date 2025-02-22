package com.taller02.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.taller02.MainActivity
import com.taller02.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@Splash, MainActivity::class.java))
            finish()
        }
    }
}