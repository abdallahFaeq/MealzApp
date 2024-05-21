package com.training.domain.useCase

import com.training.domain.repo.MealsRepo

class GetMealz (private val mealsRepo: MealsRepo) {
    suspend operator fun invoke() = mealsRepo.getMealsFromRemote()
}
/*
    logic ..
    call all functions inside repository
 */