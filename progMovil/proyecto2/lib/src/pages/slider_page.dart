import 'package:flutter/material.dart';

class SlidePage extends StatefulWidget {
  const SlidePage({Key? key}) : super(key: key);

  @override
  _SlidePageState createState() => _SlidePageState();
}

class _SlidePageState extends State<SlidePage> {
  double _value = 0;
  bool checkBoxValue = false;
  bool checkSwitchValue = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Slider'),
      ),
      body: Column(
        children: [
          Slider(
            value: _value,
            activeColor: Colors.grey,
            inactiveColor: Colors.blue,
            min: 0,
            max: 100,
            label: _value.round().toString(),
            onChanged: (double value) {
              setState(
                () {
                  _value = value;
                },
              );
            },
          ),
          CheckboxListTile(
            title: const Text('Bloquear Slider'),
            value: checkBoxValue,
            onChanged: (bool? newValue) {
              setState(
                () {
                  checkBoxValue = newValue!;
                },
              );
            },
          ),
          SwitchListTile(
            title: const Text("Bloquear Slider"),
            value: checkSwitchValue,
            onChanged: (bool? newValue) {
              setState(
                () {
                  checkSwitchValue = newValue!;
                },
              );
            },
          ),
          Image(
            width: _value,
            height: _value,
            image: NetworkImage(
                "http://pngimg.com/uploads/batman/batman_PNG52.png"),
          ),
        ],
      ),
    );
  }
}
