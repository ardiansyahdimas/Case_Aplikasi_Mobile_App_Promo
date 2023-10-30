package com.caseaplikasi.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.caseaplikasi.core.data.source.local.entity.PromoEntity

@Database(entities = [
    PromoEntity::class,
], version = 1, exportSchema = false)
abstract class PromoDatabase : RoomDatabase() {
    abstract fun promoDao(): PromoDao
}