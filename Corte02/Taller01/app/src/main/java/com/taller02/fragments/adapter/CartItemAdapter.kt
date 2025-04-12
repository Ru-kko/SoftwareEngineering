package com.taller02.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taller02.R
import com.taller02.domain.Product
import java.util.Locale

class CartItemAdapter(
    private val products: List<Product>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<CartItemAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.product_name)
        val price: TextView = view.findViewById(R.id.prod_price)
        val subtotal: TextView = view.findViewById(R.id.cart_item_subtotal)
        val quantity: TextView = view.findViewById(R.id.cart_item_quantity)
        val removeBtn: Button = view.findViewById(R.id.cart_item_remove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_cart_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.name.text = product.name
        holder.price.text = String.format(Locale.getDefault(), "%.2f USD", product.price)
        holder.quantity.text = String.format(Locale.getDefault(),  "%d",product.availableQuantity)
        holder.subtotal.text = String.format(Locale.getDefault(), "%.2f", product.price * product.availableQuantity)

        holder.removeBtn.setOnClickListener {
            onItemClick(product.id)
        }
    }

    override fun getItemCount() = products.size
}