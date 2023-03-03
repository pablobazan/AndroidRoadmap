package com.example.androidroadmap.core

object Routes {

    const val HOME_PAGE = "Home"

    const val SOLID_PAGE = "SOLID"
    const val COMPOSE_PAGE = "Jetpack Compose"
    const val BASES_ANDROID_PAGE = "Bases Android"

    //SOLID
    const val SRP_PAGE = "SRP"
    const val OCP_PAGE = "OCP"
    const val LSP_PAGE = "LSP"
    const val ISP_PAGE = "ISP"
    const val DIP_PAGE = "DIP"



    val initialPages = listOf(
        SOLID_PAGE, COMPOSE_PAGE, BASES_ANDROID_PAGE
    )
}

data class Page(
    val name: String,
    val route: String
)