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
fun Builder() {

    val pizzaBuilder = Pizza.Builder()
    val pizzaDirector = PizzaDirector(pizzaBuilder)
    pizzaDirector.constructMargaritaPizza()
    var pizzaName by remember {
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonMenu(
                text = "Construct pizza with Builder and Director",
                onClick = {
                    when (PizzaType.values().random()) {
                        PizzaType.Margarita -> pizzaDirector.constructMargaritaPizza()
                        PizzaType.Hawaiian -> pizzaDirector.constructHawaiianPizza()
                        PizzaType.Pepperoni -> pizzaDirector.constructPepperoniPizza()
                        PizzaType.Vegetarian -> pizzaDirector.constructVegetarianPizza()
                    }

                    pizzaName = pizzaBuilder.build().name
                },
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Text(text = "Pizza name: $pizzaName")

        }
    }
}

enum class PizzaType {
    Margarita, Hawaiian, Pepperoni, Vegetarian
}

data class Pizza(
    val name: String = "",
    val size: String = "",
    val dough: String = "",
    val sauce: String = "",
    val toppings: List<String> = listOf()
) {

    class Builder {
        private var name: String = ""
        private var size: String = ""
        private var dough: String = ""
        private var sauce: String = ""
        private var toppings: List<String> = listOf()

        fun setName(name: String): Builder {
            this.name = name
            return this
        }
        fun setSize(size: String): Builder {
            this.size = size
            return this
        }

        fun setDough(dough: String): Builder {
            this.dough = dough
            return this
        }

        fun setSauce(sauce: String): Builder {
            this.sauce = sauce
            return this
        }

        fun setToppings(toppings: List<String>): Builder {
            this.toppings = toppings
            return this
        }

        fun build(): Pizza {
            return Pizza(name, size, dough, sauce, toppings)
        }
    }
}

class PizzaDirector(private val builder: Pizza.Builder) {
    fun constructHawaiianPizza() {
        builder.setName("Hawaiian")
            .setSize("Large")
            .setDough("Thin")
            .setSauce("Tomato")
            .setToppings(listOf("Ham", "Pineapple"))
    }

    fun constructMargaritaPizza() {
        builder.setName("Margarita")
            .setSize("Medium")
            .setDough("Thick")
            .setSauce("Tomato")
            .setToppings(listOf("Cheese"))
    }

    fun constructPepperoniPizza() {
        builder.setName("Pepperoni")
            .setSize("Small")
            .setDough("Thin")
            .setSauce("Tomato")
            .setToppings(listOf("Cheese", "Pepperoni"))
    }

    fun constructVegetarianPizza() {
        builder.setName("Vegetarian")
            .setSize("Large")
            .setDough("Thick")
            .setSauce("Tomato")
            .setToppings(listOf("Cheese", "Tomato", "Mushrooms"))
    }
}