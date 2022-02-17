import 'package:tea_shop/main.dart';
import 'package:tea_shop/themes/dark_theme.dart';
import 'package:tea_shop/themes/light_theme.dart';
import 'package:flutter/material.dart';

class SearchBox extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.only(left: 20),
      width: double.infinity,
      decoration: BoxDecoration(
        color:
            MyApp.darkMode ? LightTheme.backgroundColor : DarkTheme.lightColor,
        borderRadius: BorderRadius.all(Radius.circular(30)),
      ),
      height: 60,
      child: Row(
        children: <Widget>[
          Icon(Icons.search,
              color: MyApp.darkMode
                  ? DarkTheme.primaryColor
                  : LightTheme.primaryColor),
          Container(
            width: 276,
            padding: EdgeInsets.only(left: 10),
            child: TextFormField(
              keyboardType: TextInputType.text,
              decoration: InputDecoration(
                border: InputBorder.none,
              ),
              style: TextStyle(
                  fontSize: 20,
                  color: MyApp.darkMode
                      ? DarkTheme.primaryColor
                      : LightTheme.primaryColor),
            ),
          )
        ],
      ),
    );
  }
}
