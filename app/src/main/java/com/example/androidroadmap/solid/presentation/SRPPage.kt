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
fun SRPPage() {

    val productService = ProductService()
    val mailer = Mailer()

    val productBloc = ProductBloc(productService = productService, mailer = mailer)

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMenu(text = "Save product") {
                productBloc.saveProduct()
            }
            ButtonMenu(text = "Load product") {
                productBloc.loadProduct()
            }
            ButtonMenu(text = "Notify clients") {
                productBloc.notifyClients()
            }

        }
    }
}

class WrongProductBloc {

    fun saveProduct() {
        println("Saving product")
    }

    fun loadProduct() {
        println("Loading product")
    }

    fun sendEmail() {
        println("Sending emails")
    }
}

//BLoC - Business Logic Component
class ProductBloc(private val productService: ProductService, private val mailer: Mailer) {

    fun saveProduct() {
        productService.saveProduct()
    }

    fun loadProduct() {
        productService.loadProduct()
    }

    fun notifyClients() {
        mailer.sendEmail()
    }
}

class ProductService {

    fun saveProduct() {
        println("Saving product")
    }

    fun loadProduct() {
        println("Loading product")
    }
}

class Mailer {

    fun sendEmail() {
        println("Sending emails")
    }
}