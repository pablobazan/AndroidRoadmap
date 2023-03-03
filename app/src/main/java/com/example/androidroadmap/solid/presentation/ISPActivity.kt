package com.example.androidroadmap.solid.presentation

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

@Composable
fun ISPPage() {

    val toucan = Toucan()
    val penguin = Penguin()
    val ostrich = Ostrich()

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMenu(
                text = "Print messages",
                onClick = {
                    toucan.fly()
                    penguin.swim()
                    ostrich.run()
                },
            )
        }
    }
}

/*
    El principio de segregación de interfaces (Interface Segregation Principle, ISP)
    establece que las interfaces grandes y genéricas deben ser divididas
    en múltiples interfaces más pequeñas y específicas. Esto permite a las clases
    implementar solo las interfaces que necesitan en lugar de tener que implementar
    interfaces completas que contengan métodos que no utilizan.
 */

/**
 * Wrong implemetation
 */

interface WrongImpBird {
    fun fly()
    fun swim()
    fun run()
}

class WrongImpTucan : WrongImpBird {
    override fun fly() {
        println("Tucan is flying")
    }

    override fun swim() {
        //El tucan no puede nadar
    }

    override fun run() {
        //El tucan no puede correr
    }
}

/**
 * Correct implemetation
 */

interface Bird {
    fun eat()
}

interface FlyingBird {
    fun fly()
}

interface SwimmingBird {
    fun swim()
}

interface RunningBird {
    fun run()
}

class Toucan : Bird, FlyingBird {
    override fun eat() {
        println("Tucan is eating")
    }

    override fun fly() {
        println("Tucan is flying")
    }
}

class Penguin : Bird, SwimmingBird {
    override fun eat() {
        println("Penguin is eating")
    }

    override fun swim() {
        println("Penguin is swimming")
    }
}

class Ostrich : Bird, RunningBird {
    override fun eat() {
        println("Ostrich is eating")
    }

    override fun run() {
        println("Ostrich is running")
    }
}
