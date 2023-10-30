package com.caseaplikasi.mobileapppromo.di

import android.content.Context
import androidx.room.Room
import com.caseaplikasi.core.data.source.local.room.PromoDao
import com.caseaplikasi.core.data.source.local.room.PromoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context : Context): PromoDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("promo".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            PromoDatabase::class.java, "promoApp.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun providePromoDao(database: PromoDatabase): PromoDao = database.promoDao()

}