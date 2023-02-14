package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.data.model.local.MealType
import com.pauljuma.karibuapp.databinding.AddCartRecycleviewBinding
import com.pauljuma.karibuapp.databinding.BasketRecycleviewBinding
import com.squareup.picasso.Picasso

class DrinksAdapter: RecyclerView.Adapter<DrinksAdapter.DrinksAdapterViewHolder>(){
    lateinit var binding: AddCartRecycleviewBinding
    var drinks: MutableList<Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addDrinks(data: List<Meal>){
        drinks.clear()
        drinks.addAll(data)
        notifyDataSetChanged()

    }
    inner class DrinksAdapterViewHolder(binding: AddCartRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(meal: Meal){
            binding.apply {
                tvName.text = meal.name
                tvFavoritePrice.text = "ksh ${meal.price}"
                Picasso.get().load(meal.imageUrl).into(binding.ivFoodItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksAdapterViewHolder {
        binding = AddCartRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DrinksAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinksAdapterViewHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount(): Int {
        Log.d("here==========================>","${drinks.size}")
        return drinks.size
    }
}