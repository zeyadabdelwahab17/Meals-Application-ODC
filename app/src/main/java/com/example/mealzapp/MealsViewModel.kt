package com.example.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.mealsResponse
import com.example.domain.usecase.meals.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealsViewModel @Inject constructor(private val GetMealsUsecase: GetMeals):ViewModel() {


//Encapsulation
    private val _Categories :MutableStateFlow<mealsResponse?> = MutableStateFlow(null)
    val Categories:StateFlow<mealsResponse?> = _Categories

    fun getmeals(){

        viewModelScope.launch {

            try {
                _Categories.value = GetMealsUsecase()
            } catch (e:Exception){
                Log.e("MealsViewModel", e.message.toString())
            }


        }

    }


}