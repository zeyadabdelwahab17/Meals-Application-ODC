package com.example.mealzapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.meals.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService):MealsRepo{
        return MealsRepoImpl(apiService)
    }
}