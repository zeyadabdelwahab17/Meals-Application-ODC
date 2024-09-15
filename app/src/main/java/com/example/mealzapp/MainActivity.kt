package com.example.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealzapp.ui.theme.MealzAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv:RecyclerView = findViewById(R.id.category_rv)

        // Initialize MealsAdapter
        val mealsAdapter = MealsAdapter()

        // Fetch meals
        viewModel.getmeals()

        // Observe data changes
        lifecycleScope.launch {
            viewModel.Categories.collect { result ->
                // Submit the list to the adapter
                mealsAdapter.submitList(result?.categories)
                rv.adapter = mealsAdapter
            }
        }
    }
}
