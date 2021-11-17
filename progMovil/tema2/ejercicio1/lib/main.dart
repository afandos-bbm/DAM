//Actividad 1
import 'package:flutter/foundation.dart';

class Profesor {
  String? nombre;
  String? modulo;

  Profesor({required this.nombre, required this.modulo});

  @override
  String toString() {
    return "El profesor " + nombre! + "imparte " + modulo!;
  }
}

//Actividad 2
class Persona {
  esAdulto(int edad) => (edad >= 18) ? true : false;
}

//Actividad 3 y 4
class Punto {
  int x = 0;
  int y = 0;

  Punto({required this.x, required this.y});
  Punto.centerLocation({this.x = 0, this.y = 0});
  Punto.setXAlignment({required this.x, this.y = 0});
}

//Ejercicio 5
class Rectangulo {
  int base = 0;
  int altura = 0;
  int area = 0;
  String? tipo;

  Rectangulo(this.tipo, {required this.base, required this.altura}) {
    area = altura * base;
  }
  
  Rectangulo.cuadrado(this.tipo, {required int lado}) {
    base = lado;
    altura = lado;
    area = lado * lado;
  }

  factory Rectangulo.factory(String tipo, {required int base, required int altura}) {
    if (base == altura) {
      return Rectangulo.cuadrado(tipo, lado: 0);
    }
    return Rectangulo(tipo, base: 0, altura: 0);
  }
}
