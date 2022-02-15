import 'package:flutter/material.dart';
import 'package:shopfy/pages/tabs.page.dart';
import 'package:shopfy/themes/dark_theme.dart';
import 'package:shopfy/themes/light_theme.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  static bool _darkMode = true;
  static get darkMode => _darkMode;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'TeaShop',
      theme: _darkMode ? DarkTheme.getDarkTheme() : LightTheme.getLightTheme(),
      home: DefaultTabController(
        length: 3,
        child: TabsPage(),
      ),
    );
  }
}
