import 'package:dojo_flutter/product.model.dart';
import 'package:flutter/material.dart';

class CartState with ChangeNotifier {
  List<Product> items = [];

  addProduct(Product product) {
    if (items.contains(product)) {
      return;
    }
    items.add(product);
    notifyListeners();
  }

  deleteProduct(Product product) {
    items.remove(product);
    notifyListeners();
  }
}
