import 'package:flutter/material.dart';

class InputPage extends StatefulWidget {
  InputPage({Key? key}) : super(key: key);

  @override
  _InputPageState createState() => _InputPageState();
}

class _InputPageState extends State<InputPage> {
  String _name = '', _email = '';
  final items = ['Volar', 'Rayos X', 'Super aliento', 'Super Fuerza'];
  String selectedValue = 'Volar';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Inputs de texto"),
      ),
      body: Column(
        children: [
          const SizedBox(
            height: 10,
          ),
          SizedBox(
            width: 380,
            height: 70,
            child: TextField(
              decoration: InputDecoration(
                isDense: true,
                suffixIcon: const Icon(Icons.accessibility),
                icon: const Icon(Icons.account_circle),
                enabledBorder: const OutlineInputBorder(
                  borderRadius: BorderRadius.all(
                    Radius.circular(20.0),
                  ),
                ),
                hintText: 'Nombre',
                helperText: 'Sólo es el nombre',
                counterText: 'Letras: ${_name.length.toString()}',
                counterStyle: const TextStyle(
                  fontWeight: FontWeight.bold,
                ),
              ),
              onChanged: (value) {
                setState(() {
                  _name = value;
                });
              },
            ),
          ),
          const Divider(),
          SizedBox(
            width: 380,
            height: 70,
            child: TextField(
              keyboardType: TextInputType.emailAddress,
              decoration: const InputDecoration(
                isDense: true,
                icon: Icon(Icons.email),
                suffixIcon: Icon(Icons.alternate_email_outlined),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.all(Radius.circular(20.0)),
                ),
                hintText: 'Email',
              ),
              onChanged: (value) {
                setState(
                  () {
                    _email = value;
                  },
                );
              },
            ),
          ),
          const Divider(),
          const SizedBox(
            width: 380,
            height: 70,
            child: TextField(
              obscureText: true,
              autofocus: true,
              decoration: InputDecoration(
                isDense: true,
                icon: Icon(Icons.lock),
                suffixIcon: Icon(Icons.lock_open_outlined),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.all(Radius.circular(20.0)),
                ),
                hintText: 'Password',
              ),
            ),
          ),
          const Divider(),
          const SizedBox(
            width: 380,
            height: 70,
            child: TextField(
              keyboardType: TextInputType.datetime,
              decoration: InputDecoration(
                isDense: true,
                icon: Icon(Icons.calendar_today),
                suffixIcon: Icon(Icons.perm_contact_cal),
                enabledBorder: OutlineInputBorder(
                  borderRadius: BorderRadius.all(Radius.circular(20.0)),
                ),
                hintText: 'Fecha de nacimiento',
              ),
            ),
          ),
          const Divider(),
          Row(
            children: [
              const Icon(Icons.select_all_rounded),
              Container(
                padding:
                    const EdgeInsets.symmetric(horizontal: 10, vertical: 5),
                decoration:
                    BoxDecoration(borderRadius: BorderRadius.circular(10)),

                // dropdown below..
                child: DropdownButton<String>(
                  value: selectedValue,
                  onChanged: (String? newValue) =>
                      setState(() => selectedValue = newValue!),
                  items: items
                      .map<DropdownMenuItem<String>>(
                        (String value) => DropdownMenuItem<String>(
                          value: value,
                          child: Text(value),
                        ),
                      )
                      .toList(),

                  // add extra sugar..
                  icon: const Icon(Icons.arrow_drop_down),
                  iconSize: 42,
                ),
              ),
            ],
          ),
          const Divider(),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Column(
                children: [
                  Text("Tu nombre es: $_name"),
                  Text("Email: $_email"),
                ],
              ),
              Text(
                selectedValue,
                style: const TextStyle(
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
