package com.pauljuma.karibuapp.ui.viewmodel.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.CartItemData
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class CartViewModel(val repository: KaribuRepository): ViewModel() {
    val cartItems: MutableLiveData<List<CartItemData>> = MutableLiveData()

    init {
        getCartItem()
    }

    fun getCartItem() = viewModelScope.launch {
        val response = repository
    }

}