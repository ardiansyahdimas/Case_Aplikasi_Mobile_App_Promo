package com.caseaplikasi.mobileapppromo.ui.screen

import androidx.lifecycle.ViewModel
import com.caseaplikasi.core.data.Resource
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.core.domain.usecase.PromoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PromoViewModel @Inject constructor (private val promoUseCase: PromoUseCase) : ViewModel() {
    val getPromos = promoUseCase.getPromos()
}