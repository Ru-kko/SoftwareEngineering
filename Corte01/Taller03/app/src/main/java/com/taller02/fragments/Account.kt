package com.taller02.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.impl.SharedPreferencesUserService

class AccountFragment : Fragment(R.layout.frag_account) {
    private lateinit var userService: UserService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userService = SharedPreferencesUserService(
            requireActivity().getSharedPreferences(
                SharedPreferencesUserService.LOCAL_USER_STORE, Context.MODE_PRIVATE
            )
        )

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