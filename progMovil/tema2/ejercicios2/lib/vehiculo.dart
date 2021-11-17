abstract class Vehiculo {}

mixin Terrestre {
  conducir();
}

mixin Acuatico {
  navegar();
}

mixin Aereo {
  volar();
}

class Automovil extends Vehiculo with Terrestre {
  @override
  conducir() {
    // TODO: implement conducir
    throw UnimplementedError();
  }
}

class Avion extends Vehiculo with Aereo {
  @override
  volar() {
    // TODO: implement volar
    throw UnimplementedError();
  }
}

class Barco extends Vehiculo with Acuatico {
  @override
  navegar() {
    // TODO: implement navegar
    throw UnimplementedError();
  }
}

class AvionetaAcuatica extends Vehiculo with Aereo,Acuatico {
  @override
  navegar() {
    // TODO: implement navegar
    throw UnimplementedError();
  }

  @override
  volar() {
    // TODO: implement volar
    throw UnimplementedError();
  }
}