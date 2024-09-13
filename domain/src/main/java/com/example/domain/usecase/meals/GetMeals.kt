package com.example.domain.usecase.meals

import com.example.domain.repo.meals.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {

    operator suspend fun invoke() = mealsRepo.GetMealsCategoriesFromRemote()
}