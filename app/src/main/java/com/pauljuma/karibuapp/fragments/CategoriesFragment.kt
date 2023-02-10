package com.pauljuma.karibuapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.adapters.CategoryAdapter
import com.pauljuma.karibuapp.databinding.FragmentBasketBinding
import com.pauljuma.karibuapp.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    private val categoryAdapter: CategoryAdapter by lazy { CategoryAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        setUpCategoryRecycleview()

        return binding.root
    }

    private fun setUpCategoryRecycleview(){
        binding.rvCategories.apply {
            hasFixedSize()
            adapter = categoryAdapter
           layoutManager = GridLayoutManager(requireContext(), 2,GridLayoutManager.VERTICAL, false)
        }
    }

}