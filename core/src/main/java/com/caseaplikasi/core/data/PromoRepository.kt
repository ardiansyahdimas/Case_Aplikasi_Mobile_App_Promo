package com.caseaplikasi.core.data

import com.caseaplikasi.core.NetworkBoundResource
import com.caseaplikasi.core.data.source.local.LocalDataSource
import com.caseaplikasi.core.data.source.remote.RemoteDataSource
import com.caseaplikasi.core.data.source.remote.network.ApiResponse
import com.caseaplikasi.core.data.source.remote.response.GetPromoResponseItem
import com.caseaplikasi.core.domain.model.PromoModel
import com.caseaplikasi.core.domain.repository.IPromoRepository
import com.caseaplikasi.core.utils.mapper.PromoDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PromoRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : IPromoRepository {
    override fun getPromos(): Flow<Resource<List<PromoModel>>> =
        object : NetworkBoundResource<List<PromoModel>, List<GetPromoResponseItem>>() {
            override fun loadFromDB(): Flow<List<PromoModel>>  {
                return localDataSource.getPromos().map { PromoDataMapper.mapEntitiesToDomain(it)}
            }

            override fun shouldFetch(data: List<PromoModel>?): Boolean =
                    data.isNullOrEmpty()
//                    true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<GetPromoResponseItem>>> = remoteDataSource.getPromos()


            override suspend fun saveCallResult(data: List<GetPromoResponseItem>) {
                val promoList = PromoDataMapper.mapResponsesToEntities(data)
                localDataSource.insertPromos(promoList)
            }
        }.asFlow()
}