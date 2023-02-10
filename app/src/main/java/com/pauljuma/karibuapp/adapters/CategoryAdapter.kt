package com.pauljuma.karibuapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.data.CategoryData
import com.pauljuma.karibuapp.databinding.CategoryRecycleviewBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    lateinit var binding: CategoryRecycleviewBinding

    private val category: MutableList<CategoryData> = ArrayList()

    inner class CategoryViewHolder(binding: CategoryRecycleviewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(categoryData: CategoryData){
            binding.apply {
                tvCategory.text = categoryData.sectionNames
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
       binding = CategoryRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category[position])
    }

    override fun getItemCount(): Int {
       return category.size
    }
}