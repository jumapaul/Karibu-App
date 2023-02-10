package com.pauljuma.karibuapp.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.FeaturedPartnersItem
import com.pauljuma.karibuapp.databinding.FeaturedPartnerRecycleviewBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class FeaturedPartnersAdapter :
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

                root.setOnClickListener { view ->
                   // view.findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
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