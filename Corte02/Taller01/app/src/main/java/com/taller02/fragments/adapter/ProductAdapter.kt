package com.taller02.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.taller02.R
import com.taller02.domain.Product
import java.util.Locale

class ProductAdapter(private val productList: List<Product>, private val onClickProd: (p: Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_store_item, parent, false)
        return ProductViewHolder(view, onClickProd)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size

    class ProductViewHolder(itemView: View, private val onClick: (d: Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productPrice: TextView = itemView.findViewById(R.id.prod_price)
        private val productCategory: TextView = itemView.findViewById(R.id.prod_category)

        fun bind(product: Product) {
            productName.text = product.name
            productPrice.text = String.format(Locale.getDefault(),"%.2f USD", product.price)
            productCategory.text = product.category
            itemView.setOnClickListener{
                onClick(product)
            }
        }
    }
}