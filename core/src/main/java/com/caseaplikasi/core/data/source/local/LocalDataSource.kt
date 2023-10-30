package com.caseaplikasi.core.data.source.local

import com.caseaplikasi.core.data.source.local.entity.PromoEntity
import com.caseaplikasi.core.data.source.local.room.PromoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val promoDao: PromoDao,
) {
    fun getPromos(): Flow<List<PromoEntity>> = promoDao.getPromos()

    suspend fun insertPromos(promoList: List<PromoEntity>) = promoDao.insertPromos(promoList)
}