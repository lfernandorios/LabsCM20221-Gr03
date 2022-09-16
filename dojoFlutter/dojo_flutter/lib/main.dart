// ignore_for_file: prefer_const_literals_to_create_immutables

import 'package:dojo_flutter/cart_screen.dart';
import 'package:dojo_flutter/cart_state.dart';
import 'package:dojo_flutter/product.model.dart';
import 'package:dojo_flutter/product_card.dart';
import 'package:dojo_flutter/shopping_bag.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => CartState(),
        child: MaterialApp(
          title: 'Flutter Demo',
          theme: ThemeData(
            primarySwatch: Colors.blue,
          ),

          routes: {
            '/': (_) => CatalogScreen(),
            '/cart': (_) => CartScreen(),
          },

        ),
    );
  }
}

class CatalogScreen extends StatelessWidget {
  const CatalogScreen({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        title: Text('Catalog',
          style: TextStyle(color: Colors.black54),
        ),
        actions: [
          ShoppingBag(itemsCount: 4)
        ],
      ),
      body: GridView.builder(
        itemCount: products.length,
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2, childAspectRatio: 3/4),
        itemBuilder: (context, index) => ProductCard(
          product: products[index],
        ),
      ),
    );
  }
}

List<Product> products = [
  Product(
    name: 'Sillón naranja',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as2.ftcdn.net/v2/jpg/03/03/92/01/1000_F_303920112_Qg6w8w2Brjnqex7AGJpsZlaI8IWa1lzH.jpg',
    price: 250000,
    rating: 4.3,
  ),
  Product(
    name: 'Silla verde clásica',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as1.ftcdn.net/v2/jpg/02/98/83/02/1000_F_298830220_lHqS0oOJMOZ8F8ld7z7ZeAdZDv1Gt02U.jpg',
    price: 300000,
    rating: 4.7,
  ),
  Product(
    name: 'Sillón gris concepto circular',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as1.ftcdn.net/v2/jpg/04/23/22/30/1000_F_423223088_K7LtjyVB6Ggvj2eXCYgH4wifwr567hjI.jpg',
    price: 320000,
    rating: 4.2,
  ),
  Product(
    name: 'Silla mimbre café',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as1.ftcdn.net/v2/jpg/04/22/49/48/1000_F_422494801_4ceq4TyK4YoS44vyinUr6r5ZGP0eFD59.jpg',
    price: 245000,
    rating: 4.4,
  ),
  Product(
    name: 'Silla mimbre café sencilla',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as1.ftcdn.net/v2/jpg/04/21/00/38/1000_F_421003867_svtctEEgBbwYK4K6ZqAvXnVMNC7Fw4ye.jpg',
    price: 230000,
    rating: 4.3,
  ),
  Product(
    name: 'Sillón roja',
    description: 'Lorem Ipsum Dorma Torda',
    imageUrl:
    'https://as1.ftcdn.net/v2/jpg/02/96/08/60/1000_F_296086068_upDivS8gcX1QPPQ3tevdWQd8aHPdTZPE.jpg',
    price: 370000,
    rating: 4.3,
  ),
];




