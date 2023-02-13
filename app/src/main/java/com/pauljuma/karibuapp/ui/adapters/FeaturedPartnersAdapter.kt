package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.data.preference.SharedPreferenceUtil
import com.pauljuma.karibuapp.databinding.FeaturedPartnerRecycleviewBinding
import com.pauljuma.karibuapp.ui.activities.SectionActivity
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class FeaturedPartnersAdapter(val activity: Activity) :
    RecyclerView.Adapter<FeaturedPartnersAdapter.FeaturedPartnerViewHolder>() {

    lateinit var binding: FeaturedPartnerRecycleviewBinding
    private val items: MutableList<FeaturedPartnersItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(data: List<FeaturedPartnersItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class FeaturedPartnerViewHolder(binding: FeaturedPartnerRecycleviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(featuredPartnersItem: FeaturedPartnersItem) {
            binding.apply {
                tvPartnerName.text = featuredPartnersItem.name
                tvLocation.text = featuredPartnersItem.location
                Picasso.get().load(featuredPartnersItem.imageUrl)
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .into(binding.ivFeaturedPartners)

                root.setOnClickListener {
                    val intent = Intent(binding.root.context, SectionActivity::class.java)
                    binding.root.context.startActivity(intent)
                    val preferences = SharedPreferenceUtil(activity)
                    preferences.save("location", featuredPartnersItem.location)
                    preferences.save("name", featuredPartnersItem.name)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedPartnerViewHolder {
        binding = FeaturedPartnerRecycleviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FeaturedPartnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturedPartnerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}