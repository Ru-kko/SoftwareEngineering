package com.taller02.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.impl.SharedPreferencesUserService

class Account : AppCompatActivity() {
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account)

        this.userService = SharedPreferencesUserService(getSharedPreferences(
            SharedPreferencesUserService.LOCAL_USER_STORE, MODE_PRIVATE))

        val firstNameTxt = findViewById<TextView>(R.id.first_profile_name)
        val lastNameTxt = findViewById<TextView>(R.id.profile_last_name)
        val emailTxt = findViewById<TextView>(R.id.profile_email)
        val phoneTxt = findViewById<TextView>(R.id.profile_phone)

        val user = userService.getUserInfo()

        firstNameTxt.text = user.firstName
        lastNameTxt.text = user.lastName
        emailTxt.text = user.email
        phoneTxt.text = user.phone
    }
}