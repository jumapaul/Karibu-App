package com.pauljuma.karibuapp.ui.viewmodel.dessert

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class DessertAndSlidesViewModel(val repository: KaribuRepository): ViewModel() {
    val dessert: MutableLiveData<List<Meal>> = MutableLiveData()

    init {
        getDessertAndSlides()
    }

    fun getDessertAndSlides() = viewModelScope.launch {
        val response = repository.getDessertsAndSlides()
        dessert.value = response
    }
}