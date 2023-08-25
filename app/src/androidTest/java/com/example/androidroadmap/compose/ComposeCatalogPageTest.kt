package com.example.androidroadmap.compose

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.androidroadmap.compose.catalog.MyComposableDivider
import org.junit.Rule
import org.junit.Test

class ComposeCatalogPageTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            MyComposableDivider()
        }
    }
}
