package com.taller02.application.impl

import android.content.SharedPreferences
import com.taller02.domain.CreditCapacity

class SharedPreferencesStoreData {
    private val shp: SharedPreferences
    private val data = linkedSetOf<CreditCapacity>()
    companion object {
        const val LOCAL_USER_STORE: String = "calculator-history"
    }

    constructor(shp: SharedPreferences) {
        this.shp = shp
        shp.all.values.forEach() {
            data.add(CreditCapacity.fromSet(it as Set<String>))
        }
    }

    fun add(data: CreditCapacity) {
        
    }
}