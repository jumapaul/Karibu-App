package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.databinding.AddCartRecycleviewBinding
import com.pauljuma.karibuapp.databinding.BasketRecycleviewBinding
import com.squareup.picasso.Picasso

class LunchAndDinnerAdapter: RecyclerView.Adapter<LunchAndDinnerAdapter.LunchAndDinnerViewHolder>() {
    lateinit var binding: AddCartRecycleviewBinding
    val lunchDinner: MutableList<Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addLunchItem(data: List<Meal>){
        lunchDinner.clear()
        lunchDinner.addAll(data)
        notifyDataSetChanged()
    }

    inner class LunchAndDinnerViewHolder(binding: AddCartRecycleviewBinding): RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bind(meal: Meal){
            binding.apply {
                tvName.text = meal.name
                tvFavoritePrice.text = "ksh ${meal.price}"
                Picasso.get().load(meal.imageUrl).into(ivFoodItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LunchAndDinnerViewHolder {
        binding = AddCartRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LunchAndDinnerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LunchAndDinnerViewHolder, position: Int) {
        holder.bind(lunchDinner[position])
    }

    override fun getItemCount(): Int {
        return lunchDinner.size
    }
}