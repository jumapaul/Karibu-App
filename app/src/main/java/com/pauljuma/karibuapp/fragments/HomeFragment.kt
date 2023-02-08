package com.pauljuma.karibuapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.pauljuma.karibuapp.activities.HomeActivity
import com.pauljuma.karibuapp.activities.MainActivity
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.activities.Authentication
import com.pauljuma.karibuapp.adapters.FeaturedPartnersAdapter
import com.pauljuma.karibuapp.databinding.FragmentHomeBinding
import com.pauljuma.karibuapp.viewmodel.CartViewModel
import com.pauljuma.karibuapp.viewmodel.FeaturedPartnersViewModel

class HomeFragment : Fragment() {
    private val featuredPartnerAdapter: FeaturedPartnersAdapter by lazy { FeaturedPartnersAdapter() }
    private lateinit var viewBinding: FragmentHomeBinding
    lateinit var cartViewModel: CartViewModel
    lateinit var featuredPartnersViewModel: FeaturedPartnersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        cartViewModel = (activity as HomeActivity).cartViewModel
        featuredPartnersViewModel = (activity as HomeActivity).featuredPartnerViewModel

        observeFeaturedPartners()

        viewBinding.ivSlides.setOnClickListener { v ->
            openCloseNavigationDrawer(v)
        }
        val imageSlider = viewBinding.imageSlider
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.dinner_inn, "Dinner"))
        imageList.add(SlideModel(R.drawable.burger_inn, "Buggers"))
        imageList.add(SlideModel(R.drawable.pizza_in, "Pizza"))
        imageList.add(SlideModel(R.drawable.ice_cream_inn, "Ice cream inn"))
        imageList.add(SlideModel(R.drawable.sandwich_inn, "Sandwich inn"))
        imageList.add(SlideModel(R.drawable.ver_inn, "ver inn"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        viewBinding.tvSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

        viewBinding.riProfile.setOnClickListener {
            val intent = Intent(requireContext(), Authentication::class.java)
           startActivity(intent)
        }


        return viewBinding.root
    }

    fun observeFeaturedPartners() {
        featuredPartnersViewModel.featuredPartnerItems.observe(viewLifecycleOwner){
            featuredPartnerAdapter.addItem(it)
            setUpFeaturedPartnerRecycleView()
        }
    }

    fun setUpFeaturedPartnerRecycleView() {
        viewBinding.rvPopularDishes.apply {
            hasFixedSize()
            adapter = featuredPartnerAdapter

            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun openCloseNavigationDrawer(view: View){
        val drawer = viewBinding.drawerLayout
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            drawer.openDrawer(GravityCompat.START)
        }
    }
}