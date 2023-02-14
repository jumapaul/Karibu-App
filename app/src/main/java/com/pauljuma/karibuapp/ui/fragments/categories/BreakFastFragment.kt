package com.pauljuma.karibuapp.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentBreakFastBinding
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import com.pauljuma.karibuapp.ui.adapters.BreakfastAdapter
import com.pauljuma.karibuapp.ui.viewmodel.breakfast.BreakfastViewModel

class BreakFastFragment : Fragment() {

    lateinit var binding: FragmentBreakFastBinding
    private val breakfastAdapter: BreakfastAdapter by lazy { BreakfastAdapter() }
    lateinit var viewModel: BreakfastViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBreakFastBinding.inflate(layoutInflater)
        viewModel = (activity as SectionActivity).breakfastViewModel
        observeBreakfastRecycleview()
        return binding.root
    }

    fun observeBreakfastRecycleview() {
        viewModel.breakfast.observe(viewLifecycleOwner) {
            breakfastAdapter.addBreakfast(it)
        }
        setUpBreakfastRecycleview()
    }

    fun setUpBreakfastRecycleview() {
        binding.rvBreakfast.apply {
            hasFixedSize()
            adapter = breakfastAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}