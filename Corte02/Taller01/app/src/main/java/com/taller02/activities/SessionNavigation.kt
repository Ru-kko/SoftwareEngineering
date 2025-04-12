package com.taller02.activities


import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.taller02.R

class SessionNavigation: AppCompatActivity() {
    private lateinit var content: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session_navigation)
        content = supportFragmentManager.findFragmentById(R.id.Content)!!

        // nav
        val account = findViewById<ImageButton>(R.id.accountBtn)
        account.setOnClickListener {
            Navigation.findNavController(content.requireView()).navigate(R.id.account)
        }

        val store = findViewById<ImageButton>(R.id.homeBtn)
        store.setOnClickListener {
            Navigation.findNavController(content.requireView()).navigate(R.id.store)
        }

        val cart = findViewById<ImageButton>(R.id.cartBtn)
        cart.setOnClickListener {
            Navigation.findNavController(content.requireView()).navigate(R.id.cart)
        }
    }
}