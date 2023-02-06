package com.pauljuma.karibuapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pauljuma.karibuapp.data.CartItem
import com.pauljuma.karibuapp.repository.KaribuRepository

class CartViewModel(val repository: KaribuRepository): ViewModel() {
    val cartItems: MutableLiveData<List<CartItem>> = MutableLiveData()

}