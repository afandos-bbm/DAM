import 'package:flutter/material.dart';
import 'package:proyecto2/menu_provider.dart';
import 'package:proyecto2/string_to_icon.dart';

class HomePageJson extends StatelessWidget {
  //const HomePageTemp({Key? key}) : super(key: key);
  final opciones = ['Primera', 'Segunda', 'Tercera'];

  @override
  Widget build(BuildContext context) {
    /*return ListView(
      //child: Text('Home Temp'),
      //children: _crearItems(),
    );*/
    return Scaffold(
      appBar: AppBar(title: Text('Componentes Temp')),
      body: _miLista(),
    );
  }

  Widget _miLista() {
    return FutureBuilder(
        future: menuProvider.cargarData(),
        initialData: [],
        builder: (BuildContext context, AsyncSnapshot<List<dynamic>> snapshot) {
          return ListView(
            children: _listaItemsPrueba(snapshot.data!),
          );
        });
  }

  List<Widget> _listaItemsPrueba(List<dynamic> data) {
    final List<Widget> lista = [];
    data.forEach((opcion) {
      lista.add(ListTile(
          title: Text(opcion['texto']),
          leading: getIcon(opcion['icon']),
          trailing: const Icon(Icons.navigate_next, color: Colors.blue)));
      lista.add(const Divider());
    });

    return lista;
  }
}
