import 'package:dojo_flutter/cart_state.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class ShoppingBag extends StatelessWidget {
  final double width;
  final double itemsCount;

  const ShoppingBag({
    super.key,
    this.width = 40,
    required this.itemsCount,
  });

  @override
  Widget build(BuildContext context) {
    final cartState = context.watch<CartState>();
    return InkWell(
      onTap: () => Navigator.of(context).pushNamed('/cart'),
      child: SizedBox(
        width: width,
        child: LayoutBuilder(
          builder: (context, constraints) {
            double availableWidth = constraints.biggest.width;
            return Stack(
              fit: StackFit.passthrough,
              children: [
                Icon(
                  Icons.shopping_bag_outlined,
                  size: availableWidth / 1.2,
                  color: Colors.black54,
                ),
                Align(
                  alignment: const Alignment(1, -0.3),
                  child: CircleAvatar(
                    radius: availableWidth / 3.8,
                    backgroundColor: Colors.blue,
                    child: Text(
                      cartState.items.length.toString().replaceAll('.0', ''),
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: availableWidth / 3.5,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                )
              ],
            );
          },
        ),
      ),
    );
  }
}

