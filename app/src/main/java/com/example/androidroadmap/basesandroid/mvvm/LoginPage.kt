package com.example.androidroadmap.basesandroid.mvvm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidroadmap.R
import com.example.androidroadmap.basesandroid.mvvm.widgets.LoginEmailField
import com.example.androidroadmap.basesandroid.mvvm.widgets.LoginPasswordField

@Composable
fun LoginPage(loginViewModel: LoginViewModel) {

    /**
     * Figma design: https://www.figma.com/file/pIv2UEL3Ac4TbKkshmC82Q/Real-Estate-App-%7C-Login-and-Signup-screen-%7C-Ui-Design-(Community)?node-id=1%3A11&t=CL0EYzJ8pz6j0yMn-0
     */

    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)
    val isRememberMe: Boolean by loginViewModel.rememberMeSwitch.observeAsState(initial = false)

    Background()
    Scaffold(
        modifier = Modifier.padding(horizontal = 28.dp),
        backgroundColor = Color.Transparent
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(padding),
            horizontalAlignment = Alignment.Start,

            ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = "Login",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            LoginEmailField(email = email, onTextChanged = { loginViewModel.onLoginChanged(it, password) })
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            LoginPasswordField(password = password, onTextChanged = { loginViewModel.onLoginChanged(email, it) })
            Spacer(modifier = Modifier.fillMaxHeight(0.02f))
            LoginSwitch(checked = isRememberMe, onSwitchChange = { loginViewModel.onRememberMeSwitchChanged(it) })
            Spacer(modifier = Modifier.fillMaxHeight(0.08f))
            LoginButton(loginEnable = isLoginEnable)

        }
    }
}

@Composable
fun LoginButton(loginEnable: Boolean) {
    Button(
        onClick = { },
        enabled = loginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.18f),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF0ACF83),
            disabledBackgroundColor = Color.Gray,
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log In")
    }
}

@Composable
fun LoginSwitch(checked: Boolean, onSwitchChange: (Boolean) -> Unit) {

    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Switch(
            modifier = Modifier
                .weight(15F, fill = true),
            checked = checked,
            onCheckedChange = { onSwitchChange(it) },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF0ACF83),
                uncheckedThumbColor = Color.White,
                checkedTrackColor = Color(0xFFA09F99),
                uncheckedTrackColor = Color(0xFFA09F99)
            )
        )
        Text(
            modifier = Modifier.weight(30F, fill = true),
            text = "Remember me",
            color = Color(0xFFA09F99),
            fontSize = 12.sp,
            fontWeight = FontWeight.W400
        )
        Spacer(modifier = Modifier.weight(25F))
        Text(
            modifier = Modifier.weight(30F, fill = true),
            text = "Forgot password?",
            color = Color(0xFFA09F99),
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

    }
}

@Composable
fun Background() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f),
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = "background",
            contentScale = ContentScale.FillWidth,
            //        colorFilter = ColorFilter.tint(Color.Black, BlendMode.Overlay)
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))

        )
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(brush = Brush.verticalGradient(listOf(Color.Black, Color.Transparent)))

        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginPage(loginViewModel = LoginViewModel())
}