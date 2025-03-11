package com.taller02.application.error

class InvalidDataException(private val msg: String): Exception(msg) {
}