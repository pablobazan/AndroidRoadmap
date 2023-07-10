package com.example.androidroadmap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidroadmap.basesandroid.BasesAndroidPage
import com.example.androidroadmap.basesandroid.mvvm.presentation.LoginPage
import com.example.androidroadmap.basesandroid.mvvm.presentation.LoginViewModel
import com.example.androidroadmap.compose.ComposePage
import com.example.androidroadmap.compose.animations.ComposeAnimationsPage
import com.example.androidroadmap.compose.catalog.ComposeCatalogPage
import com.example.androidroadmap.core.Routes
import com.example.androidroadmap.core.Utils.isNotLastItemInList
import com.example.androidroadmap.core.widgets.ButtonMenu
import com.example.androidroadmap.core.widgets.Title
import com.example.androidroadmap.designpatterns.DesignPatternsPage
import com.example.androidroadmap.designpatterns.creational_patterns.AbstractFactory
import com.example.androidroadmap.designpatterns.creational_patterns.Builder
import com.example.androidroadmap.designpatterns.creational_patterns.FactoryMethod
import com.example.androidroadmap.designpatterns.creational_patterns.Prototype
import com.example.androidroadmap.designpatterns.creational_patterns.Singleton
import com.example.androidroadmap.poo.POOPage
import com.example.androidroadmap.solid.presentation.DIPPage
import com.example.androidroadmap.solid.presentation.ISPPage
import com.example.androidroadmap.solid.presentation.LiskovPage
import com.example.androidroadmap.solid.presentation.OCPPage
import com.example.androidroadmap.solid.presentation.SRPPage
import com.example.androidroadmap.solid.presentation.SolidPage
import com.example.androidroadmap.ui.theme.AndroidRoadmapTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidRoadmapTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.HOME_PAGE) {

                    composable(Routes.HOME_PAGE) {
                        HomePage(listOfPages = Routes.initialPages, navController = navController)
                    }

                    //Bases Android
                    composable(Routes.BASES_ANDROID_PAGE) {
                        BasesAndroidPage(
                            listOfPages = Routes.BasesAndroidPages,
                            navController = navController
                        )
                    }
                    composable(Routes.MVVM) { LoginPage(loginViewModel) }

                    //POO
                    composable(Routes.POO) { POOPage(navController = navController) }

                    //Compose
                    composable(Routes.COMPOSE_PAGE) { ComposePage(navController = navController) }
                    composable(Routes.COMPONENTS_PAGE) { ComposeCatalogPage() }
                    composable(Routes.ANIMATIONS_PAGE) { ComposeAnimationsPage() }

                    //SOLID
                    composable(Routes.SOLID_PAGE) { SolidPage(navController = navController) }
                    composable(Routes.OCP_PAGE) { OCPPage() }
                    composable(Routes.LSP_PAGE) { LiskovPage() }
                    composable(Routes.ISP_PAGE) { ISPPage() }
                    composable(Routes.DIP_PAGE) { DIPPage() }
                    composable(Routes.SRP_PAGE) { SRPPage() }

                    //Design Patterns
                    composable(Routes.DESIGN_PATTERNS) {
                        DesignPatternsPage(navController = navController)

                    }
                    composable(Routes.FACTORY_PAGE) { FactoryMethod() }
                    composable(Routes.ABSTRACT_FACTORY_PAGE) { AbstractFactory() }
                    composable(Routes.BUILDER_PAGE) { Builder() }
                    composable(Routes.PROTOTYPE_PAGE) { Prototype() }
                    composable(Routes.SINGLETON_PAGE) { Singleton() }
                }
            }
        }
    }

    @Composable
    fun HomePage(listOfPages: List<String>, navController: NavHostController) {
        Scaffold { padding ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Title(
                    text = stringResource(id = R.string.app_name)
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.05f))
                LazyColumn(
                    Modifier.padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(listOfPages.size) { index ->
                        ButtonMenu(text = listOfPages[index], onClick = {
                            navController.navigate(listOfPages[index])
                        })
                        Spacer(modifier = Modifier.height(10.dp))
                        if (isNotLastItemInList(index, listOfPages)) {
                            Divider(Modifier.fillMaxWidth(0.9f), thickness = 1.dp)
                            Spacer(modifier = Modifier.height(10.dp))
                        }

                    }
                }
            }
        }
    }
}


