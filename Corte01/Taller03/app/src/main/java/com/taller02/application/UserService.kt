package com.taller02.application

import com.taller02.application.error.InvalidDataException
import com.taller02.domain.User
import kotlin.jvm.Throws

interface UserService {
    @Throws(InvalidDataException::class)
    fun register(usr: User)

    @Throws(InvalidDataException::class)
    fun login(email: String, password: String)

    fun getUserInfo(): User
}
