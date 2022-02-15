import 'package:flutter/material.dart';
import 'package:proyecto2/src/pages/alert_page.dart';
import 'package:proyecto2/src/pages/card_page.dart';
import 'package:proyecto2/src/pages/codeorder_main_page.dart';
import 'package:proyecto2/src/pages/home_page.dart';
import 'package:proyecto2/src/pages/home_page_json.dart';
import 'package:proyecto2/src/pages/input_page.dart';
import 'package:proyecto2/src/pages/slider_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Proyecto 2',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Conponentes'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return MaterialApp(
      title: 'Proyecto 2',
      debugShowCheckedModeBanner: false,
      useInheritedMediaQuery: true,
      initialRoute: '/',
      routes: {
        '/': (context) => HomePage(),
        '/json': (context) => HomePageJson(),
        '/code': (context) => const HomePageCode(),
        '/card': (context) => CardPage(),
        '/alert': (context) => const AlertPage(),
        '/slider': (context) => const SlidePage(),
        '/inputs': (context) => InputPage(),
      },
    );
  }
}
