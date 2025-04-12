package com.taller02.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taller02.R
import com.taller02.application.UserService
import com.taller02.application.impl.SharedPreferencesUserService
import com.taller02.domain.User

class EditAccount : Fragment(R.layout.frag_edit_account) {
    private lateinit var userService: UserService

    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var phoneInput: EditText
    private lateinit var btnEdit: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userService = SharedPreferencesUserService(
            requireActivity().getSharedPreferences(
                SharedPreferencesUserService.LOCAL_USER_STORE, Context.MODE_PRIVATE
            )
        )

        firstNameInput = view.findViewById(R.id.edit_first_name)
        lastNameInput = view.findViewById(R.id.edit_last_name)
        emailInput = view.findViewById(R.id.edit_email)
        passwordInput = view.findViewById(R.id.edit_password)
        phoneInput = view.findViewById(R.id.edit_phone)
        btnEdit = view.findViewById(R.id.btn_send_edit)

        val currentUser = userService.getUserInfo()
        firstNameInput.setText(currentUser.firstName)
        lastNameInput.setText(currentUser.lastName)
        emailInput.setText(currentUser.email)
        passwordInput.setText(currentUser.password)
        phoneInput.setText(currentUser.phone)

        btnEdit.setOnClickListener {
            validateAndUpdate(currentUser).let {
                userService.edit(it)
                Toast.makeText(requireContext(), "Updated User", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editAccount_to_store)
            }
        }
    }

    private fun validateAndUpdate(current: User): User {
        val fn = firstNameInput.text.toString().trim().ifBlank { current.firstName }
        val ln = lastNameInput.text.toString().trim().ifBlank { current.lastName }
        val em = emailInput.text.toString().trim().ifBlank { current.email }
        val pw = passwordInput.text.toString().ifBlank { current.password }
        val ph = phoneInput.text.toString().trim().ifBlank { current.phone }

        return User(
            firstName = fn,
            lastName = ln,
            email = em,
            password = pw,
            phone = ph
        )
    }

}