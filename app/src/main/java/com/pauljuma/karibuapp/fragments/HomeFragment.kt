package com.pauljuma.karibuapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.pauljuma.karibuapp.MainActivity
import com.pauljuma.karibuapp.adapters.FavoriteMealsAdapter
import com.pauljuma.karibuapp.adapters.FeaturedPartnersAdapter
import com.pauljuma.karibuapp.databinding.FragmentHomeBinding
import com.pauljuma.karibuapp.viewmodel.KaribuViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val featuredPartnerAdapter: FeaturedPartnersAdapter by lazy { FeaturedPartnersAdapter() }
    private val favoriteMealsAdapter: FavoriteMealsAdapter by lazy { FavoriteMealsAdapter() }
    private lateinit var viewBinding: FragmentHomeBinding
    lateinit var karibuViewModel: KaribuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)

        karibuViewModel = (activity as MainActivity).karibuViewModel
        observeFeaturedPartners()
        observeFavoriteMeals()

        return viewBinding.root
    }

    fun observeFeaturedPartners() {
        karibuViewModel.featuredPartners.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                featuredPartnerAdapter.addItem(it)
                setUpFeaturedPartnerRecycleView()

            }
        }
    }

    fun observeFavoriteMeals(){
        karibuViewModel.favoriteMeals.observe(viewLifecycleOwner){
            if (it.isNotEmpty()){
                favoriteMealsAdapter.addFavorites(it)
                setUpFavoriteMealsRecycleview()
            }
        }
    }

    fun setUpFeaturedPartnerRecycleView() {
        rvPopularDishes.apply {
            hasFixedSize()
            adapter = featuredPartnerAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun setUpFavoriteMealsRecycleview() {
        rvFavoriteMeals.apply {
            hasFixedSize()
            adapter = favoriteMealsAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}