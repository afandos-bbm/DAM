import 'package:flutter/material.dart';
import 'package:shopfy/widgets/product/product_card.dart';

class ProductList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListView(
      scrollDirection: Axis.horizontal,
      children: <Widget>[
        ProductCard(
          image: "assets/images/lemon.jpg",
          name: "Lemon TEA",
          brand: "TeaShop",
          price: 232.2,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/white.jpg",
          name: "White TEA",
          brand: "TeaShop",
          price: 120.2,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/green.jpg",
          name: "Green TEA",
          brand: "TeaShop",
          price: 88.32,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/yellow.jpg",
          name: "Yellow TEA",
          brand: "TeaShop",
          price: 88.32,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/milk.jpg",
          name: "Milk TEA",
          brand: "TeaShop",
          price: 89.99,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/ginger.jpg",
          name: "Ginger TEA",
          brand: "TeaShop",
          price: 75.60,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/puerh.jpg",
          name: "Puerh TEA",
          brand: "TeaShop",
          price: 300.00,
          description: 'test',
        ),
        ProductCard(
          image: "assets/images/herbal.jpg",
          name: "Herbal TEA",
          brand: "TeaShop",
          price: 58.38,
          description: 'test',
        ),
      ],
    );
  }
}
