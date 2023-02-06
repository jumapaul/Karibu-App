package com.pauljuma.karibuapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.FeaturedPartnersItem
import com.pauljuma.karibuapp.repository.KaribuRepository
import kotlinx.coroutines.launch

class FeaturedPartnersViewModel(val repository: KaribuRepository): ViewModel() {
    val featuredPartnerItems: MutableLiveData<List<FeaturedPartnersItem>> = MutableLiveData()

    init{
        getFeaturedPartnerItem()
    }

    fun getFeaturedPartnerItem() = viewModelScope.launch {
        val response = repository.getItems()
        featuredPartnerItems.value = response
    }
}