package com.pauljuma.karibuapp.ui.viewmodel.partners

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pauljuma.karibuapp.data.model.local.FeaturedPartnersItem
import com.pauljuma.karibuapp.domain.repository.KaribuRepository
import kotlinx.coroutines.launch

class FeaturedPartnersViewModel(val repository: KaribuRepository): ViewModel() {
    val featuredPartnerItems: MutableLiveData<List<FeaturedPartnersItem>> = MutableLiveData()

    init{
        getFeaturedPartnerItem()
    }

    fun getFeaturedPartnerItem() = viewModelScope.launch {
        val response = repository.getPartners()
        featuredPartnerItems.value = response
    }
}