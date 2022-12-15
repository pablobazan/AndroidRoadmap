package com.example.androidroadmap.solid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.core.NavigationUtils
import com.example.androidroadmap.core.Page
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.solid.presentation.theme.AndroidRoadmapTheme

class SolidActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val listOfPages = listOf(
            Page("S – Single Responsibility Principle (SRP)", SRPActivity::class.java),
            Page("O – Open/Closed Principle (OCP)", OCPActivity::class.java),
            Page("L – Liskov Substitution Principle (LSP)", LiskovActivity::class.java),
            Page("I – Interface Segregation Principle (ISP)", ISPActivity::class.java),
            Page("D – Dependency Inversion Principle (DIP)", DIPActivity::class.java),
        )

        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            AndroidRoadmapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MenuList(listOfPages = listOfPages)
                }
            }
        }
    }
}

@Composable
fun MenuList(listOfPages: List<Page>) {
    val context = LocalContext.current
    LazyColumn(
        Modifier.padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listOfPages.size) { index ->
            ButtonMenu(
                text = listOfPages[index].name,
                onClick = {
                    NavigationUtils.startActivity(context, listOfPages[index].className)
                }
            )
        }
    }
}