package com.taller02.application;

import com.taller02.domain.Product;


interface StoreService {
    fun findAll(): List<Product>
    fun findByCategory(category: String): List<Product>
    fun findById(id: Int): Product

    fun getCategories(): List<String>

    fun addToCart(id: Int, quantity: Int)
    fun getCart(): List<Product>
    fun removeFromCart(id: Int)
}
