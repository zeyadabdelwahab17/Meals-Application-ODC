package com.example.domain.repo.meals

import com.example.domain.entity.mealsResponse

interface MealsRepo {

    suspend fun GetMealsCategoriesFromRemote() : mealsResponse


}