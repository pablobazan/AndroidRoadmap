package com.example.androidroadmap.core.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidroadmap.core.Page
import com.example.androidroadmap.core.Utils

@Composable
fun MenuList(listOfPages: List<Page>, navController: NavHostController) {
    LazyColumn(
        Modifier.padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listOfPages.size) { index ->
            ButtonMenu(
                text = listOfPages[index].name,
                width = 0.9f,
                onClick = {
                    navController.navigate(listOfPages[index].route)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            if (Utils.isNotLastItemInList(index, listOfPages)) {
                Divider(Modifier.fillMaxWidth(0.9f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}