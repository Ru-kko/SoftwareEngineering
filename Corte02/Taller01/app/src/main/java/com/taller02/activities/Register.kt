package com.taller02.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.error.InvalidDataException
import com.taller02.application.impl.SharedPreferencesUserService
import com.taller02.domain.User

class Register: AppCompatActivity() {
    private lateinit var registerBtn: Button

    private lateinit var firstNameInp: EditText
    private lateinit var lastNameInp: EditText
    private lateinit var emailInp: EditText
    private lateinit var phoneInp: EditText
    private lateinit var passwordInp: EditText
    private lateinit var passwordRepeatInp: EditText
    private lateinit var checkConditions: CheckBox

    private lateinit var userService: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        this.registerBtn = findViewById(R.id.start_btn)

        this.firstNameInp = findViewById(R.id.inp_first_name)
        this.lastNameInp = findViewById(R.id.inp_last_name)
        this.emailInp = findViewById(R.id.inp_email)
        this.phoneInp = findViewById(R.id.inp_phone)
        this.passwordInp = findViewById(R.id.inp_password)
        this.passwordRepeatInp = findViewById(R.id.inp_password_repeat)
        this.checkConditions = findViewById(R.id.check_terms)

        this.userService = SharedPreferencesUserService(getSharedPreferences(SharedPreferencesUserService.LOCAL_USER_STORE, MODE_PRIVATE))

        findViewById<Button>(R.id.start_btn).setOnClickListener {
            if (!checkConditions.isChecked) {
                Toast.makeText(this, "Accept terms and conditions", Toast.LENGTH_SHORT).show()
            }
            try {
                userService.register(buildUser())
            } catch (e: InvalidDataException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } catch (e: Exception) {
                Toast.makeText(this, "We are having problems, try again later", Toast.LENGTH_SHORT).show()
                Log.e(Register::class.java.name, e.message, e)
                return@setOnClickListener
            }

            startActivity(Intent(this, LogIn::class.java))
        }
    }

    private fun buildUser(): User {
        if (passwordInp.text.toString() != passwordRepeatInp.text.toString()) {
            throw InvalidDataException("Password are not same")
        }

        return User(
            firstName = firstNameInp.text.toString(),
            lastName = lastNameInp.text.toString(),
            email = emailInp.text.toString(),
            phone = phoneInp.text.toString(),
            password = passwordInp.text.toString()
        )
    }
}