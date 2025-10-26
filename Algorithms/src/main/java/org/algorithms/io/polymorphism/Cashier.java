package org.algorithms.io.polymorphism;

public class Cashier extends Person {
    private double sales;

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getSales() {
        return sales;
    }
}
