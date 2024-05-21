package com.training.mealzapp.di

import com.training.data.remote.ApiService
import com.training.data.repoImp.MealsRepoImp
import com.training.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideMealRepo(apiService: ApiService):MealsRepo{
        return MealsRepoImp(apiService)
    }
}