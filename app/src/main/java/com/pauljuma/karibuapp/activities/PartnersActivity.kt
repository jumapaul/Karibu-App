package com.pauljuma.karibuapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.database.AppDatabase
import com.pauljuma.karibuapp.databinding.ActivityPartnersBinding
import com.pauljuma.karibuapp.repository.KaribuRepository
import com.pauljuma.karibuapp.viewmodel.SearchViewModel
import com.pauljuma.karibuapp.viewmodel.SearchViewModelFactory

class PartnersActivity : AppCompatActivity() {
    lateinit var binding: ActivityPartnersBinding
    lateinit var searchViewModel: SearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartnersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val karibuRepository = KaribuRepository(AppDatabase(this))
        val searchViewModelFactory = SearchViewModelFactory(karibuRepository)

        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory).get(SearchViewModel::class.java)
    }
}