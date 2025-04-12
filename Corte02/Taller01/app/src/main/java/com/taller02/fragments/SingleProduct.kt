package com.taller02.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.taller02.R
import com.taller02.application.StoreService
import com.taller02.application.impl.SharedPreferencesStoreService
import com.taller02.domain.Product
import com.taller02.state.ProductState
import java.util.Locale

class SingleProduct : Fragment(R.layout.frag_single_product) {
    private val viewModel: ProductState by activityViewModels()
    private lateinit var product: Product
    private lateinit var storeService: StoreService

    private lateinit var productName: TextView
    private lateinit var productPrice: TextView
    private lateinit var productStock: TextView
    private lateinit var productCategory: TextView
    private lateinit var productDescription: TextView
    private lateinit var quantity: EditText
    private lateinit var buyButton: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeService = SharedPreferencesStoreService(
            requireActivity().getSharedPreferences(
                SharedPreferencesStoreService.CART_KEY, Context.MODE_PRIVATE
            )
        )

        productName = view.findViewById(R.id.product_name)
        productPrice = view.findViewById(R.id.product_price)
        productStock = view.findViewById(R.id.prod_stock)
        productCategory = view.findViewById(R.id.product_category)
        productDescription = view.findViewById(R.id.product_description)
        quantity = view.findViewById(R.id.inp_quantity)
        buyButton = view.findViewById(R.id.product_buy)

        viewModel.selectedProductId.observe(viewLifecycleOwner) {
            product = storeService.findById(it)
            init()
        }
    }

    private fun init() {
        product.let {
            productName.text = it.name
            productPrice.text = String.format(Locale.getDefault(), "%.2f USD", it.price)
            productStock.text = String.format(Locale.getDefault(), "%d", it.availableQuantity)
            productDescription.text = it.description
            productCategory.text = it.category
        }
        buyButton.setOnClickListener { onClickProd() }
    }

    private fun onClickProd() {
        val quantity = quantity.text.toString().toIntOrNull()
        try {
            if (quantity != null && quantity > 0) {
                storeService.addToCart(product.id, quantity)
                Toast.makeText(
                    requireContext(),
                    "Bought $quantity ${product.name}",
                    Toast.LENGTH_SHORT
                )
                    .show()
                return
            }
            throw  IllegalStateException()
        } catch (_: IllegalStateException) {
            Toast.makeText(requireContext(), "Enter valid quantity", Toast.LENGTH_SHORT)
                .show()
        }
    }
}