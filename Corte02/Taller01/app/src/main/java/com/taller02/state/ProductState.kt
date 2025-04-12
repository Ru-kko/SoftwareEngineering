package com.taller02.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductState: ViewModel() {
    private val mutableSelectedProduct = MutableLiveData(1)
    val selectedProductId: LiveData<Int> get() = mutableSelectedProduct

    fun setProductId(p: Int) {
        mutableSelectedProduct.value = p
    }
}