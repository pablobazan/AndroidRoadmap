package com.example.androidroadmap.designpatterns.creational_patterns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AbstractFactory() {

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MacWidgetFactory().createButton().ShowComposable()
            LinuxWidgetFactory().createButton().ShowComposable()
        }
    }
}

interface WidgetFactory {
    @Composable
    fun createButton(): Widget
}

class MacWidgetFactory : WidgetFactory {

    @Composable
    override fun createButton(): Widget {
        return MacButton()
    }
}

class LinuxWidgetFactory : WidgetFactory {

    @Composable
    override fun createButton(): Widget {
        return LinuxButton()
    }
}

interface Widget {
    @Composable
    fun ShowComposable()
}

class MacButton : Widget {
    @Composable
    override fun ShowComposable() {
        TextButton(modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(0.8f), onClick = { /*TODO*/ }) {
            Text(text = "Mac Button")
        }
    }
}

class LinuxButton : Widget {
    @Composable
    override fun ShowComposable() {
        TextButton(modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth(0.8f), onClick = { /*TODO*/ }) {
            Text(text = "Linux Button")
        }
    }
}