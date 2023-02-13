package com.pauljuma.karibuapp.ui.viewmodel.breakfast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class BreakfastViewModel(val repository: KaribuRepository): ViewModel() {
    val breakfast: MutableLiveData<List<Meal>> = MutableLiveData()

    init {
        getBreakfast()
    }

    fun getBreakfast() = viewModelScope.launch {
        val response = repository.getBreakfast()
        breakfast.value = response
    }
}