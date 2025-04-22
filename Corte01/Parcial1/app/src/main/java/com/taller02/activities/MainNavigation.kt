package com.taller02.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.taller02.R

class MainNavigation : AppCompatActivity() {
    private lateinit var content: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_navigation)
        content = supportFragmentManager.findFragmentById(R.id.Content)!!

        val navController = content.findNavController()
        val appBarConfig = AppBarConfiguration(navController.graph, fallbackOnNavigateUpListener = ::onSupportNavigateUp)

        findViewById<Toolbar>(R.id.nav_toolbar)
            .setupWithNavController(navController, appBarConfig)

    }
}