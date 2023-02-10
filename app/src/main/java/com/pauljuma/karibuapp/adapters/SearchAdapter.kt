package com.pauljuma.karibuapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.FeaturedPartnersItem
import com.pauljuma.karibuapp.databinding.SearchRecycleviewBinding

class SearchAdapter(val findNavController: NavController) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    lateinit var binding: SearchRecycleviewBinding
    private val searchItem: MutableList<FeaturedPartnersItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(data: List<FeaturedPartnersItem>) {
        searchItem.clear()
        searchItem.addAll(data)
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(binding: SearchRecycleviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(featuredPartnersItem: FeaturedPartnersItem) {
            binding.apply {
                tvRestaurantName.text = featuredPartnersItem.name
                tvLocationName.text = featuredPartnersItem.location
                Glide.with(binding.root).load(featuredPartnersItem.imageUrl)
                    .into(binding.ivSearchItem)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        binding =
            SearchRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchItem[position])
        binding.btnBookHere.setOnClickListener {
            findNavController.navigate(R.id.action_searchFragment_to_categoriesFragment)
            }
        }

    override fun getItemCount(): Int {
       return searchItem.size
    }
}