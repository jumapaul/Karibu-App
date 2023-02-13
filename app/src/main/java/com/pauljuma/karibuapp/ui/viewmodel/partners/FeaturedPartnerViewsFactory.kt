package com.pauljuma.karibuapp.ui.viewmodel.partners

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pauljuma.karibuapp.domain.repository.KaribuRepository

class FeaturedPartnerViewsFactory(val repository: KaribuRepository): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FeaturedPartnersViewModel(repository) as T
    }
}