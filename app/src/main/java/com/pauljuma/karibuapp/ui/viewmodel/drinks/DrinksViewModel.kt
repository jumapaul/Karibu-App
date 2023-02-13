package com.pauljuma.karibuapp.ui.viewmodel.drinks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class DrinksViewModel(val repository: KaribuRepository): ViewModel() {
    val drinks: MutableLiveData<List<Meal>> = MutableLiveData()

    init {
        getDrinks()
    }

    fun getDrinks() = viewModelScope.launch {
        val respomse = repository.getDrinks()
        drinks.value = respomse
    }
}