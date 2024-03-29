package com.pauljuma.karibuapp.ui.viewmodel.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.domain.repository.KaribuRepository

class CartViewModelFactory(private val repository: KaribuRepository): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(repository) as T
    }
}