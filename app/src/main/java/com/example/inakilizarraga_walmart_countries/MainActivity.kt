package com.example.inakilizarraga_walmart_countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.inakilizarraga_walmart_countries.databinding.ActivityMainBinding
import com.example.inakilizarraga_walmart_countries.di.Provider

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val controller = supportFragmentManager.findFragmentById(R.id.nav_frag) as NavHostFragment
        setupActionBarWithNavController(controller.navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        Provider.destroy()
    }
}