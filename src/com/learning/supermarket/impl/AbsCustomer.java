package com.learning.supermarket.impl;

import com.learning.supermarket.interfaces.Category;
import com.learning.supermarket.interfaces.Customer;
import com.learning.supermarket.interfaces.ShoppingCart;

import static com.learning.supermarket.utils.ShoppingUtils.getRandomCategory;

public abstract class AbsCustomer implements Customer {
    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    private int guangLeft = 0;
    private int guangCount = 0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(String custId, Category shouldBuy, int guangCount) {
        this.custId = custId;
        this.shouldBuy = shouldBuy;
        this.guangCount = guangCount;
    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    public AbsCustomer(String custId, Category shouldBuy) {
        this(custId, shouldBuy, DEFAULT_GUANG_COUNT);
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        // TODO 留给大家的思考题，买不起怎么办？
        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    /**
     * 先看必须买的，没有必须买的就随便看看
     *
     * @return 想要购买的商品种类
     */
    @Override
    public Category chooseCategory() {
        if (guangLeft + 1 >= guangCount) {
            return shouldBuy;
        } else {
            return getRandomCategory();
        }
    }


    @Override
    public double getMoneySpent() {
        return moneySpent;
    }


}
