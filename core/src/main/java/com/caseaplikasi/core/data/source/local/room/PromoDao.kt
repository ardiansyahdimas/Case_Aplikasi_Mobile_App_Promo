package com.caseaplikasi.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.caseaplikasi.core.data.source.local.entity.PromoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PromoDao {

    @Query("SELECT * FROM promo")
    fun getPromos(): Flow<List<PromoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPromos(promoList: List<PromoEntity>)
}