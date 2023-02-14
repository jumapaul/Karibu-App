package com.pauljuma.karibuapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.ui.adapters.CategoryAdapter
import com.pauljuma.karibuapp.data.Category
import com.pauljuma.karibuapp.data.preference.SharedPreferenceUtil
import com.pauljuma.karibuapp.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(
            requireContext(),
            Category.categoryList!!,
            findNavController()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        setUpCategoryRecycleview()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = SharedPreferenceUtil(requireContext())
        val partnerName = pref.getString("name")
        val location = pref.getString("location")

        binding.apply {
            tvRestaurantNameHeader.setText(partnerName)
            tvLocationNameTitle.setText(location)
        }
    }

    private fun setUpCategoryRecycleview() {
        binding.rvCategories.apply {
            hasFixedSize()
            adapter = categoryAdapter
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }
}