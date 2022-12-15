package com.example.androidroadmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidroadmap.core.Page
import com.example.androidroadmap.core.Routes
import com.example.androidroadmap.core.NavigationUtils
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.ui.theme.AndroidRoadmapTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRoadmapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Roadmap Android",
                            Modifier.padding(top = 20.dp),
                            fontSize = 24.sp
                        )
                        MenuList(Routes.pages)

                    }
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
                    NavigationUtils.startActivity(
                        context,
                        listOfPages[index].className
                    )
                })
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidRoadmapTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Roadmap Android", Modifier.padding(top = 20.dp), fontSize = 24.sp)
            MenuList(Routes.pages)

        }
    }
}