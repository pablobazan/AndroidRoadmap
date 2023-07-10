package com.example.androidroadmap.designpatterns.creational_patterns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.core.widgets.ButtonMenu

@Composable
fun Singleton() {
    val dataBaseHash = DataBase.getInstance().hashCode()
    var database2: DataBase? = null

    var dataBase2Hash by remember {
        mutableStateOf(0)
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonMenu(
                text = "Print singleton hash code",
                onClick = {
                    database2 = DataBase.getInstance()
                    dataBase2Hash = database2.hashCode()
                },
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Text(text = "Singleton database1 hash code: ${dataBaseHash.hashCode()}")
            Text(text = "Singleton database2 hash code: $dataBase2Hash")
        }
    }
}

class DataBase private constructor() {

    companion object {
        private var instance: DataBase? = null

        fun getInstance(): DataBase {
            if (instance == null) {
                instance = DataBase()
            }
            return instance!!
        }
    }
}
