# compose-codeTextField

## Overview

**CodeTextField** is a custom text field component for Compose Desktop applications, designed specifically for
code editing. It provides enhanced functionality such as automatic indentation, bracket matching, and monospaced font
styling.

## Features

- **Automatic Indentation**: Maintains the indentation level of the previous line when creating a new line.
- **Bracket Matching**: Automatically inserts closing brackets for opening brackets, improving code structure and
  reducing errors.

## Installation

To use CodeTextField in your Compose Desktop project, clone this repository and include the necessary files in your
project structure.

```bash
git clone https://github.com/olk90/compose-codeTextField.git
```

## Usage in your project

```kotlin
@Composable
fun App() {
    val text = remember { mutableStateOf(TextFieldValue("Hello, World!")) }

    MaterialTheme {
        CodeTextField(modifier = Modifier.fillMaxSize(), content = text)
    }
}
```

## How It Works

The CodeTextField consists of two main components:
CodeTextField composable function: This is the UI component that renders the text field.
formatText function: This handles the logic for text formatting, including indentation and bracket matching.
The text formatting occurs in real-time as the user types, providing immediate feedback and assistance.

## Contributing

Contributions to improve CodeTextField are welcome. Please feel free to submit issues and pull requests.