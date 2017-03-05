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
public class OrderLine {
    private Cupcake cupcake;
    private int quantity;
    private Topping topping;
    private Bottom bottom;
   
public OrderLine() {
    
}
    public OrderLine(Cupcake cupcake, int quantity) {
        this.cupcake = cupcake;
        this.quantity = quantity;
        this.topping = topping;
        this.bottom = bottom;
    }
    public double getPrice() {
        return quantity*(topping.getPrice() + bottom.getPrice());
    }
}
