package com.taller02.activities

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.impl.SharedPreferencesUserService

class PasswordRecovery : AppCompatActivity() {
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.password_recovery)

        this.userService = SharedPreferencesUserService(getSharedPreferences(
            SharedPreferencesUserService.LOCAL_USER_STORE, MODE_PRIVATE))

        val emailInp = findViewById<EditText>(R.id.inp_email)
        val submitBtn = findViewById<Button>(R.id.start_btn)


        submitBtn.setOnClickListener {
            if (!TextUtils.isEmpty(emailInp.text) && !android.util.Patterns.EMAIL_ADDRESS.matcher(emailInp.text).matches())
                Toast.makeText(this, "Este email no existe${emailInp.text}", Toast.LENGTH_SHORT).show()

            Toast.makeText(this, "Te enviaremos un email a ${emailInp.text} para recuperar la contraseña", Toast.LENGTH_SHORT).show()
        }
    }
}