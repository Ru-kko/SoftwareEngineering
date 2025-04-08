package com.taller02.fragments

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.impl.SharedPreferencesUserService

class Account() : Fragment(R.layout.account) {
    private lateinit var userService: UserService

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.userService = SharedPreferencesUserService(this.requireActivity().getSharedPreferences(
            SharedPreferencesUserService.LOCAL_USER_STORE, MODE_PRIVATE))

        val firstNameTxt = view.findViewById<TextView>(R.id.first_profile_name)
        val lastNameTxt = view.findViewById<TextView>(R.id.profile_last_name)
        val emailTxt = view.findViewById<TextView>(R.id.profile_email)
        val phoneTxt = view.findViewById<TextView>(R.id.profile_phone)

        val user = userService.getUserInfo()

        firstNameTxt.text = user.firstName
        lastNameTxt.text = user.lastName
        emailTxt.text = user.email
        phoneTxt.text = user.phone
    }
}