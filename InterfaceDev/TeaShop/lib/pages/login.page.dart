import 'package:tea_shop/pages/signup.page.dart';
import 'package:tea_shop/widgets/social_button.dart';
import 'package:flutter/material.dart';
import 'package:tea_shop/main.dart';
import 'package:tea_shop/themes/dark_theme.dart';
import 'package:tea_shop/themes/light_theme.dart';

import 'home.page.dart';

class LoginPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: MyApp.darkMode
            ? DarkTheme.backgroundColor
            : LightTheme.backgroundColor,
        body: SingleChildScrollView(
          child: Container(
            color: MyApp.darkMode
                ? DarkTheme.backgroundColor
                : LightTheme.backgroundColor,
            padding: EdgeInsets.only(
              top: 80,
              left: 20,
              right: 20,
              bottom: 40,
            ),
            child: Column(
              children: <Widget>[
                Container(
                  decoration: BoxDecoration(
                      color: MyApp.darkMode
                          ? DarkTheme.backgroundColor
                          : LightTheme.backgroundColor,
                      boxShadow: [
                        BoxShadow(
                            color: MyApp.darkMode
                                ? DarkTheme.lightColor
                                : LightTheme.lightColor,
                            offset: Offset(0, 0),
                            blurRadius: 4,
                            spreadRadius: 2)
                      ]),
                  height: 400,
                  padding: EdgeInsets.only(
                    top: 38,
                    left: 20,
                    right: 20,
                    bottom: 20,
                  ),
                  width: MediaQuery.of(context).size.width,
                  child: Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: <Widget>[
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: <Widget>[
                            Column(
                              children: <Widget>[
                                Text(
                                  "Welcome,",
                                  style: TextStyle(
                                      fontSize: 30.0,
                                      fontWeight: FontWeight.w500),
                                ),
                                Padding(
                                  padding: EdgeInsets.only(
                                    left: 10,
                                  ),
                                  child: Text(
                                    "Sigin in to continue",
                                    style: TextStyle(
                                      fontSize: 13.0,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                            TextButton(
                              child: Text("Sign Up"),
                              onPressed: () {
                                Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                        builder: (context) => SignupPage()));
                              },
                            )
                          ],
                        ),
                        SizedBox(
                          height: 40,
                        ),
                        TextFormField(
                          autofocus: true,
                          keyboardType: TextInputType.emailAddress,
                          decoration: InputDecoration(
                              labelText: "Email",
                              labelStyle: TextStyle(
                                color: MyApp.darkMode
                                    ? DarkTheme.lightColor
                                    : LightTheme.lightColor,
                                fontWeight: FontWeight.w400,
                                fontSize: 16,
                              )),
                        ),
                        SizedBox(
                          height: 10,
                        ),
                        TextFormField(
                          autofocus: true,
                          obscureText: true,
                          keyboardType: TextInputType.text,
                          decoration: InputDecoration(
                              labelText: "Password",
                              labelStyle: TextStyle(
                                color: MyApp.darkMode
                                    ? DarkTheme.lightColor
                                    : LightTheme.lightColor,
                                fontWeight: FontWeight.w400,
                                fontSize: 16,
                              )),
                        ),
                        Container(
                            alignment: Alignment.centerRight,
                            child: TextButton(
                              child: Text("Forgot your password?"),
                              onPressed: () {},
                            )),
                        SizedBox(
                          height: 10,
                        ),
                        Container(
                            decoration: BoxDecoration(
                                color: MyApp.darkMode
                                    ? DarkTheme.primaryColor
                                    : LightTheme.primaryColor,
                                borderRadius:
                                    BorderRadius.all(Radius.circular(4))),
                            width: MediaQuery.of(context).size.width,
                            child: TextButton(
                              child: Text(
                                "OK",
                                style: TextStyle(color: Colors.white),
                              ),
                              onPressed: () {
                                Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                        builder: (BuildContext context) =>
                                            HomePage()));
                              },
                            ))
                      ]),
                ),
                Container(
                  padding: EdgeInsets.only(top: 20, bottom: 15),
                  child: Text(
                    "- OR -",
                    style: TextStyle(fontSize: 14, fontWeight: FontWeight.w300),
                  ),
                ),
                SocialButton(
                  text: "Login In with Facebook",
                  image: Image.asset("assets/images/facebook.png"),
                  heightImage: 24,
                  onPress: () {},
                ),
                SizedBox(
                  height: 20,
                ),
                SocialButton(
                  text: "Login In with Google",
                  image: Image.asset("assets/images/google.png"),
                  heightImage: 24,
                  onPress: () {},
                ),
              ],
            ),
          ),
        ));
  }
}
