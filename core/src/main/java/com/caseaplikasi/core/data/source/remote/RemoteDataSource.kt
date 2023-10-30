package com.caseaplikasi.core.data.source.remote

import com.caseaplikasi.core.data.source.remote.network.ApiResponse
import com.caseaplikasi.core.data.source.remote.network.ApiService
import com.caseaplikasi.core.data.source.remote.response.GetPromoResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    val TAG = "RemoteDataSource"
    suspend fun getPromos(): Flow<ApiResponse<List<GetPromoResponseItem>>> {
        return flow {
            try {
                val response =  apiService.getPromos()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Timber.tag(TAG).d("getMovies: ${e.message}")
            }
        }.flowOn(Dispatchers.IO)
    }
}