package com.pauljuma.karibuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.pauljuma.karibuapp.database.AppDatabase
import com.pauljuma.karibuapp.databinding.ActivityHomeBinding
import com.pauljuma.karibuapp.repository.KaribuRepository
import com.pauljuma.karibuapp.viewmodel.CartViewModel
import com.pauljuma.karibuapp.viewmodel.CartViewModelFactory
import com.pauljuma.karibuapp.viewmodel.FeaturedPartnerViewsFactory
import com.pauljuma.karibuapp.viewmodel.FeaturedPartnersViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var cartViewModel: CartViewModel
    lateinit var featuredPartnerViewModel: FeaturedPartnersViewModel
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val karibuRepository = KaribuRepository(AppDatabase(this))
        val cartViewModelFactory = CartViewModelFactory(karibuRepository)
        val featuredPartnerViewsFactory = FeaturedPartnerViewsFactory(karibuRepository)

        cartViewModel = ViewModelProvider(this, cartViewModelFactory).get(CartViewModel::class.java)
        featuredPartnerViewModel = ViewModelProvider(this, featuredPartnerViewsFactory).
        get(FeaturedPartnersViewModel::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcHomeContainer) as NavHostFragment

        val navController = navHostFragment.navController

        binding.homeBottomNav.setupWithNavController(navController)

    }
}