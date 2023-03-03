package com.example.androidroadmap.solid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.solid.presentation.ui.theme.AndroidRoadmapTheme

@Composable
fun DIPPage() {

    val externalDatabaseService = ExternalDatabaseService()
    val localDatabaseService = LocalDatabaseService()

    /**
     * Como ambas clases implementan la interfaz Post, la clase PostService
     * podra obtener cualquiera de las dos como parametro de entrada y ejecutar
     * la función getPost
     */

    val postService = PostService(externalDatabaseService)



    Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background
    )
    {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMenu(text = "Get post") {
                postService.getPost()
            }

        }
    }
}

interface Post {
    fun getPost()
}

class PostService(private val post: Post) {
    fun getPost() {
        this.post.getPost()
    }
}

class ExternalDatabaseService : Post {
    override fun getPost() {
        println("get post from json database service")
    }
}

class LocalDatabaseService : Post {
    override fun getPost() {
        println("get post from local database service")
    }
}