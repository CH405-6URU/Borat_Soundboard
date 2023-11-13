package com.example.boratsoundboard

import android.media.MediaPlayer
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Home(viewModel: HomeScreenViewModel) {
    HomeScreen(viewModel)
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {


    val context = LocalContext.current
    val highFive = MediaPlayer.create(context, R.raw.high_five1)
    val itIsNice = MediaPlayer.create(context, R.raw.it_is_nice)
    val wowWee = MediaPlayer.create(context, R.raw.wow_wow_wee_waa)
    val mineMine = MediaPlayer.create(context, R.raw.mine)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {

        val imageSpin by animateFloatAsState(
            targetValue = if (viewModel.isAngle) viewModel.delayTime / 1000f * 360f else 0f,
            animationSpec = tween(durationMillis = viewModel.delayTime, delayMillis = 0),
            label = "Fucking label there!!"
        )

        AnimatedContent(
            targetState = viewModel.isVisible,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            content = {
                if (it) {
                    viewModel.changeTopImage(R.drawable.seagull)
                    viewModel.spinAmount = imageSpin
                }
            },
            label = "label parameter",
            transitionSpec = {
                fadeIn() with fadeOut()
            },
        )

        Image(
            painter = painterResource(id = viewModel.topImage),
            contentDescription = "Borat in his fancy suit",
            modifier = Modifier
                .size(250.dp)
              //  .rotate(viewModel.spinAmount)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            highFive.start()
            viewModel.changeTopImage(R.drawable.borat_suit)
          //  viewModel.spinAmount = 360f
        }) {
            Text(text = "High-five!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            itIsNice.start()
            viewModel.changeTopImage(R.drawable.borat_suit)
          //  viewModel.spinAmount = 0f
        }) {
            Text(text = "It is nice!")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            wowWee.start()
            viewModel.changeTopImage(R.drawable.borat_suit)
           // viewModel.spinAmount = 0f
        }) {
            Text(text = "Wow wow wee waa")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            mineMine.start()
            viewModel.changeTopImage(R.drawable.seagull)
//            viewModel.changeIsAngle()
//            viewModel.changeIsVisible()
        }) {
            Text("Mine mine mine mine!")
        }

        // Make image only appear when the mine mine mine button is pressed
        // TODO Figure out how to overlay the entire screen with the bird spinning around and around - Gave up
        // get the borat image to stay once its swapped back from the seagull
        // get the viewmodel set up
            // Viewmodel set up and working but I had to scrap the rotation as it was causing problems


    }
}

