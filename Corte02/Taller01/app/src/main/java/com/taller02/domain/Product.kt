package com.taller02.domain

data class Product (
    val id: Int,
    val name: String,
    val img: String?,
    val category: String,
    val price: Double,
    val description: String,
    val availableQuantity: Int
)