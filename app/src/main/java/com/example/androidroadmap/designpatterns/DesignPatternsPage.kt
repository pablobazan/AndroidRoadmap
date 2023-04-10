package com.example.androidroadmap.designpatterns

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
fun DesignPatternsPage(navController: NavHostController) {

    val listOfPages = listOf(
        Page("Factory Method", Routes.FACTORY_PAGE),
        Page("Abstract Factory", Routes.ABSTRACT_FACTORY_PAGE),
        Page("Builder", Routes.BUILDER_PAGE),
    )


    Scaffold { padding ->

        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(text = stringResource(id = R.string.design_patterns))
            MenuList(listOfPages = listOfPages, navController = navController)
        }
    }
}