package de.olk90.codeTextField.logic

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import kotlin.text.isWhitespace

fun formatText(textState: MutableState<TextFieldValue>, newValue: TextFieldValue) {
    val currentText = newValue.text
    val cursorPosition = newValue.selection.start

    appendClosingBrackets(textState, newValue)

//    if (currentText.endsWith("\n")) {
//        val lines = currentText.split("\n")
//        val lastLine = lines.last().takeWhile { it == '\t' || it.isWhitespace() }
//        val tabs = countLeadingTabs(lastLine)
//
//        val newLineIndentation = lastLine + "\t".repeat(tabs) // Add tabs based on last line
//
//        textState.value = TextFieldValue(
//            currentText + newLineIndentation,
//            selection = TextRange(currentText.length + newLineIndentation.length)
//        )
//    } else {
//        // If not a newline, just update text without changing cursor position
//        textState.value = TextFieldValue(currentText, selection = TextRange(cursorPosition))
//    }
}


private fun countLeadingTabs(input: String): Int {
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

private fun appendClosingBrackets(textState: MutableState<TextFieldValue>, newValue: TextFieldValue) {
    val bracketsMap: Map<Char, Char> = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']',
        '<' to '>',
        '\"' to '\"',
        '\'' to '\''
    )

    // Check if the last character entered is an opening bracket
    val openingBrackets = bracketsMap.keys
    val lastSymbol = newValue.text.last()
    if (newValue.text.length > textState.value.text.length && openingBrackets.contains(lastSymbol)) {
        // Insert a closing bracket at the current cursor position
        val cursorPosition = newValue.selection.start
        val closingBracket = bracketsMap[lastSymbol]
        val updatedText = newValue.text + closingBracket

        // Set cursor position to be right after the opening bracket
        textState.value = TextFieldValue(updatedText, selection = TextRange(cursorPosition))
    } else {
        // Update normally if no opening bracket was added
        textState.value = newValue
    }
}