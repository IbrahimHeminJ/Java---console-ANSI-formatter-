/*
Ttitle: ANSIFormatter.Java
Detail: A Java class that provides ANSI escape codes for text formatting in terminal outputs.
        It includes standard colors, styles, background colors, and additional functionalities
        like cursor movement, screen clearing, and text boxing with custom Unicode characters.
package com.Hasarasoft.ansiformatter;
Auther: Ibrahim H. Jameel - Hasarasoft
Date: 2026-02-05
Copyright: Hasarasoft © 2024-2026. All rights reserved.
Contact: ibrahimheminj.github.io
*/
public class ANSIForamatter{
    public static final String RESET = "\u001B[0m"; // Reset all attributes

    // Text Colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m", MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Text Styles
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String STRIKEHROUGH = "\u001B[9m";
    public static final String REVERSED = "\u001B[7m"; // Reverse foreground and background colors

    // Background Colors
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m", MAGENTA_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    // Bright Text Colors
    public static final String BRIGHT_BLACK = "\u001B[90m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m", BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";

    // Bright Background Colors
    public static final String BRIGHT_BLACK_BACKGROUND = "\u001B[100m";
    public static final String BRIGHT_RED_BACKGROUND = "\u001B[101m";
    public static final String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
    public static final String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
    public static final String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
    public static final String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m", BRIGHT_MAGENTA_BACKGROUND = "\u001B[105m";
    public static final String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
    public static final String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";

    // Reset Specific Attributes
    public static final String RESET_BOLD = "\u001B[21m";
    public static final String RESET_UNDERLINE = "\u001B[24m";
    public static final String RESET_REVERSED = "\u001B[27m";
    public static final String RESET_STRIKETHROUGH = "\u001B[29m";

    //Custome colors: 256-Color Mode (Extended Colors) ,TrueColor (24-bit RGB).
    public static String foreground256(int color) {
        return "\u001B[38;5;" + color + "m";
    }
    public static String background256(int color) {
        return "\u001B[48;5;" + color + "m";
    }


    public static String foregroundHex(String hex) {
        int[] rgb = hexToRgb(hex);
        return "\u001B[38;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m";
    }

    public static String backgroundHex(String hex) {
        int[] rgb = hexToRgb(hex);
        return "\u001B[48;2;" + rgb[0] + ";" + rgb[1] + ";" + rgb[2] + "m";
    }

    public static String foregroundRGB(int r, int g, int b) {
        return "\u001B[38;2;" + r + ";" + g + ";" + b + "m";
    }
    public static String backgroundRGB(int r, int g, int b) {
        return "\u001B[48;2;" + r + ";" + g + ";" + b + "m";
    }

    //Cursor Movement and Control:
    public static final String CURSOR_UP = "\u001B[A";
    public static final String CURSOR_DOWN = "\u001B[B";
    public static final String CURSOR_FORWARD = "\u001B[C";
    public static final String CURSOR_BACKWARD = "\u001B[D";
    public static String cursorMoveTo(int row, int col) {
        return "\u001B[" + row + ";" + col + "H";
    }


    //Additional Effects
    public static final String BLINK = "\u001B[5m";
    public static final String INVISIBLE = "\u001B[8m";


    // Helper Method to Convert Hex to RGB
    private static int[] hexToRgb(String hex) {
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        if (hex.length() != 6) {
            throw new IllegalArgumentException("Invalid hexadecimal color format");
        }
        return new int[]{
                Integer.parseInt(hex.substring(0, 2), 16), // Red
                Integer.parseInt(hex.substring(2, 4), 16), // Green
                Integer.parseInt(hex.substring(4, 6), 16)  // Blue
        };
    }

    //Text Decorations Beyond Bold/Italic/Underline
    //Dim/Faint Text (less bright):
    public static final String DIM = "\u001B[2m";

    //Double Underline:
    public static final String DOUBLE_UNDERLINE = "\u001B[21m";

    //Overline:
    public static final String OVERLINE = "\u001B[53m";

    //Clear Entire Screen:
    public static final String CLEAR_SCREEN = "\u001B[2J";

    //Clear Line (current line):
    public static final String CLEAR_LINE = "\u001B[2K";

    //Clear From Cursor:
    public static final String CLEAR_FROM_CURSOR = "\u001B[0J";
    public static final String CLEAR_TO_CURSOR = "\u001B[1J";

    //Cursor Visibility and Saving State

    //Hide/Show Cursor:
    public static final String HIDE_CURSOR = "\u001B[?25l";
    public static final String SHOW_CURSOR = "\u001B[?25h";

    //Save/Restore Cursor Position:
    public static final String SAVE_CURSOR = "\u001B[s";
    public static final String RESTORE_CURSOR = "\u001B[u";

    //Advanced Cursor Movement

    //Move Cursor Up/Down by N Lines:
    public static String moveCursorUp(int n) {
        return "\u001B[" + n + "A";
    }

    public static String moveCursorDown(int n) {
        return "\u001B[" + n + "B";
    }

    //Horizontal Movement:

    public static String moveCursorRight(int n) {
        return "\u001B[" + n + "C";
    }
    public static String moveCursorLeft(int n) {
        return "\u001B[" + n + "D";
    }

    //Sound alert
    public static final String BEEP = "\u0007";

    //Mouse Interactions
    //Enable mouse tracking:
    public static final String ENABLE_MOUSE = "\u001B[?1000h";
    //Disable mouse tracking:
    public static final String DISABLE_MOUSE = "\u001B[?1000l";

    //Hyerlinks
    public static String hyperlink(String url, String text) {
        return "\u001B]8;;" + url + "\u0007" + text + "\u001B]8;;\u0007";
    }

    // Method to box text with custom Unicode characters
    public static String boxText(String input) {
        // Calculate the width of the box (based on input length)
        int width = input.length() + 4; // 2 spaces on each side and 2 borders

        // Top border
        String topBorder = "╔" + "═".repeat(width - 2) + "╗";

        // Bottom border
        String bottomBorder = "╚" + "═".repeat(width - 2) + "╝";

        // Middle line (input with padding)
        String middleLine = "║ " + input + " ║";

        // Return the final result with the box
        return topBorder + "\n" + middleLine + "\n" + bottomBorder;
    }

    // Method to box text with multiple lines and color
    public static String boxTextWithColor(String input, String color) {
        // Split input into multiple lines
        String[] lines = input.split("\n");

        // Find the longest line by stripping ANSI codes and measuring length
        int maxLineLength = 0;
        for (String line : lines) {
            int length = removeAnsiCodes(line).length();
            if (length > maxLineLength) {
                maxLineLength = length;
            }
        }

        // Calculate the width of the box (based on the longest line)
        int width = maxLineLength + 4; // Add space for padding and borders

        // Create top border
        String topBorder = color + "╔" + "═".repeat(width - 2) + "╗" + RESET;

        // Create bottom border
        String bottomBorder = color + "╚" + "═".repeat(width - 2) + "╝" + RESET;

        // Create middle lines with each line of text
        StringBuilder middleLines = new StringBuilder();
        for (String line : lines) {
            middleLines.append(color)
                    .append("║ ")
                    .append(line)
                    .append(" ".repeat(maxLineLength - removeAnsiCodes(line).length())) // Padding to make lines equal length
                    .append(" ║")
                    .append(RESET)
                    .append("\n");
        }

        // Return the complete box with text
        return topBorder + "\n" + middleLines.toString() + bottomBorder;
    }

    public static String multilineBoxText(String input) {
        // Split input into multiple lines
        String[] lines = input.split("\n");

        // Find the longest line by stripping ANSI codes and measuring length
        int maxLineLength = 0;
        for (String line : lines) {
            int length = removeAnsiCodes(line).length();
            if (length > maxLineLength) {
                maxLineLength = length;
            }
        }

        // Calculate the width of the box (based on the longest line)
        int width = maxLineLength + 4; // Add space for padding and borders

        // Create top border
        String topBorder =  "╔" + "═".repeat(width - 2) + "╗" ;

        // Create bottom border
        String bottomBorder = "╚" + "═".repeat(width - 2) + "╝";

        // Create middle lines with each line of text
        StringBuilder middleLines = new StringBuilder();
        for (String line : lines) {
            middleLines
                    .append("║ ")
                    .append(line)
                    .append(" ".repeat(maxLineLength - removeAnsiCodes(line).length())) // Padding to make lines equal length
                    .append(" ║")
                    .append("\n");
        }

        // Return the complete box with text
        return topBorder + "\n" + middleLines.toString() + bottomBorder;
    }

    // Method to remove ANSI color codes from a string
    public static String removeAnsiCodes(String input) {
        // Regular expression to remove any ANSI escape codes
        return input.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    public static String RED(String str){
        return RED + str + RESET;
    }
    public static String GREEN(String str){
        return GREEN + str + RESET;
    }
    public static String BLUE(String str){
        return BLUE + str + RESET;
    }
    public static String YELLOW(String str){
        return YELLOW + str + RESET;
    }
    public static String CYAN(String str){
        return CYAN + str + RESET;
    }
    public static String MAGENTA(String str){
        return MAGENTA + str + RESET;
    }
    public static String PURPLE(String str){
        return PURPLE + str + RESET;
    }
    public static String BLACK(String str){
        return BLACK + str + RESET;
    }
    public static String WHITE(String str){
        return WHITE + str + RESET;
    }
    public static String RED_BACKGROUND(String str){
        return RED_BACKGROUND + str + RESET;
    }
    public static String GREEN_BACKGROUND(String str){
        return GREEN_BACKGROUND + str + RESET;
    }
    public static String BLUE_BACKGROUND(String str){
        return BLUE_BACKGROUND + str + RESET;
    }
    public static String YELLOW_BACKGROUND(String str){
        return YELLOW_BACKGROUND + str + RESET;
    }
    public static String CYAN_BACKGROUND(String str){
        return CYAN_BACKGROUND + str + RESET;
    }
    public static String MAGENTA_BACKGROUND(String str){
        return MAGENTA_BACKGROUND + str + RESET;
    }
    public static String PURPLE_BACKGROUND(String str){
        return PURPLE_BACKGROUND + str + RESET;
    }
    public static String BLACK_BACKGROUND(String str){
        return BLACK_BACKGROUND + str + RESET;
    }
    public static String WHITE_BACKGROUND(String str){
        return WHITE_BACKGROUND + str + RESET;
    }
    public static String BRIGHT_RED(String str){
        return BRIGHT_RED + str + RESET;
    }
    public static String BRIGHT_GREEN(String str){
        return BRIGHT_GREEN + str + RESET;
    }
    public static String BRIGHT_BLUE(String str){
        return BRIGHT_BLUE + str + RESET;
    }
    public static String BRIGHT_CYAN(String str){
        return BRIGHT_CYAN + str + RESET;
    }
    public static String BRIGHT_MAGENTA(String str){
        return BRIGHT_MAGENTA + str + RESET;
    }
    public static String BRIGHT_PURPLE(String str){
        return BRIGHT_PURPLE + str + RESET;
    }
    public static String BRIGHT_YELLOW(String str){
        return BRIGHT_YELLOW + str + RESET;
    }
    public static String BRIGHT_WHITE(String str){
        return BRIGHT_WHITE + str + RESET;
    }
    public static String BRIGHT_BLACK(String str){
        return BRIGHT_BLACK + str + RESET;
    }
    public static String BOLD(String str){
        return BOLD + str + RESET;
    }
    public static String ITALIC(String str){
        return ITALIC + str + RESET;
    }
    public static String UNDERLINE(String str){
        return UNDERLINE + str + RESET;
    }
    public static String STRIKEHROUGH(String str){
        return STRIKEHROUGH + str + RESET;
    }
    public static String DIM(String str){
        return DIM + str + RESET;
    }
    public static String DOUBLE_UNDERLINE(String str){
        return DOUBLE_UNDERLINE + str + RESET;
    }
    public static String OVERLINE(String str){
        return OVERLINE + str + RESET;
    }
    public static void ClearScreen(){
        System.out.print(CLEAR_SCREEN);
    }

//Please Point out defects for future Improvements

}

