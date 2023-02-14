package com.pauljuma.karibuapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.database.AppDatabase
import com.pauljuma.karibuapp.databinding.ActivitySearchBinding
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import com.pauljuma.karibuapp.ui.adapters.SearchAdapter
import com.pauljuma.karibuapp.ui.viewmodel.search.SearchViewModel
import com.pauljuma.karibuapp.ui.viewmodel.search.SearchViewModelFactory

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding
    lateinit var searchViewModel: SearchViewModel
    lateinit var searchViewModelFactory: SearchViewModelFactory
    lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchAdapter = SearchAdapter(this)

        val database = AppDatabase(this)
        val karibuRepository = KaribuRepository(database)

        searchViewModelFactory = SearchViewModelFactory(karibuRepository)
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory).get(SearchViewModel::class.java)

        observeSearchRecycleview()
    }

    private fun observeSearchRecycleview() {
        searchViewModel.searchItem.observe(this){
            searchAdapter.addItem(it)
            setUpSearchRecycleview()
        }
    }

    private fun setUpSearchRecycleview() {
        binding.rvSearch.apply {
            hasFixedSize()
            adapter = searchAdapter
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}