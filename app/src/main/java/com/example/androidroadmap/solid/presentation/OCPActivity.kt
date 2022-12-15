package com.example.androidroadmap.solid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.solid.presentation.ui.theme.AndroidRoadmapTheme

class OCPActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val restClient = Retrofit()
        val httpClient = HttpClient(restClient)
        val imagesDataSource = ImagesDataSource(httpClient)
        val clientDataSource = ClientDataSource(httpClient)

        setContent {
            AndroidRoadmapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        Modifier.padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ButtonMenu(text = "Get image profile") {
                            imagesDataSource.getProfileImage()
                            clientDataSource.getClientData()
                        }

                    }
                }
            }
        }
    }
}

/**
 * Wrong implementation
 */

class Ktor {
    fun get(url: String) {
        println("getting $url")
    }
}

class WrongImpImagesDataSource() {

    private val ktor = Ktor()

    fun getProfileImage() {
        ktor.get("www.google.com/profileImage")
    }
}

class WrongImpClientDataSource() {

    private val ktor = Ktor()

    fun getClientData() {
        ktor.get("www.google.com/client/data")
    }
}

/**
 * Correct implementation
 */

class Retrofit {
    fun get(url: String) {
        println("getting $url")
    }
}

//Esto elimina la fuerte dependencia con la librería utilizada en el restClient
class HttpClient(private val restClient: Retrofit) {

    fun get(url: String) {
        restClient.get(url)
    }
}

class ImagesDataSource(private val httpClient: HttpClient) {

    fun getProfileImage() {
        httpClient.get("www.google.com/profileImage")
    }
}

class ClientDataSource(private val httpClient: HttpClient) {

    fun getClientData() {
        httpClient.get("www.google.com/client/data")
    }
}