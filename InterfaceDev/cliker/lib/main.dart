import 'dart:convert';
import 'dart:io';
import 'dart:math';

import 'package:cliker/xml_exporter.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:permission_handler/permission_handler.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Cookie Cliker by Alejandrofan2',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.lightBlue,
      ),
      home: const MyHomePage(title: 'Cookie Cliker'),
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
  int score = 0;
  double cookieSize = 150;
  double overKill = 1.0;
  int bonus3 = 0;
  int bonus2 = 0;
  int totalCliks = 0;
  ValueNotifier<bool> checkBonus2 = ValueNotifier<bool>(false);
  ValueNotifier<bool> checkBonus3 = ValueNotifier<bool>(false);
  bool lastCheck2 = false;
  bool lastCheck3 = false;
  List<String> clickCue = <String>[];

  cookieClicked() {
    animation();
    setState(() {
      clickCue.add("click");
      totalCliks++;
    });

    if (clickCue.isNotEmpty && clickCue.length - 1 < 10) {
      setState(() {
        score++;
        overKill = 0.0;
        loseBonus(2);
        if (checkBonus2.value) checkBonus2.value = false;
        if (checkBonus3.value) checkBonus3.value = false;
      });
    } else if (clickCue.length - 1 >= 10 && clickCue.length - 1 < 20) {
      setState(() {
        score += 2;
        overKill = 0.5;
        loseBonus(3);
        if (!checkBonus2.value) checkBonus2.value = true;
        if (checkBonus3.value) checkBonus3.value = false;
      });
    } else if (clickCue.length - 1 >= 20) {
      setState(() {
        score += 4;
        overKill = 1.0;
        loseBonus(4);
        if (checkBonus2.value) checkBonus2.value = false;
        if (!checkBonus3.value) checkBonus3.value = true;
      });
    }

    if (!lastCheck2 && checkBonus2.value) {
      bonus2++;
      lastCheck2 = true;
    }
    if (lastCheck2 && !checkBonus2.value) {
      lastCheck2 = false;
    }
    if (!lastCheck3 && checkBonus3.value) {
      bonus3++;
      lastCheck3 = true;
    }
    if (lastCheck3 && !checkBonus3.value) {
      lastCheck3 = false;
    }
  }

  Future<void> animation() async {
    setState(() {
      cookieSize = 170;
    });
    await Future.delayed(const Duration(milliseconds: 100), () {});
    setState(() {
      cookieSize = 150;
    });
  }

  void loseBonus(int lose) {
    if (Random().nextInt(1000) < 850) {
      clickCue.removeRange(0, Random().nextInt(lose));
    }
  }

  void restartBonus(bool focus) {
    setState(() {
      if (!focus) {
        clickCue.removeRange(0, clickCue.length);
      }
    });
  }

  void _showSettings(BuildContext context) {
    showModalBottomSheet(
        context: context,
        builder: (context) {
          return Column(
            mainAxisSize: MainAxisSize.min,
            children: <Widget>[
              ListTile(
                leading: const Icon(Icons.link),
                title: const Text('Get game data'),
                onTap: () async {
                  Map<String, int> data = Map.fromIterables(
                      ["Score", "Total_Clicks", "Bonus_x2", "Bonus_x4"],
                      [score, totalCliks, bonus2, bonus3]);
                  if ((await XmlExporter().save(context, data))) {
                    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                      content: Text("Error saving game data"),
                    ));
                  }
                  Navigator.pop(context);
                },
              ),
              ListTile(
                leading: const Icon(Icons.data_saver_on_outlined),
                title: const Text('Load Data'),
                onTap: () async {
                  int status = await loadData();
                  if (status == 1) {
                    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                        content: Text("Permisos del Sistema denagados.")));
                  } else if (status == 2) {
                    ScaffoldMessenger.of(context).showSnackBar(const SnackBar(
                        content: Text("No se encuentra el archivo de datos.")));
                  }
                  Navigator.of(context).pop();
                },
              ),
              ListTile(
                leading: const Icon(Icons.exit_to_app),
                title: const Text('Exit'),
                onTap: () {
                  exit(0);
                },
              ),
            ],
          );
        });
  }

  Future<int> loadData() async {
    var status = await Permission.storage.status;
    if (!status.isGranted) {
      await Permission.storage.request();
    }
    if (await (await XmlExporter().localFile).exists()) {
      try {
        Map<String, int> data =
            jsonDecode((await XmlExporter().localFile).readAsStringSync());
        print(data.toString());
        score = (data["score"])!;
        totalCliks = (data["totalCliks"])!;
        bonus2 = (data["bonus2"])!;
        bonus3 = (data["bonus3"])!;
        return 0;
      } catch (e) {
        return 1;
      }
    }
    return 2;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Stack(
          fit: StackFit.expand,
          children: <Widget>[
            Container(
              decoration: const BoxDecoration(
                image: DecorationImage(
                  image: AssetImage("data/back.png"),
                  fit: BoxFit.cover,
                ),
              ),
            ),
            Positioned.fill(
                bottom: 100,
                child: Align(
                    alignment: AlignmentDirectional.bottomCenter,
                    child: Text(
                      "Score: " + score.toString(),
                      style: const TextStyle(fontSize: 50),
                    ))),
            Positioned.fill(
                child: Align(
                    alignment: AlignmentDirectional.center,
                    child: Opacity(
                        opacity: overKill,
                        child: Image.asset(
                          "data/overkill.gif",
                          height: 500.0,
                        )))),
            Positioned.fill(
                left: 10,
                child: Align(
                    alignment: AlignmentDirectional.bottomStart,
                    child: ValueListenableBuilder<bool>(
                      valueListenable: checkBonus2,
                      builder: (context, bool value, Widget? child) {
                        return Text(
                          value ? "X2" : "",
                          style: const TextStyle(fontSize: 30),
                        );
                      },
                    ))),
            Positioned.fill(
                left: 10,
                child: Align(
                    alignment: AlignmentDirectional.bottomStart,
                    child: ValueListenableBuilder<bool>(
                      valueListenable: checkBonus3,
                      builder: (context, bool value, Widget? child) {
                        return Text(
                          value ? "X4" : "",
                          style: const TextStyle(fontSize: 30),
                        );
                      },
                    ))),
            Center(
              child: CircleAvatar(
                  maxRadius: cookieSize,
                  backgroundImage: const AssetImage('data/cookie.png'),
                  backgroundColor: Colors.transparent,
                  child: InkWell(
                    onTap: () => cookieClicked(),
                  )),
            ),
            Positioned.fill(
              top: 70,
              right: 20,
              child: Align(
                  alignment: AlignmentDirectional.topEnd,
                  child: InkWell(
                      onTap: () => _showSettings(context),
                      child: Image.asset(
                        'data/settings.png',
                        height: 70,
                      ))),
            ),
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
