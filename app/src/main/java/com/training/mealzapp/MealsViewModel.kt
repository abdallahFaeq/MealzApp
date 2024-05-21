package com.training.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.domain.entity.CategoryResponse
import com.training.domain.useCase.GetMealz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase : GetMealz
):ViewModel(){

    private var _categories:MutableStateFlow<CategoryResponse?>  = MutableStateFlow(null)
    val categories : StateFlow<CategoryResponse?> = _categories

    fun getMeals(){
        viewModelScope.launch {
            try {
                _categories.value = getMealsUseCase()
            }catch (e:IOException){
                Log.e("MealsViewModel", e.message.toString() )
            }
        }
    }
}