package com.taller02

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.taller02.activities.LogIn
import com.taller02.activities.Register

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val login = findViewById<AppCompatButton>(R.id.start_btn)
        val register = findViewById<TextView>(R.id.register_redirect)

        login.setOnClickListener(redirect(LogIn::class.java))
        register.setOnClickListener(redirect(Register::class.java))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun <T : AppCompatActivity> redirect(to: Class<T>): View.OnClickListener {
        val intent = Intent(this, to)
        return View.OnClickListener {
            startActivity(intent)
        }
    }
}