/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import data.DataMapper;
import java.sql.SQLException;

/**
 *
 * @author Lovro
 */
public class CupcakeFacade {
    private DataMapper dm = new DataMapper();
    
    public static String[] getToppings() {
    String[] toppings = {"Chocolate", "Blueberry", "Rasberry", "Crispy", "Strawberry", "Rum/Raisin", "Orange", "Lemon", "Blue cheese"};
          return toppings;
}
    public static String[] getBottoms() {
         String[] bottoms = {"Chocolate", "Vanilla", "Nutmeg", "Pistacio", "Almond"};
         return bottoms;
    }
    
    public Cupcake getCupcake(String topping, String bottom) throws SQLException, NullPointerException {
        return dm.getCupcake(topping, bottom);
    }
}
