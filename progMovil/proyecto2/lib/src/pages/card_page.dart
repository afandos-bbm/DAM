import 'package:flutter/material.dart';

class CardPage extends StatefulWidget {
  CardPage({Key? key}) : super(key: key);

  @override
  _CardPageState createState() => _CardPageState();
}

class _CardPageState extends State<CardPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Card Page'),
      ),
      body: ListView(
        padding: const EdgeInsets.all(10.0),
        children: [
          _miCard1(),
          const SizedBox(
            height: 30.0,
          ),
          _miCardImage(),
        ],
      ),
    );
  }

  Widget _miCard1() {
    return Card(
      elevation: 3.0,
      shadowColor: Colors.blue,
      child: Column(children: [
        const ListTile(
          title: Text('Soy el título de la tarjeta'),
          subtitle: Text(
              'Esta es la descripción de la tarjeta que quiero utilizar para este ejemplo, para tener una idea de lo que quiereo que se vea por la pantalla'),
          leading: Icon(Icons.photo_album, color: Colors.blueAccent),
        ),
        Row(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            TextButton(onPressed: () {}, child: const Text('Cancelar')),
            TextButton(onPressed: () {}, child: const Text('Ok')),
          ],
        ),
      ]),
    );
  }

  Widget _miCardImage() {
    return Card(
      child: Column(
        children: [
          /*Image(
            image: NetworkImage(
                'http://static1.squarespace.com/static/57b6121b5016e1b55cf3835c/5bd0be1824a69482aaa24fa9/5ce1c644c61c1200017cc70d/1558302383051/?format=1500w'),
          ),*/
          const FadeInImage(
            placeholder: AssetImage('assets/jar-loading.gif'),
            image: NetworkImage(
                'http://static1.squarespace.com/static/57b6121b5016e1b55cf3835c/5bd0be1824a69482aaa24fa9/5ce1c644c61c1200017cc70d/1558302383051/?format=1500w'),
          ),
          Container(
            padding: const EdgeInsets.all(10.0),
            child: const Text('Welcome home!'),
          ),
        ],
      ),
    );
  }
}
