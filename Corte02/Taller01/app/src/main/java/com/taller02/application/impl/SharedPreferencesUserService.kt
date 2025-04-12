package com.taller02.application.impl

import android.content.SharedPreferences
import com.taller02.application.UserService
import com.taller02.application.error.InvalidDataException
import com.taller02.domain.User

/**
 * Mock class to emulate backend request
 */
class SharedPreferencesUserService(private val shp: SharedPreferences) : UserService {
    companion object {
        const val LOCAL_USER_STORE: String = "user-info"
    }

    override fun register(usr: User) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(usr.email).matches())
           throw InvalidDataException("E-mail incorrecto")

        if (usr.firstName.trim().isEmpty())
            throw InvalidDataException("El nombre no debe estar vacio")

        if (usr.lastName.trim().isEmpty())
            throw InvalidDataException("El apellido no debe estar vacio")

        if (usr.password.trim().isEmpty())
            throw InvalidDataException("La contraseña no debe estar vacia")

        try {
            usr.phone.toLong()
        } catch (_: NumberFormatException) {
            throw InvalidDataException("${usr.phone} no es un numero de telefono valido")
        }

        saveUser(usr)
    }

    override fun login(email: String, password: String) {
        val savedPassword: String? = shp.getString("password", null)
        val savedEmail: String? = shp.getString("email", null)

        if (savedEmail == null || savedPassword == null || savedEmail != email || savedPassword != password) {
            throw InvalidDataException("No se encontro algun usuario asociado al e-mail $email")
        }
    }

    override fun edit(usr: User) = this.saveUser(usr)

    override fun getUserInfo(): User {
        return User(
            firstName = shp.getString("firstName", "Jonh") as String,
            lastName = shp.getString("lastName", "Doe") as String,
            password = shp.getString("password", "") as String,
            phone = shp.getString("phone", "1234") as String,
            email = shp.getString("email", "test@example.com") as String
        )
    }

    private fun saveUser(usr: User) {
        shp.edit()
            .putString("firstName", usr.firstName)
            .putString("lastName", usr.lastName)
            .putString("email", usr.email)
            .putString("password", usr.password)
            .putString("phone", usr.phone)
            .apply()
    }
}