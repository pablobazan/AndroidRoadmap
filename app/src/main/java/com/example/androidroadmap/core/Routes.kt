package com.example.androidroadmap.core

import com.example.androidroadmap.bases.BasesAndroid
import com.example.androidroadmap.compose.ComposeCatalogActivity
import com.example.androidroadmap.solid.presentation.SolidActivity

object Routes {

    private const val SOLID_PAGE = "SOLID"
    private const val COMPOSE_PAGE = "Jetpack Compose"
    private const val BASES_ANDROID_PAGE = "Bases Android"


    val pages = listOf(
        Page(SOLID_PAGE, SolidActivity::class.java),
        Page(COMPOSE_PAGE, ComposeCatalogActivity::class.java),
        Page(BASES_ANDROID_PAGE, BasesAndroid::class.java),
    )
}

data class Page(
    val name: String,
    val className: Class<*>
)