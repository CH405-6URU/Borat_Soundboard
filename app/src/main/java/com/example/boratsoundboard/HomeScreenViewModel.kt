package com.example.boratsoundboard

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    var isAngle by mutableStateOf(false)
    var isVisible by mutableStateOf(false)
    var topImage by mutableStateOf(R.drawable.borat_suit)
    var spinAmount by mutableStateOf(0f)

    val delayTime = 5000

    fun changeTopImage(newImage: Int) {

        topImage = if (topImage != newImage) {
            newImage
        } else {
            R.drawable.borat_suit
        }
    }

    fun changeIsAngle(){
        isAngle = !isAngle
    }
    fun changeIsVisible(){
        isVisible = !isVisible
    }

}