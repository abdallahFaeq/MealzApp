package com.training.data.repoImp

import com.training.data.remote.ApiService
import com.training.domain.entity.CategoryResponse
import com.training.domain.repo.MealsRepo

class MealsRepoImp(private val apiService: ApiService) :MealsRepo{
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}