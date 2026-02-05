# ANSIFormatter

A comprehensive Java utility class for applying ANSI escape codes to terminal outputs, providing text formatting, colors, cursor control, and advanced terminal features.

## Features

### Text Formatting
- **Colors**: Standard 8-color palette (foreground and background)
- **Bright Colors**: Extended 16-color palette with bright variants
- **Extended Colors**: 256-color mode and TrueColor (24-bit RGB) support
- **Styles**: Bold, italic, underline, strikethrough, reversed, dim, blink
- **Reset Options**: Full reset and individual attribute resets

### Terminal Control
- **Cursor Movement**: Position control, directional movement, and visibility
- **Screen Management**: Clear screen, clear lines, clear from/to cursor
- **Advanced Features**: Mouse tracking, hyperlinks, sound alerts

### Text Decorations
- **Boxed Text**: Create text boxes with Unicode borders
- **Multi-line Support**: Box formatting for multi-line text with color support
- **ANSI Code Removal**: Utility to strip ANSI codes from strings

## Installation

Copy the `ANSIFormatter.java` file into your project's package structure:

```
Example:
com/Hasarasoft/ansiformatter/ANSIFormatter.java
```

## Quick Start

```java
import com.Hasarasoft.ansiformatter.ANSIFormatter;

public class Example {
    public static void main(String[] args) {
        // Basic text coloring
        System.out.println(ANSIFormatter.RED + "This is red text" + ANSIFormatter.RESET);
        
        // Combining styles
        System.out.println(ANSIFormatter.BOLD + ANSIFormatter.GREEN + 
                          "Bold green text" + ANSIFormatter.RESET);
        
        // Background colors
        System.out.println(ANSIFormatter.YELLOW + ANSIFormatter.BLUE_BACKGROUND + 
                          "Yellow text on blue" + ANSIFormatter.RESET);
        
        // Extended colors
        System.out.println(ANSIFormatter.foregroundHex("#FF5733") + 
                          "Custom hex color" + ANSIFormatter.RESET);
        
        // Text boxing
        System.out.println(ANSIFormatter.boxText("Hello World"));
    }
}
```

## Usage Examples

### Basic Formatting
```java
// Simple colored output
System.out.println(ANSIFormatter.CYAN + "Cyan text" + ANSIFormatter.RESET);

// Multiple styles
String formatted = ANSIFormatter.BOLD + ANSIFormatter.UNDERLINE + 
                   ANSIFormatter.YELLOW + "Warning!" + ANSIFormatter.RESET;
System.out.println(formatted);
```

### Advanced Colors
```java
// 256-color mode
System.out.println(ANSIFormatter.foreground256(196) + "Bright red" + ANSIFormatter.RESET);

// TrueColor RGB
System.out.println(ANSIFormatter.foregroundRGB(255, 105, 180) + 
                   "Hot pink" + ANSIFormatter.RESET);

// Hexadecimal colors
System.out.println(ANSIFormatter.backgroundHex("#1E90FF") + 
                   "Dodger blue background" + ANSIFormatter.RESET);
```

### Cursor Control
```java
// Move cursor to specific position
System.out.print(ANSIFormatter.cursorMoveTo(10, 20) + "Text at row 10, column 20");

// Save and restore cursor position
System.out.print(ANSIFormatter.SAVE_CURSOR + "Text" + 
                 ANSIFormatter.RESTORE_CURSOR + "Back to saved position");

// Hide/show cursor
System.out.print(ANSIFormatter.HIDE_CURSOR);
// Do something without visible cursor
System.out.print(ANSIFormatter.SHOW_CURSOR);
```

### Text Boxing
```java
// Simple box
System.out.println(ANSIFormatter.boxText("Single line box"));

// Multi-line box with color
String multiLine = "Line 1\nLine 2 with ANSI" + ANSIFormatter.RED + "RED" + 
                   ANSIFormatter.RESET + " and normal";
System.out.println(ANSIFormatter.boxTextWithColor(multiLine, ANSIFormatter.CYAN));

// Remove ANSI codes from string
String withCodes = ANSIFormatter.RED + "Colored" + ANSIFormatter.RESET + " text";
String withoutCodes = ANSIFormatter.removeAnsiCodes(withCodes);
// withoutCodes = "Colored text"
```

### Screen Management
```java
// Clear entire screen
System.out.print(ANSIFormatter.CLEAR_SCREEN);

// Clear current line
System.out.print(ANSIFormatter.CLEAR_LINE + "New content on cleared line");

// Clear from cursor to end of screen
System.out.print(ANSIFormatter.CLEAR_FROM_CURSOR);
```

### Advanced Features
```java
// Hyperlinks (supported in modern terminals)
System.out.println(ANSIFormatter.hyperlink("https://github.com", "Visit GitHub"));

// Sound alert
System.out.print(ANSIFormatter.BEEP); // Terminal bell

// Mouse tracking (for interactive applications)
System.out.print(ANSIFormatter.ENABLE_MOUSE);
// Process mouse events...
System.out.print(ANSIFormatter.DISABLE_MOUSE);
```

## Color Reference

### Standard Colors
| Constant | Color |
|----------|-------|
| `BLACK` | Black text |
| `RED` | Red text |
| `GREEN` | Green text |
| `YELLOW` | Yellow text |
| `BLUE` | Blue text |
| `PURPLE` | Purple text |
| `CYAN` | Cyan text |
| `WHITE` | White text |

### Background Colors
Append `_BACKGROUND` to color constants (e.g., `RED_BACKGROUND`).

### Bright Colors
Prepend `BRIGHT_` to color constants (e.g., `BRIGHT_RED`, `BRIGHT_RED_BACKGROUND`).

## Compatibility Notes

- **Terminal Support**: Most modern terminals support ANSI escape codes (Linux/macOS terminals, Windows Terminal, PowerShell 7+, Git Bash)
- **Windows CMD**: Limited support; consider using Windows Terminal for full functionality
- **Reset Always**: Always append `ANSIFormatter.RESET` after colored text to prevent style bleeding
- **Performance**: ANSI codes are simple string concatenations with minimal overhead

## API Overview

### Constants
- Color constants: `BLACK`, `RED`, `GREEN`, etc.
- Style constants: `BOLD`, `ITALIC`, `UNDERLINE`, etc.
- Control constants: `CURSOR_UP`, `HIDE_CURSOR`, `CLEAR_SCREEN`, etc.

### Methods
- Color generation: `foreground256()`, `backgroundHex()`, `foregroundRGB()`
- Cursor control: `cursorMoveTo()`, `moveCursorUp()`, etc.
- Text utilities: `boxText()`, `boxTextWithColor()`, `removeAnsiCodes()`
- Helper: `hexToRgb()` (private)

## Best Practices

1. **Always Reset**: Terminate formatted strings with `ANSIFormatter.RESET`
2. **Check Terminal**: Test color support in target environments
3. **Use Sparingly**: Avoid excessive formatting that may reduce readability
4. **Combine Thoughtfully**: Some style combinations may not render consistently across terminals

## License

Copyright © Hasarasoft 2024-2026
Contact: ibrahimheminj.github.io

## Contributing

This is a personal utility class. For modifications, please maintain backward compatibility and include comprehensive examples.

---

**Note**: Terminal color support varies. Test your application in the target environment to ensure proper rendering.
