package com.pauljuma.karibuapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.FeaturedPartnersItem
import com.pauljuma.karibuapp.repository.KaribuRepository
import kotlinx.coroutines.launch

class SearchViewModel(val repository: KaribuRepository): ViewModel() {
    val searchItem: MutableLiveData<List<FeaturedPartnersItem>> = MutableLiveData()

    init {
        getSearchItem()
    }

    fun getSearchItem() = viewModelScope.launch {
        val response = repository.getItems()
        searchItem.value = response
    }
}