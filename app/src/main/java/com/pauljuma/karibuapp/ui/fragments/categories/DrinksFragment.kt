package com.pauljuma.karibuapp.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentDrinksBinding
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import com.pauljuma.karibuapp.ui.adapters.DrinksAdapter
import com.pauljuma.karibuapp.ui.viewmodel.drinks.DrinksViewModel

class DrinksFragment : Fragment() {
    lateinit var binding: FragmentDrinksBinding
    private val drinksAdapter: DrinksAdapter by lazy { DrinksAdapter() }
    lateinit var viewModel: DrinksViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDrinksBinding.inflate(layoutInflater)
        viewModel = (activity as SectionActivity).drinksViewModel
        observeDrinksAdapter()

        return binding.root
    }

    fun observeDrinksAdapter(){
        viewModel.drinks.observe(viewLifecycleOwner){
            drinksAdapter.addDrinks(it)
        }

        setUpDrinkRecycleview()
    }

    fun setUpDrinkRecycleview(){
        binding.rvDrinks.apply {
            hasFixedSize()
            adapter = drinksAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}