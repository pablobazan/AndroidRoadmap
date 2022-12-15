package com.example.androidroadmap.core.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonMenu(text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .width(350.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
        onClick = onClick,
    ) {
        Text(text = text, color = Color.Blue)

    }
}