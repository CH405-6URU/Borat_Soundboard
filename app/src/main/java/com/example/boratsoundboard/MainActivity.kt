package com.example.boratsoundboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.boratsoundboard.ui.theme.BoratSoundboardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoratSoundboardTheme {
                val viewModel = viewModel<HomeScreenViewModel>()
                Home(viewModel)

            }
        }
    }
}

