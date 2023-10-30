package com.caseaplikasi.core.domain.repository

import com.caseaplikasi.core.data.Resource
import com.caseaplikasi.core.domain.model.PromoModel
import kotlinx.coroutines.flow.Flow

interface IPromoRepository {
    fun getPromos(): Flow<Resource<List<PromoModel>>>
}