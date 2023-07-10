package com.example.androidroadmap.designpatterns.creational_patterns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.core.widgets.ButtonMenu

@Composable
fun Prototype() {
    val rectangle = Rectangle(10, 20)

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonMenu(
                text = "Text",
                onClick = {
                    val rectangle2 = rectangle.clone()
                    rectangle2.height = 30
                    rectangle2.width = 40
                    println(rectangle2.area())
                },
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
        }
    }
}

class Rectangle(var width: Int, var height: Int) : Cloneable {
    fun area() = width * height

    public override fun clone(): Rectangle {
        return super.clone() as Rectangle
    }
}
