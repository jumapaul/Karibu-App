package com.pauljuma.karibuapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pauljuma.karibuapp.HomeActivity
import com.pauljuma.karibuapp.databinding.FragmentSearchBinding
import com.pauljuma.karibuapp.viewmodel.CartViewModel

class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var cartViewModel: CartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        cartViewModel = (activity as HomeActivity).cartViewModel

        return binding.root
    }
}