package com.pauljuma.karibuapp.data

import com.pauljuma.karibuapp.R

data class CategoryData(
    var imageId: Int,
    var sectionNames: String
)

object Category{
    val sectionImages = arrayListOf(
        R.drawable.drinks,
        R.drawable.breakfast,
        R.drawable.lunch_and_dinner,
        R.drawable.desserts_and_slides,
    )

    val categoryName = arrayListOf(
        "Drinks", "Breakfast", "lunch and dinner", "Desert and sides"
    )

    var categoryList: ArrayList<CategoryData>? = null

    get() {
        if (field != null){
            return field
        }
        field = ArrayList()

        for (i in sectionImages.indices){
            val imageId = sectionImages[i]
            val imageNames = categoryName[i]

            val categoryList = CategoryData(imageId, imageNames)
            field!!.add(categoryList)
        }
        return field
    }
}
