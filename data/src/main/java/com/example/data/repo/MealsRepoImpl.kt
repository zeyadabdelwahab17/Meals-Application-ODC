package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.mealsResponse
import com.example.domain.repo.meals.MealsRepo

class MealsRepoImpl(private val apiService: ApiService):MealsRepo {
    override suspend fun GetMealsCategoriesFromRemote(): mealsResponse = apiService.getMeals()
}