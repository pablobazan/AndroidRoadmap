package com.example.androidroadmap.compose.catalog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androidroadmap.R
import com.example.androidroadmap.core.widgets.Title

@Composable
fun ComposeCatalogPage() {
    Scaffold { padding ->
        Column(
            Modifier
                .fillMaxWidth()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Title(
                text = stringResource(id = R.string.title_activity_jetpack_compose_catalog),
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Componentes")
                Spacer(modifier = Modifier.fillMaxHeight(0.0f))
                ComposableToShow(

                    componentName = "Text",
                    content = { MyComposableText() },
                )
                ComposableToShow(

                    componentName = "TextField",
                    content = { MyComposableTextField() },
                )
                ComposableToShow(

                    componentName = "OutlinedTextField",
                    content = { MyComposableOutlinedTextField() },
                )
                ComposableToShow(

                    componentName = "Button",
                    content = { MyComposableButton() },
                )
                ComposableToShow(

                    componentName = "OutlinedButton",
                    content = { MyComposableOutlinedButton() },
                )
                ComposableToShow(

                    componentName = "TextButton",
                    content = { MyComposableTextButton() },
                )
                ComposableToShow(
                    componentName = "Checkbox",
                    content = { MyComposableCheckbox() },
                )
                ComposableToShow(
                    componentName = "TriStateCheckbox",
                    content = { MyComposableTriStateCheckbox() },
                )
                ComposableToShow(
                    componentName = "RadioButton",
                    content = { MyComposableRadioButton() },
                )
                ComposableToShow(
                    componentName = "Switch",
                    content = { MyComposableSwitch() },
                )
                ComposableToShow(
                    componentName = "CircularProgressIndicator",
                    content = { MyComposableCircularProgressIndicator() },
                )
                ComposableToShow(
                    componentName = "LinearProgressIndicator",
                    content = { MyComposableLinearProgressIndicator() },
                )
                ComposableToShow(
                    componentName = "Image",
                    content = { MyComposableImage() },
                )
                ComposableToShow(
                    componentName = "Icon",
                    content = { MyComposableIcon() },
                )
                ComposableToShow(
                    componentName = "BadgeBox",
                    content = { MyComposableBadgeBox() },
                )
                ComposableToShow(
                    componentName = "Card",
                    content = { MyComposableCard() },

                )
                ComposableToShow(
                    componentName = "Divider",
                    content = { MyComposableDivider() },

                )
                ComposableToShow(
                    componentName = "DropdownMenu",
                    content = { MyComposableDropdownMenu() },
                )
                Spacer(modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun ComposableToShow(componentName: String, content: @Composable () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 32.dp)
            .border(border = BorderStroke(1.dp, Color.Black), shape = MaterialTheme.shapes.small).padding(
                vertical =
                32.dp,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Component: $componentName", Modifier.padding(bottom = 12.dp))
        content()
    }
}

@Composable
fun MyComposableText() {
    Text(
        text = "This is a text",
        style = TextStyle(
            textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline),
            ),
        ),
    )
}

@Composable
fun MyComposableTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = {
        myText = if (it.contains("a")) {
            it.replace("a", "")
        } else {
            it
        }
    }, label = { Text(text = "Enter your name") })
}

@Composable
fun MyComposableOutlinedTextField() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = { text -> myText = text },
        modifier = Modifier.padding(all = 5.dp),
        label = { Text(text = "Enter your name") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Green,
        ),
    )
}

@Composable
fun MyComposableButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.Green,
        ),
        border = BorderStroke(2.dp, color = Color.Green),
        enabled = true,
    ) {
        Text(text = "Button")
    }
}

@Composable
fun MyComposableOutlinedButton() {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.Green,
            disabledBackgroundColor = Color.Black,
            disabledContentColor = Color.White,
        ),
        enabled = true,
    ) {
        Text(text = "OutlinedButton")
    }
}

@Composable
fun MyComposableTextButton() {
    TextButton(onClick = { }) {
        Text(text = "TextButton")
    }
}

@Composable
fun MyComposableImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "description",
        modifier = Modifier
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.DarkGray, shape = CircleShape),

    )
}

@Composable
fun MyComposableIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon description", tint = Color.Red)
}

@Composable
fun MyComposableCheckbox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }

    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Green,
            uncheckedColor = Color.DarkGray,
            checkmarkColor = Color.Blue,
        ),
    )
}

@Composable
fun MyComposableTriStateCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> {
                ToggleableState.Off
            }

            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyComposableSwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta,
            uncheckedTrackColor = Color.Cyan,
        ),
    )
}

@Composable
fun MyComposableCircularProgressIndicator() {
    CircularProgressIndicator(color = Color.Red, strokeWidth = 3.dp)
}

@Composable
fun MyComposableLinearProgressIndicator() {
    LinearProgressIndicator(color = Color.Red, backgroundColor = Color.Black)
}

@Composable
fun MyComposableRadioButton() {
    var status by rememberSaveable {
        mutableStateOf(false)
    }
    RadioButton(
        selected = status,
        onClick = { status = !status },
        colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            disabledColor = Color.Green,
            unselectedColor = Color.Black,

        ),
    )
}

@Composable
fun MyComposableBadgeBox() {
    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        BadgedBox(
            badge = { Badge { Text(text = "1") } },
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
            )
        }
    }
}

@Composable
fun MyComposableCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 32.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        contentColor = Color.Red,
        backgroundColor = Color.White,
    ) {
        Column(modifier = Modifier) {
            Text(text = "Textito")
            Text(text = "Textito")
            Text(text = "Textito")
        }
    }
}

@Composable
fun MyComposableDivider() {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        Text(text = "Textito")
        Divider(Modifier.fillMaxWidth(), color = Color.Gray)
        Text(text = "Textito")
    }
}

@Composable
fun MyComposableDropdownMenu() {
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedText by remember {
        mutableStateOf("")
    }

    val dessert = listOf("Helado", "Mañana", "Es", "Viernes")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth(),
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            dessert.forEach { dessert ->
                DropdownMenuItem(
                    onClick =
                    {
                        expanded = false
                        selectedText = dessert
                    },
                ) {
                    Text(text = dessert)
                }
            }
        }
    }
}
