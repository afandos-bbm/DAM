import 'package:TeaShop/pages/tabs.page.dart';
import 'package:TeaShop/themes/dark_theme.dart';
import 'package:TeaShop/themes/light_theme.dart';
import 'package:flutter/material.dart';


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
