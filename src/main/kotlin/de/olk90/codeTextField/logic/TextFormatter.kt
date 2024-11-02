package de.olk90.codeTextField.logic

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import kotlin.text.isWhitespace

fun formatText(textState: MutableState<TextFieldValue>, newValue: TextFieldValue) {
    val currentText = newValue.text
    val cursorPosition = newValue.selection.start

    if (currentText.endsWith("\n")) {
        val lines = currentText.split("\n")
        val lastLine = lines.last().takeWhile { it == '\t' || it.isWhitespace() }
        val tabs = countLeadingTabs(lastLine)

        val newLineIndentation = lastLine + "\t".repeat(tabs) // Add tabs based on last line

        textState.value = TextFieldValue(currentText + newLineIndentation, selection = TextRange(currentText.length + newLineIndentation.length))
    } else {
        // If not a newline, just update text without changing cursor position
        textState.value = TextFieldValue(currentText, selection = TextRange(cursorPosition))
    }
}


fun countLeadingTabs(input: String): Int {
    var count = 0
    for (char in input) {
        if (char == '\t' || char.isWhitespace()) {
            count++
        } else {
            break // Stop counting when a non-tab character is encountered
        }
    }
    return count
}