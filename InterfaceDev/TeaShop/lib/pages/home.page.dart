import 'package:tea_shop/widgets/category/category_list.dart';
import 'package:tea_shop/widgets/product/product_list.dart';
import 'package:tea_shop/widgets/search_box.dart';
import 'package:flutter/material.dart';
import 'package:tea_shop/main.dart';
import 'package:tea_shop/themes/dark_theme.dart';
import 'package:tea_shop/themes/light_theme.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: MyApp.darkMode
          ? DarkTheme.backgroundColor
          : LightTheme.backgroundColor,
      body: SingleChildScrollView(
        child: Container(
            padding: EdgeInsets.all(20),
            width: double.infinity,
            color: MyApp.darkMode
                ? DarkTheme.backgroundColor
                : LightTheme.backgroundColor,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                SizedBox(
                  height: 40,
                ),
                SearchBox(),
                SizedBox(
                  height: 30,
                ),
                Text(
                  "Categories",
                  style: TextStyle(fontSize: 30),
                ),
                SizedBox(
                  height: 20,
                ),
                CategoryList(),
                SizedBox(
                  height: 40,
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: <Widget>[
                    Text(
                      "Cataloge",
                      style: TextStyle(fontSize: 30),
                    ),
                    // TextButton(
                    //   onPressed: () {},
                    //   child: Text("See all"),
                    // )
                  ],
                ),
                SizedBox(
                  height: 10,
                ),
                Container(
                  height: 320,
                  child: ProductList(),
                ),
              ],
            )),
      ),
    );
  }
}
