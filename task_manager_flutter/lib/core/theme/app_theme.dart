import 'package:flutter/material.dart';

class AppThemes {
  // Light Theme
  static final lightTheme = ThemeData(
    brightness: Brightness.light,
    primaryColor: Color(0xFF4CAF50),
    primaryColorDark: Color(0xFF388E3C),
    colorScheme: ColorScheme.light(
      primary: Color(0xFF4CAF50),
      onPrimary: Colors.white,
      secondary: Color(0xFF03A9F4),
      onSecondary: Colors.white,
      background: Color(0xFFF5F5F5),
      onBackground: Color(0xFF212121),
      surface: Colors.white,
      onSurface: Color(0xFF212121),
      error: Color(0xFFF44336),
      onError: Colors.white,
    ),
    scaffoldBackgroundColor: Color(0xFFF5F5F5),
    appBarTheme: AppBarTheme(
      backgroundColor: Color(0xFF4CAF50),
      foregroundColor: Colors.white,
      elevation: 2,
    ),
    cardColor: Colors.white,
    buttonTheme: ButtonThemeData(
      buttonColor: Color(0xFF4CAF50),
      textTheme: ButtonTextTheme.primary,
    ),
    floatingActionButtonTheme: FloatingActionButtonThemeData(
      backgroundColor: Color(0xFF03A9F4),
      foregroundColor: Colors.white,
    ),
  );

  // Dark Theme
  static final darkTheme = ThemeData(
    brightness: Brightness.dark,
    primaryColor: Color(0xFF81C784),
    primaryColorDark: Color(0xFF66BB6A),
    colorScheme: ColorScheme.dark(
      primary: Color(0xFF81C784),
      onPrimary: Color(0xFF212121),
      secondary: Color(0xFF29B6F6),
      onSecondary: Color(0xFF212121),
      background: Color(0xFF121212),
      onBackground: Color(0xFFE0E0E0),
      surface: Color(0xFF1E1E1E),
      onSurface: Color(0xFFE0E0E0),
      error: Color(0xFFEF5350),
      onError: Color(0xFF212121),
    ),
    scaffoldBackgroundColor: Color(0xFF121212),
    appBarTheme: AppBarTheme(
      backgroundColor: Color(0xFF81C784),
      foregroundColor: Color(0xFF212121),
      elevation: 2,
    ),
    cardColor: Color(0xFF1E1E1E),
    buttonTheme: ButtonThemeData(
      buttonColor: Color(0xFF81C784),
      textTheme: ButtonTextTheme.primary,
    ),
    floatingActionButtonTheme: FloatingActionButtonThemeData(
      backgroundColor: Color(0xFF29B6F6),
      foregroundColor: Color(0xFF212121),
    ),
  );
}
