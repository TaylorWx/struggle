package com.learning.supermarket.interfaces;

// >> TODO 某一个中类的商品，满多少减多少
// >> TODO 某一个中类的商品，第二件半价
public interface DiscountCategory {
    double discount(ShoppingCart shoppingCart);
}
