package com.pauljuma.karibuapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.R
import com.pauljuma.karibuapp.data.database.AppDatabase
import com.pauljuma.karibuapp.databinding.ActivitySectionBinding
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import com.pauljuma.karibuapp.ui.viewmodel.breakfast.BreakfastViewModel
import com.pauljuma.karibuapp.ui.viewmodel.breakfast.BreakfastViewModelFactory
import com.pauljuma.karibuapp.ui.viewmodel.dessert.DessertAndSlidesViewModel
import com.pauljuma.karibuapp.ui.viewmodel.dessert.DessertsAndSlidesViewModelFactory
import com.pauljuma.karibuapp.ui.viewmodel.drinks.DrinksViewModel
import com.pauljuma.karibuapp.ui.viewmodel.drinks.DrinksViewModelFactory
import com.pauljuma.karibuapp.ui.viewmodel.lunch.LunchAndDinnerViewModel
import com.pauljuma.karibuapp.ui.viewmodel.lunch.LunchAndDinnerViewModelFactory
import com.pauljuma.karibuapp.ui.viewmodel.search.SearchViewModel
import com.pauljuma.karibuapp.ui.viewmodel.search.SearchViewModelFactory

class SectionActivity : AppCompatActivity() {

    lateinit var binding: ActivitySectionBinding
    lateinit var searchViewModel: SearchViewModel
    lateinit var drinksViewModel: DrinksViewModel
    lateinit var breakfastViewModel: BreakfastViewModel
    lateinit var lunchAndDinnerViewModel: LunchAndDinnerViewModel
    lateinit var dessertAndSlidesViewModel: DessertAndSlidesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val karibuRepository = KaribuRepository(AppDatabase(this))

        val searchViewModelFactory = SearchViewModelFactory(karibuRepository)
        searchViewModel =
            ViewModelProvider(this, searchViewModelFactory).get(SearchViewModel::class.java)

        val drinksViewModelFactory = DrinksViewModelFactory(karibuRepository)
        drinksViewModel =
            ViewModelProvider(this, drinksViewModelFactory).get(DrinksViewModel::class.java)

        val breakfastViewModelFactory = BreakfastViewModelFactory(karibuRepository)
        breakfastViewModel =
            ViewModelProvider(this, breakfastViewModelFactory).get(BreakfastViewModel::class.java)

        val lunchAndDinnerViewModelFactory = LunchAndDinnerViewModelFactory(karibuRepository)
        lunchAndDinnerViewModel = ViewModelProvider(
            this,
            lunchAndDinnerViewModelFactory
        ).get(LunchAndDinnerViewModel::class.java)

        val dessertsAndSlidesViewModelFactory = DessertsAndSlidesViewModelFactory(karibuRepository)
        dessertAndSlidesViewModel = ViewModelProvider(
            this,
            dessertsAndSlidesViewModelFactory
        ).get(DessertAndSlidesViewModel::class.java)
    }
}