package com.example.androidroadmap.basesandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidroadmap.R
import com.example.androidroadmap.core.Utils
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.core.widgets.Title

@Composable
fun BasesAndroidPage(listOfPages: List<String>, navController: NavHostController) {

    Scaffold(
    ) { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(
                text = stringResource(id = R.string.title_activity_bases_android)
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            LazyColumn(
                Modifier.padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listOfPages.size) { index ->
                    ButtonMenu(text = listOfPages[index], onClick = {
                        navController.navigate(listOfPages[index])
                    })
                    Spacer(modifier = Modifier.height(10.dp))
                    if (Utils.isNotLastItemInList(index, listOfPages)) {
                        Divider(Modifier.fillMaxWidth(0.9f), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                }
            }
        }
    }
}

