import 'dart:convert';
import 'package:flutter/services.dart' show rootBundle;

class _MenuProvider {
  List<dynamic> opciones = [];

  _MenuProvider() {
    //cargarData();
  }

  Future<List<dynamic>> cargarData() async {
    Map dataMap = json.decode(await rootBundle.loadString('data/menu.json'));
    //print(dataMap['menu']);
    opciones = dataMap['menu'];

    return opciones;
  }
}

final menuProvider = _MenuProvider();
