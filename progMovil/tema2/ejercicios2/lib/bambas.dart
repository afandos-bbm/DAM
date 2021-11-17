class Bamba {
  String? material;
  double? talla;
  String? color;
  String? colorCordones;

  Bamba(
      {required this.material,
      required this.talla,
      required this.color,
      required this.colorCordones});

  datos() =>
      'Bamba ->\nMaterial: $material\nTalla: $talla\nColor: $color\nColorCordones: $colorCordones';
}

class BambaJuvenil extends Bamba {
  String estampado = "";

  BambaJuvenil(
      {required material,
      required talla,
      required color,
      required colorCordones,
      required estampado})
      : super(
            material: material,
            talla: talla,
            color: color,
            colorCordones: colorCordones);

  @override
  datos() =>
      'Bamba ->\nMaterial: $material\nTalla: $talla\nColor: $color\nColorCordones: $colorCordones\n estampado: $estampado';
}

class Bambainfantil extends Bamba {
  String disenoPj = "";

  Bambainfantil(
      {required material,
      required talla,
      required color,
      required colorCordones,
      required disenoPj})
      : super(
            material: material,
            talla: talla,
            color: color,
            colorCordones: colorCordones);

  @override
  datos() =>
      'Bamba ->\nMaterial: $material\nTalla: $talla\nColor: $color\nColorCordones: $colorCordones\n disenoPj: $disenoPj';
}
