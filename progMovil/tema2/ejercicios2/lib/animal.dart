void sonidoAnimal(Animal animal) {
  animal.emitirSonido();
}

abstract class Animal {
  int? _patas;
  Animal.heredado(_patas);
  void emitirSonido();
}

class Rata extends Animal{
  bool? _cola;
  Rata(int patas, _cola) : super.heredado(patas);
  
  @override
  void emitirSonido() {
    print("ratatatata");
  }
}

class Conejo extends Animal{
  int? _orejas;
  Conejo(int patas, _orejas) : super.heredado(patas);
  
  @override
  void emitirSonido() {
    print("ninininini");
  }
}

class Pato extends Animal{
  Pato(int patas) : super.heredado(patas);
  
  @override
  void emitirSonido() {
    print("duckduck");
  }
}