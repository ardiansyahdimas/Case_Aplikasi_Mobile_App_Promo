package com.caseaplikasi.mobileapppromo.di

import com.caseaplikasi.core.domain.usecase.PromoInteractor
import com.caseaplikasi.core.domain.usecase.PromoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class
AppModule {

    @Binds
    @ViewModelScoped
    abstract fun providePromoUseCase(promoInteractor: PromoInteractor): PromoUseCase
}