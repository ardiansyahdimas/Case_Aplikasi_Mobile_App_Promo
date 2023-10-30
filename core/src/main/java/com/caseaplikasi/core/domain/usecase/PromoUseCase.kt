package com.caseaplikasi.core.domain.usecase

import com.caseaplikasi.core.data.Resource
import com.caseaplikasi.core.domain.model.PromoModel
import kotlinx.coroutines.flow.Flow

interface PromoUseCase {
    fun getPromos(): Flow<Resource<List<PromoModel>>>
}