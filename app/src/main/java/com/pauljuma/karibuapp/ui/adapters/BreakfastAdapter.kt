package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.databinding.AddCartRecycleviewBinding
import com.pauljuma.karibuapp.databinding.BasketRecycleviewBinding
import com.squareup.picasso.Picasso

class BreakfastAdapter: RecyclerView.Adapter<BreakfastAdapter.BreakfastViewHolder>() {

    lateinit var binding: AddCartRecycleviewBinding
    val breakfast: MutableList<Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addBreakfast(data: List<Meal>){
        breakfast.clear()
        breakfast.addAll(data)
        notifyDataSetChanged()
    }


    inner class BreakfastViewHolder(binding: AddCartRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(meal: Meal){
            binding.apply {
                tvName.text = meal.name
                tvFavoritePrice.text = "ksh ${meal.price}"
                Picasso.get().load(meal.imageUrl).into(ivFoodItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakfastViewHolder {
        binding = AddCartRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BreakfastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreakfastViewHolder, position: Int) {
        holder.bind(breakfast[position])
    }

    override fun getItemCount(): Int {
        return breakfast.size
    }
}