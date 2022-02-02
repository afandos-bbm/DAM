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
  DateTime selectedDate = DateTime.now();

  String dropdownValue = "Volar";
  int count = 0;

  var date;
  var pass;
  var nombre = "";
  var email = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Center(
            child: Padding(
          padding: EdgeInsets.all(15),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: <Widget>[
              Divider(),
              TextField(
                keyboardType: TextInputType.text,
                decoration: InputDecoration(
                  icon: const Icon(Icons.person),
                  suffixIcon: const Icon(Icons.person_add),
                  labelText: "Nombre",
                  helperText: "Solo es el nombre",
                  counterText: "Letras $count",
                  border: const OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(20)),
                      borderSide: BorderSide(width: 50)),
                ),
                onChanged: (value) {
                  setState(() {
                    nombre = value;
                    count = value.toString().length;
                  });
                },
              ),
              Divider(),
              TextField(
                keyboardType: TextInputType.emailAddress,
                decoration: const InputDecoration(
                  icon: Icon(Icons.mail),
                  suffixIcon: Icon(Icons.mark_email_read),
                  labelText: "Email",
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(20)),
                      borderSide: BorderSide(width: 50)),
                ),
                onChanged: (value) {
                  setState(() {
                    email = value;
                  });
                },
              ),
              Divider(),
              TextField(
                keyboardType: TextInputType.text,
                obscureText: true,
                decoration: const InputDecoration(
                  icon: Icon(Icons.lock),
                  suffixIcon: Icon(Icons.lock_clock),
                  labelText: "Password",
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(20)),
                      borderSide: BorderSide(width: 50)),
                ),
                onChanged: (value) => pass,
              ),
              Divider(),
              TextField(
                controller: TextEditingController(
                    text:
                        "${selectedDate.day}/${selectedDate.month}/${selectedDate.year}"),
                readOnly: true,
                decoration: const InputDecoration(
                  labelText: "Fecha de Nacimiento",
                  icon: Icon(Icons.calendar_today),
                  suffixIcon: Icon(Icons.calendar_today_outlined),
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.all(Radius.circular(20)),
                      borderSide: BorderSide(width: 50)),
                ),
                onTap: () {
                  _selectDate(context);
                },
                onChanged: (value) {
                  setState(() {
                    date = value;
                  });
                },
              ),
              Divider(),
              Row(
                children: [
                  const Icon(Icons.square_foot_sharp),
                  DropdownButton<String>(
                    items: <String>[
                      'Volar',
                      'Super Fuerza',
                      'Rayos X',
                      'Regeneración'
                    ].map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                    onChanged: (String? newValue) {
                      setState(() {
                        dropdownValue = newValue!;
                      });
                    },
                    value: dropdownValue,
                    icon: Icon(Icons.vertical_align_bottom),
                  ),
                ],
              ),
              Divider(),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Column(
                    children: [Text(" Nombre: $nombre"), Text("Email: $email")],
                  ),
                  Text("$dropdownValue")
                ],
              ),
            ],
          ),
        )));
  }

  _selectDate(BuildContext context) async {
    final DateTime? selected = await showDatePicker(
      context: context,
      initialDate: selectedDate,
      firstDate: DateTime(2010),
      lastDate: DateTime(2025),
    );
    if (selected != null && selected != selectedDate) {
      setState(() {
        selectedDate = selected;
      });
    }
  }
}
