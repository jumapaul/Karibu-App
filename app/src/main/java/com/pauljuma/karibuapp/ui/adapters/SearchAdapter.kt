package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.data.preference.SharedPreferenceUtil
import com.pauljuma.karibuapp.databinding.SearchRecycleviewBinding
import com.pauljuma.karibuapp.ui.activities.SearchActivity
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import java.util.prefs.Preferences

class SearchAdapter(val activity: Activity) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
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

                btnBookHere.setOnClickListener {
                    val pref = SharedPreferenceUtil(activity)
                    pref.save("name", featuredPartnersItem.name)
                    pref.save("location", featuredPartnersItem.location)

                    val intent = Intent(binding.root.context, SectionActivity::class.java)
                    binding.root.context.startActivity(intent)

                }

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
    }

    override fun getItemCount(): Int {
        return searchItem.size
    }
}