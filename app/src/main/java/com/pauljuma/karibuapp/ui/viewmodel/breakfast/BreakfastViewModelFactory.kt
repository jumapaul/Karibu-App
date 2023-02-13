package com.pauljuma.karibuapp.ui.viewmodel.breakfast

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.domain.repository.KaribuRepository

class BreakfastViewModelFactory(val repository: KaribuRepository): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreakfastViewModel(repository) as T
    }
}