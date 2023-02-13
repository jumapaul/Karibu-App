package com.pauljuma.karibuapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.data.model.local.MealType
import com.pauljuma.karibuapp.databinding.BasketRecycleviewBinding
import com.squareup.picasso.Picasso

class DrinksAdapter: RecyclerView.Adapter<DrinksAdapter.DrinksAdapterViewHolder>(){
    lateinit var binding: BasketRecycleviewBinding
    var drinks: MutableList<Meal> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addDrinks(data: List<Meal>){
        drinks.clear()
        drinks.addAll(data)
        notifyDataSetChanged()

    }
    inner class DrinksAdapterViewHolder(binding: BasketRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(meal: Meal){
            binding.apply {
                tvBasketItemName.text = meal.name
                tvPrice.text = meal.price.toString()
                Picasso.get().load(meal.imageUrl).into(binding.ivBasketItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksAdapterViewHolder {
        binding = BasketRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DrinksAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrinksAdapterViewHolder, position: Int) {
        holder.bind(drinks[position])
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}