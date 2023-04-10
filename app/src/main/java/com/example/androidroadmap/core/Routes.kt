package com.example.androidroadmap.core

object Routes {

    const val HOME_PAGE = "Home"

    //Home
    const val SOLID_PAGE = "SOLID"
    const val COMPOSE_PAGE = "Jetpack Compose"
    const val BASES_ANDROID_PAGE = "Bases Android"
    const val POO = "POO"
    const val DESIGN_PATTERNS = "Patrones de Diseño"

    //BasesAndroid
    const val MVVM = "MVVM"
    const val LIFECYCLE = "Lifecycle"

    //SOLID
    const val SRP_PAGE = "SRP"
    const val OCP_PAGE = "OCP"
    const val LSP_PAGE = "LSP"
    const val ISP_PAGE = "ISP"
    const val DIP_PAGE = "DIP"

    //Compose
    const val COMPONENTS_PAGE = "Componentes"
    const val ANIMATIONS_PAGE = "Animaciones"

    //Design Patterns
    const val FACTORY_PAGE = "Factory Method"
    const val ABSTRACT_FACTORY_PAGE = "Abstract Factory"
    const val SINGLETON_PAGE = "Singleton"
    const val BUILDER_PAGE = "Builder"
    const val PROTOTYPE_PAGE = "Prototype"

    val initialPages = listOf(
        SOLID_PAGE,
        BASES_ANDROID_PAGE,
        POO,
        COMPOSE_PAGE,
        DESIGN_PATTERNS
    )

    val BasesAndroidPages = listOf(
        MVVM, LIFECYCLE
    )
}

data class Page(
    val name: String,
    val route: String
)