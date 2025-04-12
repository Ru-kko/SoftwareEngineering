package com.taller02.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taller02.R

class Home : Fragment(R.layout.frag_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storeBtn = view.findViewById<AppCompatButton>(R.id.link_store)

        storeBtn.setOnClickListener {
            findNavController().navigate(R.id.action_home_to_store)
        }
    }
}