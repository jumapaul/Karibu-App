package com.pauljuma.karibuapp.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.CategoryData
import com.pauljuma.karibuapp.databinding.CategoryRecycleviewBinding
import com.squareup.picasso.Picasso

class CategoryAdapter(
    val context: Context,
    private val categoryList: ArrayList<CategoryData>,
    val navController: NavController
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    lateinit var binding: CategoryRecycleviewBinding

    inner class CategoryViewHolder(binding: CategoryRecycleviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var currentPosition: Int = -1
        var currentData: CategoryData? = null

        fun bind(categoryData: CategoryData, position: Int) {
            binding.apply {
                tvCategory.text = categoryData.sectionNames
                Picasso.get().load(categoryData.imageId).into(binding.ivCategoryIcon)
                this@CategoryViewHolder.currentPosition = position
                this@CategoryViewHolder.currentData = categoryData

                btnClickHere.setOnClickListener { view ->
                    navController.navigateUp()
                    when (categoryData.sectionNames.lowercase()) {
                        "drinks" -> navController
                            .navigate(R.id.drinksFragment)
                        "breakfast" -> navController
                            .navigate(R.id.breakFastFragment)
                        "lunch and dinner" -> navController
                            .navigate(R.id.lunchAndDinnerFragment)
                        "desert and sides" -> navController
                            .navigate(R.id.dessertsFragment)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding =
            CategoryRecycleviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category, position)

    }

    override fun getItemCount(): Int {

        return categoryList.size
    }
}