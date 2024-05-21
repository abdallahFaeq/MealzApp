package com.training.mealzapp.di

import com.training.domain.repo.MealsRepo
import com.training.domain.useCase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(repo: MealsRepo):GetMealz{
        return GetMealz(repo)
    }
}