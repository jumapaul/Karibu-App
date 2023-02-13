package com.pauljuma.karibuapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pauljuma.karibuapp.ui.activities.HomeActivity
import com.pauljuma.karibuapp.databinding.FragmentBasketBinding
import com.pauljuma.karibuapp.ui.viewmodel.cart.CartViewModel

class BasketFragment() : Fragment() {

    lateinit var binding: FragmentBasketBinding
    lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBasketBinding.inflate(inflater, container, false)
        cartViewModel = (activity as HomeActivity).cartViewModel

        return binding.root
    }
}