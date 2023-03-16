package com.example.androidroadmap.basesandroid.mvvm.presentation.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginEmailField(email: String, onTextChanged: (String) -> Unit) {
    val focusManager = LocalFocusManager.current


    Column(modifier = Modifier) {
        Text(
            modifier = Modifier.padding(start = 2.dp, bottom = 10.dp),
            text = "Email",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        TextField(
            value = email,
            onValueChange = { onTextChanged(it) },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Email Address") },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFFA09F99),
                backgroundColor = Color(0xFFD8D8DD),
                placeholderColor = Color(0xFFA09F99),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),

            )
    }
}