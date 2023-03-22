package com.example.androidroadmap.compose.animations

import android.opengl.Visibility
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidroadmap.R
import com.example.androidroadmap.core.widgets.Title

@Composable
fun ComposeAnimationsPage() {

    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(
                text = stringResource(id = R.string.title_activity_jetpack_compose_catalog)
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Animaciones", fontSize = 26.sp)
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                ColorAnimation()
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                SizeAnimation()
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                VisibilityAnimation()

            }
        }
    }
}

@Composable
fun ColorAnimation() {
    var firstColor by rememberSaveable { mutableStateOf(false) }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Blue,
        animationSpec = tween(durationMillis = 2000),
        //        finishedListener = { firstColor = !firstColor }
    )


    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click para cambiar de color")
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 450),
    )


    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click para cambiar de tamaño")
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        Box(modifier = Modifier
            .size(size)
            .background(Color.DarkGray)
            .clickable { smallSize = !smallSize })
    }
}

@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable { mutableStateOf(true) }



    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Click para ocultar o mostrar")
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrar / Ocultar")
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        AnimatedVisibility(visible = isVisible, enter = expandVertically(), exit = shrinkVertically()) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Green)
            )
        }

    }
}
