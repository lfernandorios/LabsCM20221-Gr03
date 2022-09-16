import 'package:dojo_flutter/main.dart';
import 'package:dojo_flutter/product.model.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'cart_state.dart';

class CartScreen extends StatelessWidget {
  const CartScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final cartState = context.watch<CartState>();
    final items = cartState.items;

    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        leading: const BackButton(color: Colors.black54),
        backgroundColor: Colors.white,
        elevation: 0,
        title: const Text(
          'Cart',
          style: TextStyle(color: Colors.black54),
        ),
      ),
      body: Column(
        children:
        List.generate(
            items.length, (index) => CartItem(product: items[index])),
      ),
    );
  }
}

class CartItem extends StatelessWidget {
  final Product product;

  const CartItem({
    super.key,
    required this.product,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      height: 80,
      child: Row(
        children: [
          InkWell(
            child: const Icon(
              Icons.delete,
              color: Colors.black54,
            ),
            onTap: () {
              final cartState = context.read<CartState>();
              cartState.deleteProduct(product);
            },
          ),
          Image.network(
            product.imageUrl,
          ),
          Flexible(
            flex: 1,
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  SizedBox(
                    width: 130,
                    child: Text(
                      product.name,
                      style: const TextStyle(
                        fontSize: 15,
                        fontWeight: FontWeight.bold,
                        color: Colors.black87,
                      ),
                    ),
                  ),
                  const SizedBox(height: 5),
                  Text(
                    product.price.toString(),
                    style: const TextStyle(
                      fontSize: 15,
                      fontWeight: FontWeight.w500,
                      color: Colors.black54,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}
