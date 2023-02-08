package com.pauljuma.karibuapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.activities.HomeActivity
import com.pauljuma.karibuapp.adapters.SearchAdapter
import com.pauljuma.karibuapp.databinding.FragmentSearchBinding
import com.pauljuma.karibuapp.viewmodel.CartViewModel
import com.pauljuma.karibuapp.viewmodel.SearchViewModel

class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var cartViewModel: CartViewModel
    lateinit var searchViewModel: SearchViewModel
    private val searchAdapter: SearchAdapter by lazy { SearchAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        cartViewModel = (activity as HomeActivity).cartViewModel
        searchViewModel = (activity as HomeActivity).searchViewModel

        observeSearchRecycleview()


        return binding.root
    }

    private fun observeSearchRecycleview(){
        searchViewModel.searchItem.observe(viewLifecycleOwner){
            searchAdapter.addItem(it)
            setUpSearchRecycleview()
        }
    }

    private fun setUpSearchRecycleview() {
        binding.rvSearch.apply {
            hasFixedSize()
            adapter = searchAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}