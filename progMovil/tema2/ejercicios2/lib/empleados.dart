abstract class Empleado {
  int? id;
  String nombre = "";
  int salario = 0;

  Empleado({required this.id, required this.nombre, required this.salario});
  calcularSalario();
}

abstract class Uniforme {
  String uniforme = "";

  Uniforme({required this.uniforme});
}

class Chofer implements Empleado, Uniforme {
  @override
  int? id;

  @override
  String nombre = "";

  @override
  int salario = 0;

  @override
  String uniforme = "Uniforme de Chofer";

  @override
  calcularSalario() {
    // TODO: implement calcularSalario
    throw UnimplementedError();
  }
}
