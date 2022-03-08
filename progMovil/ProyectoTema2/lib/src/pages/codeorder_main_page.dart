import 'package:flutter/material.dart';

class HomePageCode extends StatefulWidget {
  const HomePageCode({Key? key}) : super(key: key);

  @override
  State<HomePageCode> createState() => HomePageCodeState();
}

class HomePageCodeState extends State<HomePageCode> {
  final opciones = [
    "1",
    "2",
    "3",
    "4",
    "5",
  ];

  @override
  Widget build(BuildContext context) {
    Size size = MediaQuery.of(context).size;
    return Scaffold(
      appBar: AppBar(
        title: const Text('Componentes'),
        centerTitle: true,
      ),
      body: Column(children: [
        Expanded(
          child: ListView(
            children: _crearItemCorto(),
          ),
        )
      ]),
      floatingActionButton: boton(),
    );
  }

  List<Widget> _crearItemCorto() {
    var widget = opciones
        .map(
          (e) => Column(
            children: [
              ListTile(
                title: Text(e),
                leading: const CircleAvatar(
                  backgroundColor: Colors.black,
                  child: Text("Test"),
                ),
                trailing: const Icon(Icons.skip_next),
                onTap: () {},
              ),
              const Divider(
                color: Colors.blue,
                indent: 10,
                endIndent: 10,
              ),
            ],
          ),
        )
        .toList();

    return widget;
  }

  Widget boton() {
    return FloatingActionButton(
        child: const Icon(Icons.add),
        onPressed: () {
          setState(
            () {
              opciones.add("Test");
            },
          );
        });
  }
}
