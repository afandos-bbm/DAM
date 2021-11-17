class Triangulo {
  double _base = 0;
  double _altura = 0;
  double _area = 0;
  
  Triangulo(_base,_altura) {
    _area = _base * _altura;
  }

  @override
  String toString() => 'Base: $_base\n Altura: $_altura\n Area: $_area';
  
  double get base => _base;
  set base(double base) {
    if(base>=1)
      _base = base;
    else
      throw new Exception("Negative numbers not allowed.");
  }
  
  double get altura => _altura;
  set altura(double altura) {
        if(altura>=1)
      _altura = altura;
    else
      throw new Exception("Negative numbers not allowed.");
  }
  
  double get area => _area;
}