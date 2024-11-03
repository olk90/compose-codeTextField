package de.olk90.codeTextField.logic


fun String.insertCharAt(char: Char, index: Int): String {
    val sb = StringBuilder(this)
    sb.insert(index, char)
    return sb.toString()
}