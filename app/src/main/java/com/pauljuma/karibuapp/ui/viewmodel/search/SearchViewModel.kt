package com.pauljuma.karibuapp.ui.viewmodel.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class SearchViewModel(val repository: KaribuRepository): ViewModel() {
    val searchItem: MutableLiveData<List<FeaturedPartnersItem>> = MutableLiveData()

    init {
        getSearchItem()
    }

    fun getSearchItem() = viewModelScope.launch {
        val response = repository.getPartners()
        searchItem.value = response
    }
}