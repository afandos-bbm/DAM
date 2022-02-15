import 'package:flutter/material.dart';

class DarkTheme {
  static const brightness = Brightness.dark;
  static const primaryColor = const Color.fromARGB(255, 71, 207, 4);
  static const lightColor = const Color.fromARGB(255, 200, 200, 200);
  static const backgroundColor = const Color.fromARGB(255, 0, 0, 0);
  static const reverseColor = const Color.fromARGB(255, 255, 255, 255);

  static ThemeData getDarkTheme() {
    return ThemeData(
      brightness: brightness,
    );
  }
}
