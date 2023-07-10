package com.example.androidroadmap.designpatterns.creational_patterns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
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
fun FactoryMethod() {
    var showModal by remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Column(
            Modifier.padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonMenu(
                text = "Show modal",
                onClick = {
                    showModal = true
                },
            )
            ModalFactory().createModal(ModalType.values().random()).Show(showModal) { showModal = false }
        }
    }
}

interface Modal {
    @Composable
    fun Show(showModal: Boolean, onDismiss: () -> Unit)
}

enum class ModalType {
    MacModal, LinuxModal, WindowsModal
}

class ModalFactory {
    fun createModal(type: ModalType): Modal {
        return when (type) {
            ModalType.MacModal -> MacModal()
            ModalType.LinuxModal -> LinuxModal()
            ModalType.WindowsModal -> WindowsModal()
        }
    }
}

class WindowsModal : Modal {
    @Composable
    override fun Show(showModal: Boolean, onDismiss: () -> Unit) {
        if (showModal) {
            AlertDialog(
                title = { Text("Windows Modal") },
                onDismissRequest = { onDismiss() },
                buttons = {},
            )
        }
    }
}

class LinuxModal : Modal {
    @Composable
    override fun Show(showModal: Boolean, onDismiss: () -> Unit) {
        if (showModal) {
            AlertDialog(
                title = { Text("Linux Modal") },
                onDismissRequest = { onDismiss() },
                buttons = {},
            )
        }
    }
}

class MacModal : Modal {
    @Composable
    override fun Show(showModal: Boolean, onDismiss: () -> Unit) {
        if (showModal) {
            AlertDialog(
                title = { Text("Mac Modal") },
                onDismissRequest = { onDismiss() },
                buttons = {},
            )
        }
    }
}
