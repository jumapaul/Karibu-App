package com.pauljuma.karibuapp.ui.viewmodel.lunch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.Meal
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class LunchAndDinnerViewModel(val repository: KaribuRepository): ViewModel() {
    val lunch: MutableLiveData<List<Meal>> = MutableLiveData()

    init {
        getLunchAndDinner()
    }

    fun getLunchAndDinner() = viewModelScope.launch {
        val response = repository.getLunchAndDinner()
        lunch.value = response
    }
}