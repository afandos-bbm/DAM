import 'package:flutter/material.dart';

class AlertPage extends StatelessWidget {
  const AlertPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Alarm'),
        centerTitle: true,
      ),
      body: Center(
        child: TextButton(
          onPressed: () => showDialog(
              context: context,
              builder: (BuildContext context) => AlertDialog(
                    title: const Text("hola"),
                    actions: <Widget>[
                      TextButton(
                        onPressed: () => Navigator.pop(context, '/'),
                        child: const Text("Cancel "),
                      ),
                      TextButton(
                        onPressed: () => Navigator.pushNamed(context, '/'),
                        child: const Text("Ok"),
                      ),
                    ],
                  )),
          child: const Text("Alarm dialog"),
        ),
      ),
    );
  }
}
