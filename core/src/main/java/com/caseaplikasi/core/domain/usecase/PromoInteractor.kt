package com.caseaplikasi.core.domain.usecase

import com.caseaplikasi.core.data.Resource
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.core.domain.repository.IPromoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PromoInteractor @Inject constructor(private val promoRepository: IPromoRepository):
    PromoUseCase {
    override fun getPromos(): Flow<Resource<List<PromoModel>>> = promoRepository.getPromos()
}