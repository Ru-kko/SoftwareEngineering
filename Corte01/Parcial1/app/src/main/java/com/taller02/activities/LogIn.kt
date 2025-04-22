package com.taller02.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.error.InvalidDataException
import com.taller02.application.impl.SharedPreferencesUserService

class LogIn : AppCompatActivity() {
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        this.userService = SharedPreferencesUserService(getSharedPreferences(
            SharedPreferencesUserService.LOCAL_USER_STORE, MODE_PRIVATE))

        val register = findViewById<TextView>(R.id.register_redirect)
        val start = findViewById<AppCompatButton>(R.id.start_btn)
        val recovery = findViewById<TextView>(R.id.password_recovery)

        val emailInp = findViewById<EditText>(R.id.inp_account)
        val passwordInp = findViewById<EditText>(R.id.inp_psw)

        start.setOnClickListener {
            try {
                userService.login(
                    email = emailInp.text.toString(),
                    password = passwordInp.text.toString())
            } catch (e: InvalidDataException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } catch (e: Exception) {
                Toast.makeText(this, "Hubo un error en el sistema porfavor intentelo mas tarde", Toast.LENGTH_SHORT).show()
                Log.e(LogIn::class.java.name, e.message, e)
                return@setOnClickListener
            }

            startActivity(Intent(this, MainNavigation::class.java))
        }
        register.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
        recovery.setOnClickListener {
            startActivity(Intent(this, PasswordRecovery::class.java))
        }
    }
}