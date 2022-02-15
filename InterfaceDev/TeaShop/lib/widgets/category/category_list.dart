import 'package:TeaShop/widgets/category/category_item.dart';
import 'package:flutter/material.dart';

class CategoryList extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      height: 90,
      child: ListView(
        scrollDirection: Axis.horizontal,
        children: <Widget>[
          CategoryItem(
            image: Image.asset("assets/images/1.png"),
          ),
          CategoryItem(
            image: Image.asset("assets/images/2.png"),
          ),
          CategoryItem(
            image: Image.asset("assets/images/3.png"),
          ),
          CategoryItem(
            image: Image.asset("assets/images/4.png"),
          ),
        ],
      ),
    );
  }
}
