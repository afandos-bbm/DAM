import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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

  void _incrementCounter() {
    setState(() {
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text(
                'Presiona el botón para mostrar el AlertDialog',
              ),
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () => showDialog<void>(
            context: context,
            builder: (_) => _buildAlertDialog(context),
          ),
          child: const Icon(Icons.description),
        ));
  }

  Widget _buildAlertDialog(BuildContext context) {
    return AlertDialog(
      title: Text('Titulo'),
      content: Column(
        children: <Widget>[
          Text("Este es el contenido de la caja de la alerta."),
          Icon(Icons.whatshot_rounded)
        ],
        mainAxisSize: MainAxisSize.min,
      ),
      actions: <Widget>[
        TextButton(
            child: Text("Ok"),
            onPressed: () {
              Navigator.of(context).pop();
            }),
        TextButton(
            child: Text("Cancelar"),
            onPressed: () {
              Navigator.of(context).pop();
            }),
      ],
    );
  }
}
