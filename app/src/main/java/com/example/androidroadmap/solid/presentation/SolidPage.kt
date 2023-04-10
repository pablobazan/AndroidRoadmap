package com.example.androidroadmap.solid.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.androidroadmap.R
import com.example.androidroadmap.core.Page
import com.example.androidroadmap.core.Routes
import com.example.androidroadmap.core.widgets.MenuList
import com.example.androidroadmap.core.widgets.Title

@Composable
fun SolidPage(navController: NavHostController) {

    val listOfPages = listOf(
        Page("S – Single Responsibility Principle (SRP)", Routes.SRP_PAGE),
        Page("O – Open/Closed Principle (OCP)", Routes.OCP_PAGE),
        Page("L – Liskov Substitution Principle (LSP)", Routes.LSP_PAGE),
        Page("I – Interface Segregation Principle (ISP)", Routes.ISP_PAGE),
        Page("D – Dependency Inversion Principle (DIP)", Routes.DIP_PAGE),
    )


    Scaffold { padding ->

        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(text = stringResource(id = R.string.solid))
            MenuList(listOfPages = listOfPages, navController = navController)
        }
    }
}

