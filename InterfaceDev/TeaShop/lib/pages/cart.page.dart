import 'package:flutter/material.dart';
import 'package:tea_shop/main.dart';
import 'package:tea_shop/themes/dark_theme.dart';
import 'package:tea_shop/themes/light_theme.dart';

class CartPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: <Widget>[
          Expanded(
            child: Container(
              child: productList(),
            ),
          ),
          Container(
            height: 80,
            color: Colors.black12,
            padding: EdgeInsets.only(top: 20, left: 10, right: 10),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                      Text("TOTAL"),
                      SizedBox(height: 5),
                      Text(
                        "\$ 40,00",
                        style: TextStyle(
                            color: Colors.blue,
                            fontWeight: FontWeight.bold,
                            fontSize: 20),
                      )
                    ]),
                ElevatedButton(
                  onPressed: () {},
                  style: ButtonStyle(
                      backgroundColor: MaterialStateProperty.all(MyApp.darkMode
                          ? DarkTheme.primaryColor
                          : LightTheme.primaryColor)),
                  child: Text(
                    "Checkout",
                    style: TextStyle(color: Colors.white),
                  ),
                )
              ],
            ),
          ),
        ],
      ),
    );
  }
}

Widget productList() {
  return ListView(
    children: <Widget>[
      productItem(),
      productItem(),
    ],
  );
}

Widget productItem() {
  return Container(
    height: 120,
    margin: EdgeInsets.all(5),
    child: Row(
      children: <Widget>[
        Container(
            width: 100,
            height: 100,
            margin: EdgeInsets.all(10),
            child:
                Image.asset("assets/images/ginger.jpg", fit: BoxFit.fitWidth)),
        Padding(
          padding: const EdgeInsets.only(top: 20, left: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: <Widget>[
              Text("Ginger TEA"),
              Text(
                "\$ 20,00",
                style: TextStyle(color: Colors.blue),
              ),
              SizedBox(
                height: 10,
              ),
              Container(
                height: 39,
                width: 120,
                decoration: BoxDecoration(
                    color: Colors.black12,
                    borderRadius: BorderRadius.all(Radius.circular(5))),
                child: Row(
                  children: <Widget>[
                    Container(
                        width: 40,
                        alignment: Alignment.center,
                        child: TextButton(
                          child: Text("+"),
                          onPressed: () {},
                        )),
                    Container(
                        width: 40,
                        alignment: Alignment.center,
                        child: Text("1")),
                    Container(
                        width: 40,
                        alignment: Alignment.center,
                        child: TextButton(
                          child: Text("-"),
                          onPressed: () {},
                        )),
                  ],
                ),
              )
            ],
          ),
        )
      ],
    ),
  );
}
