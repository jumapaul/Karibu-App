package com.pauljuma.karibuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.pauljuma.karibuapp.databinding.ActivityMainBinding
import com.pauljuma.karibuapp.viewmodel.CartViewModel

class MainActivity : AppCompatActivity() {

    lateinit var cartViewModel: CartViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

       val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcFragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

       // binding.BottomNavigationView.setupWithNavController(navController)

    }
}
