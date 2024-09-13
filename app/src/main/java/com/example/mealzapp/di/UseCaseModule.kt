package com.example.mealzapp.di

import com.example.domain.repo.meals.MealsRepo
import com.example.domain.usecase.meals.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides

    fun provideUseCase(mealsRepo: MealsRepo):GetMeals{
        return GetMeals(mealsRepo)
    }

}