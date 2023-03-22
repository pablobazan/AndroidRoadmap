package com.example.androidroadmap.compose.catalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androidroadmap.R
import com.example.androidroadmap.core.widgets.Title

@Composable
fun ComposeCatalogPage() {

    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(
                text = stringResource(id = R.string.title_activity_jetpack_compose_catalog)
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.05f))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Componentes")

            }
        }
    }
}


