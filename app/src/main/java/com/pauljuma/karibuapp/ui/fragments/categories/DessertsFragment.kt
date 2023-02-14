package com.pauljuma.karibuapp.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentDessertsBinding
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import com.pauljuma.karibuapp.ui.adapters.DessertAdapter
import com.pauljuma.karibuapp.ui.viewmodel.dessert.DessertAndSlidesViewModel

class DessertsFragment : Fragment() {

    lateinit var binding: FragmentDessertsBinding
    private  val dessertAdapter: DessertAdapter by lazy { DessertAdapter() }
    lateinit var dessertViewModel: DessertAndSlidesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDessertsBinding.inflate(layoutInflater)
        dessertViewModel = (activity as SectionActivity).dessertAndSlidesViewModel
        observeAdapterRecycleView()

        return binding.root
    }

    private fun observeAdapterRecycleView(){
        dessertViewModel.dessert.observe(viewLifecycleOwner){
            dessertAdapter.addItem(it)
        }
        setUpAdapterRecycleview()
    }
    private fun setUpAdapterRecycleview(){
        binding.rvDessert.apply {
            hasFixedSize()
            adapter = dessertAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        }
    }
}