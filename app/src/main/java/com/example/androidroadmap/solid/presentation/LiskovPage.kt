package com.example.androidroadmap.solid.presentation

import androidx.compose.foundation.layout.Column
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
fun LiskovPage() {

    val listOfException = listOf(
        InvalidUserException(),
        InvalidPasswordException(),
        DuplicatedEmailException(),
        DisabledUserException()
    )

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {

        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMenu(
                text = "Print error",
                onClick = { printClass(listOfException.random()) },
            )
        }
    }
}

private fun printClass(exception: Exception) {
    exception.printClassNameException()
}

abstract class Exception {

    fun printClassNameException() {
        println(this.javaClass.name)
    }
}

class InvalidUserException : Exception() {}

class InvalidPasswordException : Exception() {}

class DuplicatedEmailException : Exception() {}

class DisabledUserException : Exception() {}