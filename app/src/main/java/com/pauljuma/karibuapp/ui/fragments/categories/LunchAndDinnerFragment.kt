package com.pauljuma.karibuapp.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentLunchAndDinnerBinding
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import com.pauljuma.karibuapp.ui.adapters.LunchAndDinnerAdapter
import com.pauljuma.karibuapp.ui.viewmodel.lunch.LunchAndDinnerViewModel

class LunchAndDinnerFragment : Fragment() {

    lateinit var binding: FragmentLunchAndDinnerBinding
    private val lunchAapter: LunchAndDinnerAdapter by lazy { LunchAndDinnerAdapter() }
    lateinit var lunchAndDinnerViewModel: LunchAndDinnerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLunchAndDinnerBinding.inflate(layoutInflater)
        lunchAndDinnerViewModel = (activity as SectionActivity).lunchAndDinnerViewModel
        observeLunchAndDinnerRecycleview()

        return binding.root
    }

    fun observeLunchAndDinnerRecycleview(){
        lunchAndDinnerViewModel.lunch.observe(viewLifecycleOwner){
            lunchAapter.addLunchItem(it)
        }
        setUpLunchAdapter()

    }
    fun setUpLunchAdapter(){
        binding.rvLunch.apply {
            hasFixedSize()
            adapter = lunchAapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}