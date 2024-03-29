package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.databinding.AddCartRecycleviewBinding
import com.pauljuma.karibuapp.databinding.BasketRecycleviewBinding
import com.squareup.picasso.Picasso

class DessertAdapter: RecyclerView.Adapter<DessertAdapter.DessertAdapterViewHolder>() {
    lateinit var binding: AddCartRecycleviewBinding
    val dessertItem: MutableList<Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(data: List<Meal>){
        dessertItem.clear()
        dessertItem.addAll(data)
        notifyDataSetChanged()
    }

    inner class DessertAdapterViewHolder(binding: AddCartRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(meal: Meal){
            binding.apply {
                tvName.text = meal.name
                tvFavoritePrice.text = "ksh ${meal.price}"
                Picasso.get().load(meal.imageUrl).into(ivFoodItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DessertAdapterViewHolder {
        binding = AddCartRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DessertAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DessertAdapterViewHolder, position: Int) {
        holder.bind(dessertItem[position])
    }

    override fun getItemCount(): Int {
        return dessertItem.size
    }
}