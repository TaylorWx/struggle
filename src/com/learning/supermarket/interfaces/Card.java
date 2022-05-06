package com.learning.supermarket.interfaces;

/*
VIP卡，打折卡，赠品卡等
 */
public interface Card {
    double processCardDiscount(double totalCost, double totalCostAfterDiscount, Customer customer,
                               ShoppingCart shoppingCart);
}
