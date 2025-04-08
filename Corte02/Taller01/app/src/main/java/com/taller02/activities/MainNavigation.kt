package com.taller02.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.taller02.R

class MainNavigation: AppCompatActivity() {
    private lateinit var content: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.findFragmentById(R.id.Content)
    }

}