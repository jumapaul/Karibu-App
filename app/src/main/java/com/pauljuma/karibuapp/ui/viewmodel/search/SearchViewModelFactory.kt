package com.pauljuma.karibuapp.ui.viewmodel.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.domain.repository.KaribuRepository

class SearchViewModelFactory(val repository: KaribuRepository): ViewModelProvider.Factory {

    @Suppress ("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
    }
}