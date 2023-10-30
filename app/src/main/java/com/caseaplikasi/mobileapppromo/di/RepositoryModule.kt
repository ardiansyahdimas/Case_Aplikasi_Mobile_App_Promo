package com.caseaplikasi.mobileapppromo.di

import com.caseaplikasi.core.data.PromoRepository
import com.caseaplikasi.core.domain.repository.IPromoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePromoRepository(promoRepository: PromoRepository): IPromoRepository
}