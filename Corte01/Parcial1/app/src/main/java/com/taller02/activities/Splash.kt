package com.taller02.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.taller02.MainActivity
import com.taller02.R


class Splash : AppCompatActivity() {
    companion object {
        const val SPLASH_TIME_OUT = 1500L
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }

    override fun onPause() {
        super.onPause()
        Log.i(this@Splash::class.java.name, "onPause: Splash Activity is paused")
    }

    override fun onStop() {
        super.onStop()
        Log.i(this@Splash::class.java.name, "onStop: Splash Activity is in background")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(this@Splash::class.java.name, "on Destroy: Splash Activity is destroyed")
    }
}