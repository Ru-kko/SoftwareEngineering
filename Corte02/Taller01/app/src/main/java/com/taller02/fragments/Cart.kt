package com.taller02.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taller02.R
import com.taller02.application.StoreService
import com.taller02.application.impl.SharedPreferencesStoreService
import com.taller02.domain.Product
import com.taller02.fragments.adapter.CartItemAdapter
import java.util.Locale

class Cart: Fragment(R.layout.frag_cart) {
    private lateinit var storeService: StoreService
    private lateinit var cartItems: List<Product>

    private lateinit var totalItemsTxt: TextView
    private lateinit var totalPriceTxt: TextView
    private lateinit var list: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeService = SharedPreferencesStoreService(
            requireActivity().getSharedPreferences(
                SharedPreferencesStoreService.CART_KEY, Context.MODE_PRIVATE
            )
        )

        totalItemsTxt = view.findViewById(R.id.cart_total_items)
        totalPriceTxt = view.findViewById(R.id.cart_total)
        list = view.findViewById(R.id.cart_data)

        list.layoutManager = LinearLayoutManager(requireContext())
        updateCart()
    }

    private fun updateCart() {
        cartItems = storeService.getCart()
        var totalPrice = 0.0
        var totalItems = 0

        cartItems.forEach { p ->
            totalItems += p.availableQuantity
            totalPrice += p.price * p.availableQuantity
        }

        CartItemAdapter(cartItems) { id ->
            storeService.removeFromCart(id)
            updateCart()
        }.also {
            list.adapter = it
        }

        totalPriceTxt.text = String.format(Locale.getDefault(), "%.2f USD", totalPrice)
        totalItemsTxt.text = String.format(Locale.getDefault(), "%d", totalItems)
    }
}