package com.training.mealzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mealsViewModel : MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mealsRv = findViewById<RecyclerView>(R.id.category_rv)

        val mealsAdapter = MealsAdapter()
        // init rv
        mealsRv.adapter = mealsAdapter
        mealsViewModel.getMeals()


        // observe
        lifecycleScope.launch {
            mealsViewModel.categories.collect{
                mealsAdapter.submitList(it?.categories)

            }
        }
    }
}



/* in app layer
    all files related to view or ui
    viewModel ->> possible add it in presentation layer
    di

 */


/* onion architecture pattern or clean architecture
    three layers in my app :
        app : contain libraries of andorid like retrofit and view and viewModel, ....
        data : mid level between domain and app layers
        domain : abstraction layer know all operations happended in my app without have any library for android

 */
/*
    View -> ViewModel -> UseCase -> Repository -> source of data >>> apiService or room
    view -> recieve inputs and show outputs
    viewModel -> format data and send it to view
    useCase -> handle logic and request data from repo and retrun it to viewModel
    Repo -> know source of data
    apiService or room -> source of data
 */
/*  json formatter like postman
    use meals api to request meals and show it on a screen of my app
 */