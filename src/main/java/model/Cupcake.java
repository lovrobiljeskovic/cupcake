/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lovro
 */
public class Cupcake {
    private Topping topping;
    private Bottom bottom;
    private double price;
    private int quantity;

    public Cupcake(Topping topping, Bottom bottom) {
        this.topping = topping;
        this.bottom = bottom;
        this.price = topping.getPrice() + bottom.getPrice();
        this.quantity = 1;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
