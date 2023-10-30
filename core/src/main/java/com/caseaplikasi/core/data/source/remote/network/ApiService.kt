package com.caseaplikasi.core.data.source.remote.network


import com.caseaplikasi.core.data.source.remote.response.GetPromoResponseItem
import retrofit2.http.*


interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("promos")
    suspend fun getPromos(): List<GetPromoResponseItem>
}
