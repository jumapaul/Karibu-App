package com.pauljuma.karibuapp.ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.databinding.FragmentDrinksBinding

class DrinksFragment : Fragment() {
    lateinit var binding: FragmentDrinksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDrinksBinding.inflate(layoutInflater)

        return binding.root
    }
}