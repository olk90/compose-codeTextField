package de.olk90.codeTextField

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.olk90.codeTextField.view.CodeTextField

@Composable
fun App() {
    val text = remember { mutableStateOf(TextFieldValue("Hello, World!")) }

    MaterialTheme {
        CodeTextField(modifier = Modifier.fillMaxSize(), content = text)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
