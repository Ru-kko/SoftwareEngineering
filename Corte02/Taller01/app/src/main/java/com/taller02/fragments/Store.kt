package com.taller02.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taller02.R
import com.taller02.application.StoreService
import com.taller02.application.impl.SharedPreferencesStoreService
import com.taller02.domain.Product
import com.taller02.fragments.adapter.ProductAdapter
import com.taller02.state.ProductState
import java.util.Locale

class Store : Fragment(R.layout.frag_store), AdapterView.OnItemSelectedListener {
    private val productState: ProductState by activityViewModels()
    private lateinit var storeService: StoreService

    private lateinit var categorySpinner: Spinner
    private lateinit var productsList: RecyclerView
    private lateinit var itemsCount: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeService = SharedPreferencesStoreService(
            requireActivity().getSharedPreferences(
                SharedPreferencesStoreService.CART_KEY, Context.MODE_PRIVATE
            )
        )

        itemsCount = view.findViewById(R.id.items_count)
        categorySpinner = view.findViewById(R.id.cat_select)
        loadCategories()

        productsList = view.findViewById(R.id.products_list)
        productsList.layoutManager = LinearLayoutManager(requireContext())

        setList(storeService.findAll())
    }

    private fun loadCategories() {
        val categories = listOf("All") + storeService.getCategories()
        ArrayAdapter(requireContext(), R.layout.spinner_style, categories).also {
            it.setDropDownViewResource(R.layout.spinner_dropdown_item)
            categorySpinner.adapter = it
        }
        categorySpinner.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val category = parent?.getItemAtPosition(position).toString()

        if (category == "All" || category.isEmpty()) {
            setList(storeService.findAll())
            return
        }

        setList(storeService.findByCategory(category))
    }

    private fun setList(data: List<Product>) {
        ProductAdapter(data) { p ->
            productState.setProductId(p.id)
            findNavController().navigate(R.id.action_store_to_singleProduct)
        }.also {
            itemsCount.text = String.format(Locale.getDefault(), "Total Items: %d", data.size)
            productsList.adapter = it
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        setList(storeService.findAll())
    }
}