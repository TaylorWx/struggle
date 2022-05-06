package com.learning.supermarket;

import com.learning.supermarket.impl.SimpleShopman;
import com.learning.supermarket.interfaces.Customer;
import com.learning.supermarket.interfaces.Shopman;
import com.learning.supermarket.interfaces.SuperMarket;

import static com.learning.supermarket.utils.ShoppingUtils.*;

public class ShoppingAppMain {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();

        Shopman shopman = new SimpleShopman(superMarket);
        boolean open = true;

        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = !input().next().trim().equalsIgnoreCase("no");
        }

        superMarket.dailyReport();
    }
}

class ShoppingTask {

    private Shopman shopman;

    public ShoppingTask(Shopman shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
        Customer customer = createCustomer(true);

        shopman.serveCustomer(customer);

    }

}